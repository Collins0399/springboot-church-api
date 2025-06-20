package com.techsavanna.Church.departments.controllers;

import com.techsavanna.Church.departments.dtos.DepartmentCreateDto;
import com.techsavanna.Church.departments.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentControllers {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentCreateDto> createDepartment(@RequestBody DepartmentCreateDto departmentCreateDto) {
        DepartmentCreateDto createdDepartment = departmentService.createDepartment(departmentCreateDto);
        return ResponseEntity.ok(createdDepartment);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentCreateDto> updateDepartment(@PathVariable Long departmentId, @RequestBody DepartmentCreateDto departmentCreateDto) {
        DepartmentCreateDto updatedDepartment = departmentService.updateDepartment(departmentId, departmentCreateDto);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentCreateDto> getDepartmentById(@PathVariable Long departmentId) {
        DepartmentCreateDto department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentCreateDto>> getAllDepartments() {
        List<DepartmentCreateDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

}
