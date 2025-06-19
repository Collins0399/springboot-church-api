package com.techsavanna.Church.departments.services.Impl;

import com.techsavanna.Church.departments.dtos.DepartmentDto;

import com.techsavanna.Church.departments.models.Departments;
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
    private DepartmentDto mapToDto(Departments department) {
        DepartmentDto dto = new DepartmentDto();
        dto.setDepartmentId(department.getDepartmentId());
        dto.setName(department.getName());
        dto.setDescription(department.getDescription());
        dto.setCreatedDate(department.getCreatedDate());
        dto.setLeaderName(department.getLeaderName());
        dto.setLeaderPhone(department.getLeaderPhone());
        dto.setLeaderEmail(department.getLeaderEmail());
        dto.setNumberOfMembers(department.getNumberOfMembers());
        dto.setMeetingSchedule(department.getMeetingSchedule());
        dto.setLocation(department.getLocation());
        dto.setIsActive(department.getIsActive());
        dto.setNotes(department.getNotes());
        return dto;
    }

    //method to map Departments entity to DepartmentDto
    private Departments mapToEntity(DepartmentDto dto) {
        Departments department = new Departments();
        department.setDepartmentId(dto.getDepartmentId());
        department.setName(dto.getName());
        department.setDescription(dto.getDescription());
        department.setCreatedDate(dto.getCreatedDate());
        department.setLeaderName(dto.getLeaderName());
        department.setLeaderPhone(dto.getLeaderPhone());
        department.setLeaderEmail(dto.getLeaderEmail());
        department.setNumberOfMembers(dto.getNumberOfMembers());
        department.setMeetingSchedule(dto.getMeetingSchedule());
        department.setLocation(dto.getLocation());
        department.setIsActive(dto.getIsActive());
        department.setNotes(dto.getNotes());
        return department;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Departments department = mapToEntity( departmentDto);
        Departments savedDepartment = departmentRepository.save(department);
        return mapToDto(savedDepartment);
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto){
        Departments existing = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with id: "));

        existing.setName(departmentDto.getName());
        existing.setDescription(departmentDto.getDescription());
        existing.setCreatedDate(departmentDto.getCreatedDate());
        existing.setLeaderName(departmentDto.getLeaderName());
        existing.setLeaderPhone(departmentDto.getLeaderPhone());
        existing.setLeaderEmail(departmentDto.getLeaderEmail());
        existing.setNumberOfMembers(departmentDto.getNumberOfMembers());
        existing.setMeetingSchedule(departmentDto.getMeetingSchedule());
        existing.setLocation(departmentDto.getLocation());
        existing.setIsActive(departmentDto.getIsActive());
        existing.setNotes(departmentDto.getNotes());

        Departments saved = departmentRepository.save(existing);

        return mapToDto(saved);
    }

    @Override
    public void deleteDepartment(Long departmentId){
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Optional<Departments> department= departmentRepository .findById( departmentId);
        return department.map(this::mapToDto).orElse(null);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Departments> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

}
