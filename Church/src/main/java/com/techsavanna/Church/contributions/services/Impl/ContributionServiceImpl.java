package com.techsavanna.Church.contributions.services.Impl;

import com.techsavanna.Church.contributions.dtos.ContributionCreateDto;
import com.techsavanna.Church.contributions.dtos.ContributionResponseDto;
import com.techsavanna.Church.contributions.dtos.ContributionUpdateDto;
import com.techsavanna.Church.contributions.mappers.ContributionMapper;
import com.techsavanna.Church.contributions.models.Contribution;
import com.techsavanna.Church.contributions.repos.ContributionRepository;
import com.techsavanna.Church.contributions.services.ContributionService;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
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
    public ContributionResponseDto createContribution(ContributionCreateDto dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found with ID: " + dto.getMemberId()));
        Contribution contribution = ContributionMapper.toEntity(dto, member);
        Contribution saved = contributionRepository.save(contribution);
        return ContributionMapper.toResponseDto(saved);
    }

    @Override
    public ContributionResponseDto updateContribution(Long contributionId, ContributionUpdateDto dto) {
        Contribution contribution = contributionRepository.findById(contributionId)
                .orElseThrow(() -> new RuntimeException("Contribution not found with ID: " + contributionId));
        ContributionMapper.updateEntity(contribution, dto);
        Contribution updated = contributionRepository.save(contribution);
        return ContributionMapper.toResponseDto(updated);
    }

    @Override
    public void deleteContribution(Long contributionId) {
        contributionRepository.deleteById(contributionId);
    }

    @Override
    public ContributionResponseDto getContributionById(Long contributionId) {
        Contribution contribution = contributionRepository.findById(contributionId)
                .orElseThrow(() -> new RuntimeException("Contribution not found with ID: " + contributionId));
        return ContributionMapper.toResponseDto(contribution);
    }

    @Override
    public List<ContributionResponseDto> getAllContributions() {
        return contributionRepository.findAll()
                .stream()
                .map(ContributionMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}


