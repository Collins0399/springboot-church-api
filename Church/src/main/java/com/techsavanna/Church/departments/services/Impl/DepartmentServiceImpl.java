package com.techsavanna.Church.departments.services.Impl;

import com.techsavanna.Church.departments.dtos.*;
import com.techsavanna.Church.departments.mappers.DepartmentMapper;
import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.departments.repos.DepartmentRepository;
import com.techsavanna.Church.departments.services.DepartmentService;
import com.techsavanna.Church.handler.ResourceNotFoundException;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, MemberRepository memberRepository) {
        this.departmentRepository = departmentRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public ApiResponse<DepartmentResponseDto> createDepartment(DepartmentCreateDto dto) {
        Member leader = memberRepository.findById(dto.getLeaderId())
                .orElseThrow(() -> new ResourceNotFoundException("Leader not found with ID: " + dto.getLeaderId()));

        Department department = DepartmentMapper.toEntity(dto, leader);
        Department saved = departmentRepository.save(department);

        return new ApiResponse<>("success", "Department created successfully", DepartmentMapper.toResponseDto(saved));
    }

    @Override
    public ApiResponse<DepartmentResponseDto> updateDepartment(Long departmentId, DepartmentUpdateDto dto) {
        Department existing = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + departmentId));

        Member leader = null;
        if (dto.getLeaderId() != null) {
            leader = memberRepository.findById(dto.getLeaderId())
                    .orElseThrow(() -> new ResourceNotFoundException("Leader not found with ID: " + dto.getLeaderId()));
        }

        DepartmentMapper.updateEntity(existing, dto, leader);
        Department updated = departmentRepository.save(existing);

        return new ApiResponse<>("success", "Department updated successfully", DepartmentMapper.toResponseDto(updated));
    }

    @Override
    public ApiResponse<Void> deleteDepartment(Long departmentId) {
        if (!departmentRepository.existsById(departmentId)) {
            throw new ResourceNotFoundException("Department not found with ID: " + departmentId);
        }
        departmentRepository.deleteById(departmentId);
        return new ApiResponse<>("success", "Department deleted successfully", null);
    }

    @Override
    public ApiResponse<DepartmentResponseDto> getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + departmentId));
        return new ApiResponse<>("success", "Department fetched successfully", DepartmentMapper.toResponseDto(department));
    }

    @Override
    public ApiResponse<List<DepartmentResponseDto>> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponseDto> responseList = departments.stream()
                .map(DepartmentMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "All departments retrieved successfully", responseList);
    }
}
