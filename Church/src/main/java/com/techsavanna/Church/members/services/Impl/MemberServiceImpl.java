package com.techsavanna.Church.members.services.Impl;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.departments.repos.DepartmentRepository;
import com.techsavanna.Church.families.models.Family;
import com.techsavanna.Church.families.repos.FamilyRepository;
import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.mappers.MemberMapper;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.members.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public MemberResponseDto createMember(MemberCreateDto dto) {
        Family family = familyRepository.findById(dto.getFamilyId())
                .orElseThrow(() -> new RuntimeException("Family not found with ID: " + dto.getFamilyId()));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + dto.getDepartmentId()));

        Member member = MemberMapper.toEntity(dto, family, department);
        Member savedMember = memberRepository.save(member);
        return MemberMapper.toResponseDto(savedMember);
    }

    @Override
    public MemberResponseDto updateMember(Long memberId, MemberUpdateDto dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with ID: " + memberId));

        Family family = familyRepository.findById(dto.getFamilyId())
                .orElseThrow(() -> new RuntimeException("Family not found with ID: " + dto.getFamilyId()));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + dto.getDepartmentId()));

        Member updated = MemberMapper.toUpdatedEntity(member, dto, family, department);
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
    @Override
    public Optional<MemberResponseDto> getMemberByEmail(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberMapper::toResponseDto);
    }

    @Override
    public List<MemberResponseDto> searchByFirstName(String namePart) {
        return memberRepository.findByFirstNameContainingIgnoreCase(namePart)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MemberResponseDto> getMembersByMaritalStatus(String maritalStatus) {
        return memberRepository.findByMaritalStatus(maritalStatus)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MemberResponseDto> getMembersByDepartment(String departmentName) {
        return memberRepository.findByDepartmentIgnoreCase(departmentName)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MemberResponseDto> getMembersByFamilyName(String familyName) {
        return memberRepository.findByFamily_FamilyNameIgnoreCase(familyName)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MemberResponseDto> getMembersByBaptismStatus(boolean status) {
        return memberRepository.findByBaptismStatus(status)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
