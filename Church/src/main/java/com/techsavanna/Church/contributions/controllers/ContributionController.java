package com.techsavanna.Church.contributions.controllers;

import com.techsavanna.Church.contributions.dtos.ContributionCreateDto;
import com.techsavanna.Church.contributions.dtos.ContributionResponseDto;
import com.techsavanna.Church.contributions.dtos.ContributionUpdateDto;
import com.techsavanna.Church.contributions.services.ContributionService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributions")
public class ContributionController {

    @Autowired
    private ContributionService contributionService;

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
    public ApiResponse<List<ContributionResponseDto>> getAllContributions() {
        return contributionService.getAllContributions();
    }
}
