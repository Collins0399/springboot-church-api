package com.techsavanna.Church.mappers;

import com.techsavanna.Church.contributions.dtos.*;
import com.techsavanna.Church.contributions.models.Contribution;
import com.techsavanna.Church.enums.PaymentMethod;
import com.techsavanna.Church.members.models.Member;

import java.time.LocalDateTime;

public class ContributionMapper {

    // Convert Create DTO to Entity
    public static Contribution toEntity(ContributionCreateDto dto, Member member) {
        Contribution contribution = new Contribution();
        contribution.setContributionType(dto.getContributionType());
        contribution.setAmount(dto.getAmount());
        contribution.setDateGiven(dto.getDateGiven());
        contribution.setPaymentMethod(PaymentMethod.valueOf(dto.getPaymentMethod().toUpperCase()));
        contribution.setCreatedAt(LocalDateTime.now());
        contribution.setUpdatedAt(LocalDateTime.now());
        contribution.setMember(member);
        return contribution;
    }

    // Convert Update DTO to Entity (partial update)
    public static void updateEntity(Contribution contribution, ContributionUpdateDto dto) {
        contribution.setContributionType(dto.getContributionType());
        contribution.setAmount(dto.getAmount());
        contribution.setDateGiven(dto.getDateGiven());
        contribution.setPaymentMethod(PaymentMethod.valueOf(dto.getPaymentMethod().toUpperCase()));
        contribution.setUpdatedAt(LocalDateTime.now());
    }

    // Convert Entity to Response DTO
    public static ContributionResponseDto toResponseDto(Contribution contribution) {
        ContributionResponseDto dto = new ContributionResponseDto();
        dto.setContributionId(contribution.getContributionId());
        dto.setContributionType(contribution.getContributionType());
        dto.setAmount(contribution.getAmount());
        dto.setDateGiven(contribution.getDateGiven());
        dto.setPaymentMethod(contribution.getPaymentMethod().name());
        dto.setCreatedAt(contribution.getCreatedAt());
        dto.setUpdatedAt(contribution.getUpdatedAt());
        dto.setMemberId(contribution.getMember().getMemberId());
        return dto;
    }
}

