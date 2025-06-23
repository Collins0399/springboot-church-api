package com.techsavanna.Church.contributions.services;

import com.techsavanna.Church.contributions.dtos.ContributionCreateDto;
import com.techsavanna.Church.contributions.dtos.ContributionResponseDto;
import com.techsavanna.Church.contributions.dtos.ContributionUpdateDto;

import java.util.List;

public interface ContributionService {
    ContributionResponseDto createContribution(ContributionCreateDto dto);
    ContributionResponseDto updateContribution(Long contributionId , ContributionUpdateDto dto);
    void deleteContribution(Long contributionId);
    ContributionResponseDto getContributionById(Long contributionId);
    List<ContributionResponseDto> getAllContributions();
}
