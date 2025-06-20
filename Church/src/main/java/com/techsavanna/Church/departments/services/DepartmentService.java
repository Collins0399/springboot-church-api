package com.techsavanna.Church.departments.services;

import com.techsavanna.Church.departments.dtos.*;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentCreateDto dto);
    DepartmentResponseDto updateDepartment(Long departmentId, DepartmentUpdateDto dto);
    void deleteDepartment(Long departmentId);
    DepartmentResponseDto getDepartmentById(Long departmentId);
    List<DepartmentResponseDto> getAllDepartments();
}
