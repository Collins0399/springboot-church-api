package com.techsavanna.Church.families.services.Impl;

import com.techsavanna.Church.families.dtos.FamilyCreateDto;
import com.techsavanna.Church.families.dtos.FamilyResponseDto;
import com.techsavanna.Church.families.dtos.FamilyUpdateDto;
import com.techsavanna.Church.families.models.Family;
import com.techsavanna.Church.families.repos.FamilyRepository;
import com.techsavanna.Church.families.services.FamilyService;
import com.techsavanna.Church.mappers.FamilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public FamilyResponseDto createFamily(FamilyCreateDto dto) {
        Family family = FamilyMapper.toEntity(dto);
        Family savedFamily = familyRepository.save(family);
        return FamilyMapper.toResponseDto(savedFamily);
    }

    @Override
    public FamilyResponseDto updateFamily(Long familyId, FamilyUpdateDto dto) {
        Family family = familyRepository.findById(familyId)
                .orElseThrow(() -> new RuntimeException("Family not found"));
        Family updated = FamilyMapper.toUpdatedEntity(family, dto);
        return FamilyMapper.toResponseDto(familyRepository.save(updated));
    }

    @Override
    public void deleteFamily(Long familyId) {
        if (!familyRepository.existsById(familyId)) {
            throw new RuntimeException("Family not found");
        }
        familyRepository.deleteById(familyId);
    }

    @Override
    public FamilyResponseDto getFamilyById(Long familyId) {
        Family family = familyRepository.findById(familyId)
                .orElseThrow(() -> new RuntimeException("Family with ID " + familyId + " not found"));
        return FamilyMapper.toResponseDto(family);
    }

    @Override
    public List<FamilyResponseDto> getAllFamilies() {
        return familyRepository.findAll()
                .stream()
                .map(FamilyMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}
