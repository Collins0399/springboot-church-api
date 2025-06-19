package com.techsavanna.Church.departments.services.Impl;

import com.techsavanna.Church.departments.dtos.DepartmentDto;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.departments.repos.DepartmentRepository;
import com.techsavanna.Church.departments.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    //Method to map DepartmentDto to Departments entity
    private DepartmentDto mapToDto(Department department) {
        DepartmentDto dto = new DepartmentDto();
        dto.setDepartmentId(department.getDepartmentId());
        dto.setName(department.getName());
        dto.setDescription(department.getDescription());
        dto.setCreatedDate(department.getCreatedDate());
        dto.setLeaderName(department.getLeaderName());
        dto.setMeetingSchedule(department.getMeetingSchedule());
        return dto;
    }

    //method to map Departments entity to DepartmentDto
    private Department mapToEntity(DepartmentDto dto) {
        Department department = new Department();
        department.setDepartmentId(dto.getDepartmentId());
        department.setName(dto.getName());
        department.setDescription(dto.getDescription());
        department.setCreatedDate(dto.getCreatedDate());
        department.setLeaderName(dto.getLeaderName());

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
        existing.setLeaderName(departmentDto.getLeaderName());
        existing.setMeetingSchedule(departmentDto.getMeetingSchedule());

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
