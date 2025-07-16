package com.techsavanna.Church.contributions.services;

import com.techsavanna.Church.contributions.dtos.ContributionCreateDto;
import com.techsavanna.Church.contributions.dtos.ContributionResponseDto;
import com.techsavanna.Church.contributions.dtos.ContributionUpdateDto;
import com.techsavanna.Church.responses.ApiResponse;

import java.util.List;

public interface ContributionService {
    ApiResponse<ContributionResponseDto> createContribution(ContributionCreateDto dto);
    ApiResponse<ContributionResponseDto> updateContribution(Long contributionId , ContributionUpdateDto dto);
    ApiResponse<Void> deleteContribution(Long contributionId);
    ApiResponse<ContributionResponseDto> getContributionById(Long contributionId);
    ApiResponse<List<ContributionResponseDto>> getAllContributions();
}
