package com.techsavanna.Church.departments.services.Impl;

import com.techsavanna.Church.departments.dtos.DepartmentCreateDto;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.departments.repos.DepartmentRepository;
import com.techsavanna.Church.departments.services.DepartmentService;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private MemberRepository memberRepository;


    //Method to map DepartmentDto to Departments entity
    private DepartmentCreateDto mapToDto(Department department) {
        DepartmentCreateDto dto = new DepartmentCreateDto();
        dto.setName(department.getName());
        dto.setDescription(department.getDescription());
        dto.setCreatedDate(department.getCreatedDate());
        dto.setLeaderId(department.getLeader() != null ? department.getLeader().getMemberId() : null);
        dto.setMeetingSchedule(department.getMeetingSchedule());
        return dto;
    }

    //method to map Departments entity to DepartmentDto
    private Department mapToEntity(DepartmentCreateDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setDescription(dto.getDescription());
        department.setCreatedDate(dto.getCreatedDate());
        if (dto.getLeaderId() != null) {
            Member leader = memberRepository.findById(dto.getLeaderId())
                    .orElseThrow(() -> new RuntimeException("Leader not found with ID: " + dto.getLeaderId()));
            department.setLeader(leader);
        }

        department.setMeetingSchedule(dto.getMeetingSchedule());
        return department;
    }

    @Override
    public DepartmentCreateDto createDepartment(DepartmentCreateDto departmentCreateDto) {
        Department department = mapToEntity(departmentCreateDto);
        Department savedDepartment = departmentRepository.save(department);
        return mapToDto(savedDepartment);
    }

    @Override
    public DepartmentCreateDto updateDepartment(Long departmentId, DepartmentCreateDto departmentCreateDto){
        Department existing = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with id: "));

        existing.setName(departmentCreateDto.getName());
        existing.setDescription(departmentCreateDto.getDescription());
        existing.setCreatedDate(departmentCreateDto.getCreatedDate());
        existing.setMeetingSchedule(departmentCreateDto.getMeetingSchedule());
        if (departmentCreateDto.getLeaderId() != null) {
            Member leader = memberRepository.findById(departmentCreateDto.getLeaderId())
                    .orElseThrow(() -> new RuntimeException("Leader not found with ID: " + departmentCreateDto.getLeaderId()));
            existing.setLeader(leader);
        }

        Department saved = departmentRepository.save(existing);

        return mapToDto(saved);
    }

    @Override
    public void deleteDepartment(Long departmentId){
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public DepartmentCreateDto getDepartmentById(Long departmentId) {
        Optional<Department> department= departmentRepository .findById( departmentId);
        return department.map(this::mapToDto).orElse(null);
    }

    @Override
    public List<DepartmentCreateDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

}
