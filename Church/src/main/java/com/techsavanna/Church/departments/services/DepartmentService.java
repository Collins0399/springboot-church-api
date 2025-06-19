package com.techsavanna.Church.departments.services;

import com.techsavanna.Church.departments.dtos.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto);
    void deleteDepartment(Long departmentId);
    DepartmentDto getDepartmentById(Long departmentId);
    List <DepartmentDto> getAllDepartments();
}
