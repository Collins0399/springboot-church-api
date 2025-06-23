package com.techsavanna.Church.contributions.controllers;

import com.techsavanna.Church.contributions.dtos.ContributionCreateDto;
import com.techsavanna.Church.contributions.dtos.ContributionResponseDto;
import com.techsavanna.Church.contributions.dtos.ContributionUpdateDto;
import com.techsavanna.Church.contributions.services.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributions")
public class ContributionController {

    @Autowired
    private ContributionService contributionService;

    @PostMapping
    public ResponseEntity<ContributionResponseDto> createContribution(@RequestBody ContributionCreateDto dto) {
        return ResponseEntity.ok(contributionService.createContribution(dto));
    }

    @PutMapping("/{contributionId}")
    public ResponseEntity<ContributionResponseDto> updateContribution(@PathVariable Long contributionId, @RequestBody ContributionUpdateDto dto) {
        return ResponseEntity.ok(contributionService.updateContribution(contributionId, dto));
    }

    @DeleteMapping("/{contributionId}")
    public ResponseEntity<String> deleteContribution(@PathVariable Long contributionId) {
        contributionService.deleteContribution(contributionId);
        return ResponseEntity.ok("Contribution deleted successfully.");
    }

    @GetMapping("/{contributionId}")
    public ResponseEntity<ContributionResponseDto> getContributionById(@PathVariable Long contributionId) {
        return ResponseEntity.ok(contributionService.getContributionById(contributionId));
    }

    @GetMapping
    public ResponseEntity<List<ContributionResponseDto>> getAllContributions() {
        return ResponseEntity.ok(contributionService.getAllContributions());
    }
}
