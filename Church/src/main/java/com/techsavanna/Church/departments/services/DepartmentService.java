package com.techsavanna.Church.departments.services;

import com.techsavanna.Church.departments.dtos.*;
import com.techsavanna.Church.responses.ApiResponse;

import java.util.List;

public interface DepartmentService {
    ApiResponse<DepartmentResponseDto> createDepartment(DepartmentCreateDto dto);
    ApiResponse<DepartmentResponseDto> updateDepartment(Long departmentId, DepartmentUpdateDto dto);
    ApiResponse<Void> deleteDepartment(Long departmentId);
    ApiResponse<DepartmentResponseDto> getDepartmentById(Long departmentId);
    ApiResponse<List<DepartmentResponseDto>> getAllDepartments();
}
