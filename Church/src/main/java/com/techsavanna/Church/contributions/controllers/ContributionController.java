package com.techsavanna.Church.contributions.controllers;

import com.techsavanna.Church.contributions.dtos.ContributionCreateDto;
import com.techsavanna.Church.contributions.dtos.ContributionResponseDto;
import com.techsavanna.Church.contributions.dtos.ContributionUpdateDto;
import com.techsavanna.Church.contributions.services.ContributionService;
import com.techsavanna.Church.enums.PaymentMethod;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.responses.ApiResponse;
import com.techsavanna.Church.handler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/contributions")
public class ContributionController {

    @Autowired
    private ContributionService contributionService;

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping
    public ApiResponse<ContributionResponseDto> createContribution(@RequestBody ContributionCreateDto dto) {
        return contributionService.createContribution(dto);
    }

    @PutMapping("/{contributionId}")
    public ApiResponse<ContributionResponseDto> updateContribution(@PathVariable Long contributionId, @RequestBody ContributionUpdateDto dto) {
        return contributionService.updateContribution(contributionId, dto);
    }

    @DeleteMapping("/{contributionId}")
    public ApiResponse<Void> deleteContribution(@PathVariable Long contributionId) {
        return contributionService.deleteContribution(contributionId);
    }

    @GetMapping("/{contributionId}")
    public ApiResponse<ContributionResponseDto> getContributionById(@PathVariable Long contributionId) {
        return contributionService.getContributionById(contributionId);
    }

    @GetMapping
    public ApiResponse<Page<ContributionResponseDto>> getAllContributions(Pageable pageable) {
        return contributionService.getAllContributions(pageable);
    }

    @GetMapping("/by-payment-method")
    public ApiResponse<Page<ContributionResponseDto>> getByPaymentMethod(@RequestParam PaymentMethod method, Pageable pageable) {
        return contributionService.getContributionsByPaymentMethod(method, pageable);
    }

    @GetMapping("/by-member-method")
    public ApiResponse<Page<ContributionResponseDto>> getByMemberAndPaymentMethod(@RequestParam Long memberId, @RequestParam PaymentMethod method, Pageable pageable) {
        return contributionService.getContributionsByMemberAndPaymentMethod(memberId, method, pageable);
    }
}
