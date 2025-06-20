package com.techsavanna.Church.members.services.Impl;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.members.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberResponseDto createMember(MemberCreateDto dto) {
        Member member = new Member();
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

        Member savedMember = memberRepository.save(member);
        return mapToResponseDto(savedMember);
    }

    @Override
    public MemberResponseDto updateMember(Long memberId, MemberUpdateDto dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

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

        Member saved = memberRepository.save(member);
        return mapToResponseDto(saved);
    }

    @Override
    public void deleteMember(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new RuntimeException("Member not found");
        }
        memberRepository.deleteById(memberId);
    }

    @Override
    public MemberResponseDto getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return mapToResponseDto(member);
    }

    @Override
    public List<MemberResponseDto> getAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // map methods to convert  Entity to Dto
    private MemberResponseDto mapToResponseDto(Member member) {
        MemberResponseDto dto = new MemberResponseDto();
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
        return dto;
    }
}
