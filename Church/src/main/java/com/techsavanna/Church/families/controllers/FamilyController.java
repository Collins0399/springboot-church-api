package com.techsavanna.Church.families.controllers;

import com.techsavanna.Church.families.dtos.FamilyCreateDto;
import com.techsavanna.Church.families.dtos.FamilyResponseDto;
import com.techsavanna.Church.families.dtos.FamilyUpdateDto;
import com.techsavanna.Church.families.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/families")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @PostMapping
    public ResponseEntity<FamilyResponseDto> createFamily(@RequestBody FamilyCreateDto familyDto) {
        FamilyResponseDto createdFamily = familyService.createFamily(familyDto);
        return ResponseEntity.ok(createdFamily);
    }

    @PutMapping("/{familyId}")
    public ResponseEntity<FamilyResponseDto> updateFamily(@PathVariable Long familyId, @RequestBody FamilyUpdateDto familyDto) {
        FamilyResponseDto updatedFamily = familyService.updateFamily(familyId, familyDto);
        return ResponseEntity.ok(updatedFamily);
    }

    @DeleteMapping("/{familyId}")
    public ResponseEntity<Void> deleteFamily(@PathVariable Long familyId) {
        familyService.deleteFamily(familyId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{familyId}")
    public ResponseEntity<FamilyResponseDto> getByFamilyId(@PathVariable Long familyId) {
        FamilyResponseDto familyDto = familyService.getFamilyById(familyId);
        return ResponseEntity.ok(familyDto);
    }

    @GetMapping
    public ResponseEntity<List<FamilyResponseDto>> getAllFamilies() {
        List<FamilyResponseDto> families = familyService.getAllFamilies();
        return ResponseEntity.ok(families);
    }
}
