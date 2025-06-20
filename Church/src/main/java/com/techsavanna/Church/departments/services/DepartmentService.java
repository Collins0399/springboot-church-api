package com.techsavanna.Church.departments.services;

import com.techsavanna.Church.departments.dtos.DepartmentCreateDto;

import java.util.List;

public interface DepartmentService {
    DepartmentCreateDto createDepartment(DepartmentCreateDto departmentCreateDto);
    DepartmentCreateDto updateDepartment(Long departmentId, DepartmentCreateDto departmentCreateDto);
    void deleteDepartment(Long departmentId);
    DepartmentCreateDto getDepartmentById(Long departmentId);
    List <DepartmentCreateDto> getAllDepartments();
}
