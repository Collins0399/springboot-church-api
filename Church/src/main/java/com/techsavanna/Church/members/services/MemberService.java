package com.techsavanna.Church.members.services;

import com.techsavanna.Church.members.dtos.MemberDto;

import java.util.List;

public interface MemberService {
    MemberDto createMember(MemberDto memberDto);
    MemberDto updateMember(Long memberId, MemberDto memberDto);
    void deleteMember(Long memberId);
    MemberDto getMemberById(Long memberId);
    List<MemberDto> getAllMembers();
}
