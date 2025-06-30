package com.techsavanna.Church.members.services;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.models.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    MemberResponseDto createMember(MemberCreateDto memberDto);
    MemberResponseDto updateMember(Long memberId, MemberUpdateDto memberDto);
    void deleteMember(Long memberId);
    MemberResponseDto getMemberById(Long memberId);
    List<MemberResponseDto> getAllMembers();

    Optional<MemberResponseDto> getMemberByEmail(String email);

    List<MemberResponseDto> searchByFirstName(String namePart);

    List<MemberResponseDto> getMembersByMaritalStatus(String maritalStatus);

    List<MemberResponseDto> getMembersByDepartment(String departmentName);

    List<MemberResponseDto> getMembersByFamilyName(String familyName);

    List<MemberResponseDto> getMembersByBaptismStatus(boolean status);
}
