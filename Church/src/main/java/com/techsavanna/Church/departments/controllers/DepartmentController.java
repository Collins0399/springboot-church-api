package com.techsavanna.Church.departments.controllers;

import com.techsavanna.Church.departments.dtos.*;
import com.techsavanna.Church.departments.services.DepartmentService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "http://localhost:5173")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentResponseDto>> createDepartment(@RequestBody DepartmentCreateDto dto) {
        DepartmentResponseDto created = departmentService.createDepartment(dto);
        ApiResponse<DepartmentResponseDto> response = new ApiResponse<>("success", "Department created successfully", created);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponseDto>> updateDepartment(@PathVariable Long id, @RequestBody DepartmentUpdateDto dto) {
        DepartmentResponseDto updated = departmentService.updateDepartment(id, dto);
        ApiResponse<DepartmentResponseDto> response = new ApiResponse<>("success", "Department updated successfully", updated);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        ApiResponse<String> response = new ApiResponse<>("success", "Department deleted successfully", "Department deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponseDto>> getDepartmentById(@PathVariable Long id) {
        DepartmentResponseDto department = departmentService.getDepartmentById(id);
        ApiResponse<DepartmentResponseDto> response = new ApiResponse<>("success", "Department fetched successfully", department);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentResponseDto>>> getAllDepartments() {
        List<DepartmentResponseDto> departments = departmentService.getAllDepartments();
        ApiResponse<List<DepartmentResponseDto>> response = new ApiResponse<>("success", "All departments retrieved successfully", departments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
