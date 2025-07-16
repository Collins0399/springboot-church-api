package com.techsavanna.Church.families.services;

import com.techsavanna.Church.families.dtos.FamilyCreateDto;
import com.techsavanna.Church.families.dtos.FamilyResponseDto;
import com.techsavanna.Church.families.dtos.FamilyUpdateDto;
import com.techsavanna.Church.responses.ApiResponse;

import java.util.List;

public interface FamilyService {
    ApiResponse<FamilyResponseDto> createFamily(FamilyCreateDto dto);
    ApiResponse<FamilyResponseDto> updateFamily(Long familyId , FamilyUpdateDto dto);
    ApiResponse<Void> deleteFamily(Long familyId);
    ApiResponse<FamilyResponseDto> getFamilyById(Long familyId);
    ApiResponse<List<FamilyResponseDto>> getAllFamilies();
}
