package com.techsavanna.Church.departments.services.Impl;

import com.techsavanna.Church.departments.dtos.DepartmentDto;

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
    private DepartmentDto mapToDto(Department department) {
        DepartmentDto dto = new DepartmentDto();
        dto.setName(department.getName());
        dto.setDescription(department.getDescription());
        dto.setCreatedDate(department.getCreatedDate());
        dto.setLeaderId(department.getLeader() != null ? department.getLeader().getMemberId() : null);
        dto.setMeetingSchedule(department.getMeetingSchedule());
        return dto;
    }

    //method to map Departments entity to DepartmentDto
    private Department mapToEntity(DepartmentDto dto) {
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
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = mapToEntity( departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return mapToDto(savedDepartment);
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto){
        Department existing = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with id: "));

        existing.setName(departmentDto.getName());
        existing.setDescription(departmentDto.getDescription());
        existing.setCreatedDate(departmentDto.getCreatedDate());
        existing.setMeetingSchedule(departmentDto.getMeetingSchedule());
        if (departmentDto.getLeaderId() != null) {
            Member leader = memberRepository.findById(departmentDto.getLeaderId())
                    .orElseThrow(() -> new RuntimeException("Leader not found with ID: " + departmentDto.getLeaderId()));
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
    public DepartmentDto getDepartmentById(Long departmentId) {
        Optional<Department> department= departmentRepository .findById( departmentId);
        return department.map(this::mapToDto).orElse(null);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

}
