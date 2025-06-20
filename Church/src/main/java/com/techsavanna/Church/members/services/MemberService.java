package com.techsavanna.Church.members.services;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;

import java.util.List;

public interface MemberService {
    MemberResponseDto createMember(MemberCreateDto dto);
    MemberResponseDto updateMember(Long memberId, MemberUpdateDto dto);
    List<MemberResponseDto> getAllMembers();
    MemberResponseDto getMemberById(Long memberId);
    void deleteMember(Long memberId);
}
