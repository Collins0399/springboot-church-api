package com.techsavanna.Church.contributions.controllers;

import com.techsavanna.Church.contributions.dtos.ContributionCreateDto;
import com.techsavanna.Church.contributions.dtos.ContributionResponseDto;
import com.techsavanna.Church.contributions.dtos.ContributionUpdateDto;
import com.techsavanna.Church.contributions.services.ContributionService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributions")
public class ContributionController {

    @Autowired
    private ContributionService contributionService;

    @PostMapping
    public ResponseEntity<ApiResponse<ContributionResponseDto>> createContribution(@RequestBody ContributionCreateDto dto) {
        ContributionResponseDto result = contributionService.createContribution(dto);
        ApiResponse<ContributionResponseDto> response = new ApiResponse<>("success", "Contribution created successfully", result);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{contributionId}")
    public ResponseEntity<ApiResponse<ContributionResponseDto>> updateContribution(@PathVariable Long contributionId, @RequestBody ContributionUpdateDto dto) {
        ContributionResponseDto result = contributionService.updateContribution(contributionId, dto);
        ApiResponse<ContributionResponseDto> response = new ApiResponse<>("success", "Contribution updated successfully", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{contributionId}")
    public ResponseEntity<ApiResponse<String>> deleteContribution(@PathVariable Long contributionId) {
        contributionService.deleteContribution(contributionId);
        ApiResponse<String> response = new ApiResponse<>("success", "Contribution deleted successfully", "Contribution deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{contributionId}")
    public ResponseEntity<ApiResponse<ContributionResponseDto>> getContributionById(@PathVariable Long contributionId) {
        ContributionResponseDto result = contributionService.getContributionById(contributionId);
        ApiResponse<ContributionResponseDto> response = new ApiResponse<>("success", "Contribution fetched successfully", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ContributionResponseDto>>> getAllContributions() {
        List<ContributionResponseDto> contributions = contributionService.getAllContributions();
        ApiResponse<List<ContributionResponseDto>> response = new ApiResponse<>("success", "All contributions retrieved successfully", contributions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
