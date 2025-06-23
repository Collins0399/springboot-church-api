package com.techsavanna.Church.families.services;

import com.techsavanna.Church.families.dtos.FamilyCreateDto;
import com.techsavanna.Church.families.dtos.FamilyResponseDto;
import com.techsavanna.Church.families.dtos.FamilyUpdateDto;

import java.util.List;

public interface FamilyService {
    FamilyResponseDto createFamily(FamilyCreateDto dto);
    FamilyResponseDto updateFamily(Long familyId , FamilyUpdateDto dto);
    void deleteFamily(Long familyId);
    FamilyResponseDto getFamilyById(Long familyId);
    List<FamilyResponseDto> getAllFamilies();
}
