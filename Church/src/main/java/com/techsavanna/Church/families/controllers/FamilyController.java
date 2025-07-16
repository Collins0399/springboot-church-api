package com.techsavanna.Church.families.controllers;

import com.techsavanna.Church.families.dtos.FamilyCreateDto;
import com.techsavanna.Church.families.dtos.FamilyResponseDto;
import com.techsavanna.Church.families.dtos.FamilyUpdateDto;
import com.techsavanna.Church.families.services.FamilyService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/families")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @PostMapping
    public ApiResponse<FamilyResponseDto> createFamily(@RequestBody FamilyCreateDto dto) {
        return familyService.createFamily(dto);
    }

    @PutMapping("/{familyId}")
    public ApiResponse<FamilyResponseDto> updateFamily(@PathVariable Long familyId, @RequestBody FamilyUpdateDto dto) {
        return familyService.updateFamily(familyId, dto);
    }

    @DeleteMapping("/{familyId}")
    public ApiResponse<Void> deleteFamily(@PathVariable Long familyId) {
        return familyService.deleteFamily(familyId);
    }

    @GetMapping("/{familyId}")
    public ApiResponse<FamilyResponseDto> getFamilyById(@PathVariable Long familyId) {
        return familyService.getFamilyById(familyId);
    }

    @GetMapping
    public ApiResponse<List<FamilyResponseDto>> getAllFamilies() {
        return familyService.getAllFamilies();
    }
}
