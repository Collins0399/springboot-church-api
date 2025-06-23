package com.techsavanna.Church.mappers;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.families.models.Family;
import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.models.Member;

public class MemberMapper {

    public static Member toEntity(MemberCreateDto dto, Family family, Department department) {
        Member member = new Member();
        member.setFamily(family);
        member.setDepartment(department);

        member.setFirstName(dto.getFirstName());
        member.setLastName(dto.getLastName());
        member.setGender(dto.getGender());
        member.setDateOfBirth(dto.getDateOfBirth());
        member.setMaritalStatus(dto.getMaritalStatus());
        member.setEmail(dto.getEmail());
        member.setPhoneNumber(dto.getPhoneNumber());
        member.setAddress(dto.getAddress());
        member.setCountry(dto.getCountry());
        member.setCity(dto.getCity());
        member.setPostalCode(dto.getPostalCode());
        member.setBaptismStatus(dto.getBaptismStatus());
        member.setBaptismDate(dto.getBaptismDate());
        member.setJoinedDate(dto.getJoinedDate());
        member.setOccupation(dto.getOccupation());
        member.setRoleInChurch(dto.getRoleInChurch());
        member.setProfilePictureUrl(dto.getProfilePictureUrl());

        return member;
    }

    public static Member toUpdatedEntity(Member member, MemberUpdateDto dto, Family family, Department department) {
        member.setFamily(family);
        member.setDepartment(department);

        member.setFirstName(dto.getFirstName());
        member.setLastName(dto.getLastName());
        member.setGender(dto.getGender());
        member.setDateOfBirth(dto.getDateOfBirth());
        member.setMaritalStatus(dto.getMaritalStatus());
        member.setEmail(dto.getEmail());
        member.setPhoneNumber(dto.getPhoneNumber());
        member.setAddress(dto.getAddress());
        member.setCountry(dto.getCountry());
        member.setCity(dto.getCity());
        member.setPostalCode(dto.getPostalCode());
        member.setBaptismStatus(dto.getBaptismStatus());
        member.setBaptismDate(dto.getBaptismDate());
        member.setJoinedDate(dto.getJoinedDate());
        member.setOccupation(dto.getOccupation());
        member.setRoleInChurch(dto.getRoleInChurch());
        member.setProfilePictureUrl(dto.getProfilePictureUrl());

        return member;
    }

    public static MemberResponseDto toResponseDto(Member member) {
        MemberResponseDto dto = new MemberResponseDto();
        dto.setMemberId(member.getMemberId());
        dto.setFirstName(member.getFirstName());
        dto.setLastName(member.getLastName());
        dto.setGender(member.getGender());
        dto.setDateOfBirth(member.getDateOfBirth());
        dto.setMaritalStatus(member.getMaritalStatus());
        dto.setEmail(member.getEmail());
        dto.setPhoneNumber(member.getPhoneNumber());
        dto.setAddress(member.getAddress());
        dto.setCountry(member.getCountry());
        dto.setCity(member.getCity());
        dto.setPostalCode(member.getPostalCode());
        dto.setBaptismStatus(member.getBaptismStatus());
        dto.setBaptismDate(member.getBaptismDate());
        dto.setJoinedDate(member.getJoinedDate());
        dto.setOccupation(member.getOccupation());
        dto.setRoleInChurch(member.getRoleInChurch());
        dto.setProfilePictureUrl(member.getProfilePictureUrl());

        if (member.getFamily() != null) {
            dto.setFamilyId(member.getFamily().getFamilyId());
        }
        if (member.getDepartment() != null) {
            dto.setDepartmentId(member.getDepartment().getDepartmentId());
        }

        return dto;
    }
}
