package com.techsavanna.Church.families.services.Impl;

import com.techsavanna.Church.handler.ResourceNotFoundException;
import com.techsavanna.Church.families.dtos.FamilyCreateDto;
import com.techsavanna.Church.families.dtos.FamilyResponseDto;
import com.techsavanna.Church.families.dtos.FamilyUpdateDto;
import com.techsavanna.Church.families.mappers.FamilyMapper;
import com.techsavanna.Church.families.models.Family;
import com.techsavanna.Church.families.repos.FamilyRepository;
import com.techsavanna.Church.families.services.FamilyService;
import com.techsavanna.Church.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public ApiResponse<FamilyResponseDto> createFamily(FamilyCreateDto dto) {
        Family family = FamilyMapper.toEntity(dto);
        Family saved = familyRepository.save(family);
        FamilyResponseDto responseDto = FamilyMapper.toResponseDto(saved);
        return new ApiResponse<>("success", "Family created successfully", responseDto);
    }

    @Override
    public ApiResponse<FamilyResponseDto> updateFamily(Long familyId, FamilyUpdateDto dto) {
        Family family = familyRepository.findById(familyId)
                .orElseThrow(() -> new ResourceNotFoundException("Family not found with ID: " + familyId));

        Family updated = FamilyMapper.toUpdatedEntity(family, dto);
        FamilyResponseDto responseDto = FamilyMapper.toResponseDto(familyRepository.save(updated));
        return new ApiResponse<>("success", "Family updated successfully", responseDto);
    }

    @Override
    public ApiResponse<Void> deleteFamily(Long familyId) {
        if (!familyRepository.existsById(familyId)) {
            throw new ResourceNotFoundException("Family not found with ID: " + familyId);
        }
        familyRepository.deleteById(familyId);
        return new ApiResponse<>("success", "Family deleted successfully", null);
    }

    @Override
    public ApiResponse<FamilyResponseDto> getFamilyById(Long familyId) {
        Family family = familyRepository.findById(familyId)
                .orElseThrow(() -> new ResourceNotFoundException("Family with ID " + familyId + " not found"));

        return new ApiResponse<>("success", "Family retrieved successfully", FamilyMapper.toResponseDto(family));
    }

    @Override
    public ApiResponse<List<FamilyResponseDto>> getAllFamilies() {
        List<FamilyResponseDto> families = familyRepository.findAll()
                .stream()
                .map(FamilyMapper::toResponseDto)
                .collect(Collectors.toList());

        return new ApiResponse<>("success", "All families retrieved successfully", families);
    }
}
