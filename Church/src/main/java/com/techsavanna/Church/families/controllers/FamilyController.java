package com.techsavanna.Church.families.controllers;

import com.techsavanna.Church.families.dtos.FamilyCreateDto;
import com.techsavanna.Church.families.dtos.FamilyResponseDto;
import com.techsavanna.Church.families.dtos.FamilyUpdateDto;
import com.techsavanna.Church.families.services.FamilyService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/families")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @PostMapping
    public ResponseEntity<ApiResponse<FamilyResponseDto>> createFamily(@RequestBody FamilyCreateDto familyDto) {
        FamilyResponseDto createdFamily = familyService.createFamily(familyDto);
        ApiResponse<FamilyResponseDto> response = new ApiResponse<>("success", "Family created successfully", createdFamily);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{familyId}")
    public ResponseEntity<ApiResponse<FamilyResponseDto>> updateFamily(@PathVariable Long familyId, @RequestBody FamilyUpdateDto familyDto) {
        FamilyResponseDto updatedFamily = familyService.updateFamily(familyId, familyDto);
        ApiResponse<FamilyResponseDto> response = new ApiResponse<>("success", "Family updated successfully", updatedFamily);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{familyId}")
    public ResponseEntity<ApiResponse<Void>> deleteFamily(@PathVariable Long familyId) {
        familyService.deleteFamily(familyId);
        ApiResponse<Void> response = new ApiResponse<>("success", "Family deleted successfully", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{familyId}")
    public ResponseEntity<ApiResponse<FamilyResponseDto>> getByFamilyId(@PathVariable Long familyId) {
        FamilyResponseDto familyDto = familyService.getFamilyById(familyId);
        ApiResponse<FamilyResponseDto> response = new ApiResponse<>("success", "Family fetched successfully", familyDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<FamilyResponseDto>>> getAllFamilies() {
        List<FamilyResponseDto> families = familyService.getAllFamilies();
        ApiResponse<List<FamilyResponseDto>> response = new ApiResponse<>("success", "All families retrieved successfully", families);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
