package com.techsavanna.Church.contributions.services;

import com.techsavanna.Church.contributions.dtos.ContributionCreateDto;
import com.techsavanna.Church.contributions.dtos.ContributionResponseDto;
import com.techsavanna.Church.contributions.dtos.ContributionUpdateDto;
import com.techsavanna.Church.enums.PaymentMethod;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContributionService {
    ApiResponse<ContributionResponseDto> createContribution(ContributionCreateDto dto);
    ApiResponse<ContributionResponseDto> updateContribution(Long contributionId , ContributionUpdateDto dto);
    ApiResponse<Void> deleteContribution(Long contributionId);
    ApiResponse<ContributionResponseDto> getContributionById(Long contributionId);
    ApiResponse<Page<ContributionResponseDto>> getAllContributions(Pageable pageable);
    ApiResponse<Page<ContributionResponseDto>> getContributionsByPaymentMethod(PaymentMethod paymentMethod, Pageable pageable);
    ApiResponse<Page<ContributionResponseDto>>getContributionsByMemberAndPaymentMethod(Long memberId, PaymentMethod method, Pageable pageable);
}
