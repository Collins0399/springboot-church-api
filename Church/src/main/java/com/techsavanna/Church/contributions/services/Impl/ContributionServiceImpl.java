package com.techsavanna.Church.contributions.services.Impl;

import com.techsavanna.Church.contributions.dtos.ContributionCreateDto;
import com.techsavanna.Church.contributions.dtos.ContributionResponseDto;
import com.techsavanna.Church.contributions.dtos.ContributionUpdateDto;
import com.techsavanna.Church.contributions.mappers.ContributionMapper;
import com.techsavanna.Church.contributions.models.Contribution;
import com.techsavanna.Church.contributions.repos.ContributionRepository;
import com.techsavanna.Church.contributions.services.ContributionService;
import com.techsavanna.Church.handler.ResourceNotFoundException;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    private ContributionRepository contributionRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ApiResponse<ContributionResponseDto> createContribution(ContributionCreateDto dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + dto.getMemberId()));

        Contribution contribution = ContributionMapper.toEntity(dto, member);
        Contribution saved = contributionRepository.save(contribution);

        return new ApiResponse<>("success", "Contribution created successfully", ContributionMapper.toResponseDto(saved));
    }

    @Override
    public ApiResponse<ContributionResponseDto> updateContribution(Long contributionId, ContributionUpdateDto dto) {
        Contribution contribution = contributionRepository.findById(contributionId)
                .orElseThrow(() -> new ResourceNotFoundException("Contribution not found with ID: " + contributionId));

        ContributionMapper.updateEntity(contribution, dto);
        Contribution updated = contributionRepository.save(contribution);

        return new ApiResponse<>("success", "Contribution updated successfully", ContributionMapper.toResponseDto(updated));
    }

    @Override
    public ApiResponse<Void> deleteContribution(Long contributionId) {
        if (!contributionRepository.existsById(contributionId)) {
            throw new ResourceNotFoundException("Contribution not found with ID: " + contributionId);
        }
        contributionRepository.deleteById(contributionId);
        return new ApiResponse<>("success", "Contribution deleted successfully", null);
    }

    @Override
    public ApiResponse<ContributionResponseDto> getContributionById(Long contributionId) {
        Contribution contribution = contributionRepository.findById(contributionId)
                .orElseThrow(() -> new ResourceNotFoundException("Contribution not found with ID: " + contributionId));

        return new ApiResponse<>("success", "Contribution fetched successfully", ContributionMapper.toResponseDto(contribution));
    }

    @Override
    public ApiResponse<List<ContributionResponseDto>> getAllContributions() {
        List<ContributionResponseDto> list = contributionRepository.findAll()
                .stream()
                .map(ContributionMapper::toResponseDto)
                .collect(Collectors.toList());

        return new ApiResponse<>("success", "All contributions retrieved successfully", list);
    }
}
