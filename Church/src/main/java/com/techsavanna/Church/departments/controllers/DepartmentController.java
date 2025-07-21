package com.techsavanna.Church.departments.controllers;

import com.techsavanna.Church.departments.dtos.*;
import com.techsavanna.Church.departments.services.DepartmentService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ApiResponse<DepartmentResponseDto> createDepartment(@RequestBody DepartmentCreateDto dto) {
        return departmentService.createDepartment(dto);
    }

    @PutMapping("/{id}")
    public ApiResponse<DepartmentResponseDto> updateDepartment(@PathVariable Long id, @RequestBody DepartmentUpdateDto dto) {
        return departmentService.updateDepartment(id, dto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteDepartment(@PathVariable Long id) {
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/{id}")
    public ApiResponse<DepartmentResponseDto> getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping
    public ApiResponse<Page<DepartmentResponseDto>> getAllDepartments(Pageable pageable) {
        return departmentService.getAllDepartments(pageable);
    }
}
