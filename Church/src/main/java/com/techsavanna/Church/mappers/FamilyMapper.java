package com.techsavanna.Church.mappers;

import com.techsavanna.Church.families.dtos.FamilyCreateDto;
import com.techsavanna.Church.families.dtos.FamilyResponseDto;
import com.techsavanna.Church.families.dtos.FamilyUpdateDto;
import com.techsavanna.Church.families.dtos.MemberSummaryDto;
import com.techsavanna.Church.families.models.Family;
import com.techsavanna.Church.members.models.Member;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyMapper {

    public static Family toEntity(FamilyCreateDto dto) {
        Family family = new Family();
        family.setFamilyName(dto.getFamilyName());
        family.setEmergencyContactName(dto.getEmergencyContactName());
        family.setEmergencyContactPhone(dto.getEmergencyContactPhone());
        family.setAddress(dto.getAddress());
        family.setCountry(dto.getCountry());
        family.setCity(dto.getCity());
        family.setPostalCode(dto.getPostalCode());
        return family;
    }

    public static Family toUpdatedEntity(Family family, FamilyUpdateDto dto) {
        family.setFamilyName(dto.getFamilyName());
        family.setEmergencyContactName(dto.getEmergencyContactName());
        family.setEmergencyContactPhone(dto.getEmergencyContactPhone());
        family.setAddress(dto.getAddress());
        family.setCountry(dto.getCountry());
        family.setCity(dto.getCity());
        family.setPostalCode(dto.getPostalCode());
        return family;
    }

    public static FamilyResponseDto toResponseDto(Family family) {
        FamilyResponseDto dto = new FamilyResponseDto();
        dto.setFamilyId(family.getFamilyId());
        dto.setFamilyName(family.getFamilyName());
        dto.setEmergencyContactName(family.getEmergencyContactName());
        dto.setEmergencyContactPhone(family.getEmergencyContactPhone());
        dto.setAddress(family.getAddress());
        dto.setCountry(family.getCountry());
        dto.setCity(family.getCity());
        dto.setPostalCode(family.getPostalCode());

        if (family.getMembers() != null && !family.getMembers().isEmpty()) {
            List<MemberSummaryDto> members = family.getMembers().stream()
                    .map(FamilyMapper::toMemberSummary)
                    .collect(Collectors.toList());
            dto.setMembers(members);
        }

        return dto;
    }

    private static MemberSummaryDto toMemberSummary(Member member) {
        MemberSummaryDto dto = new MemberSummaryDto();
        dto.setMemberId(member.getMemberId());
        dto.setFirstName(member.getFirstName());
        dto.setLastName(member.getLastName());
        return dto;
    }
}
