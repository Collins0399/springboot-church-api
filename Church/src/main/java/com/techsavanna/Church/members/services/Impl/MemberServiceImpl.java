package com.techsavanna.Church.members.services.Impl;

import com.techsavanna.Church.mappers.MemberMapper;
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
        Member member = MemberMapper.toEntity(dto);
        Member savedMember = memberRepository.save(member);
        return MemberMapper.toResponseDto(savedMember);
    }

    @Override
    public MemberResponseDto updateMember(Long memberId, MemberUpdateDto dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Member updated = MemberMapper.toUpdatedEntity(member, dto);
        return MemberMapper.toResponseDto(memberRepository.save(updated));
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
                .orElseThrow(() -> new RuntimeException("Member with ID " + memberId + " not found"));
        return MemberMapper.toResponseDto(member);
    }

    @Override
    public List<MemberResponseDto> getAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
