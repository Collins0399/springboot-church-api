package com.techsavanna.Church.members.services.Impl;

import com.techsavanna.Church.departments.models.Departments;
import com.techsavanna.Church.members.dtos.MemberDto;
import com.techsavanna.Church.members.models.Members;
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

// Method to map MemberDto to Members entity
private MemberDto mapToDto(Members member) {
    MemberDto dto = new MemberDto();
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
    dto.setMembershipStatus(member.getMembershipStatus());
    dto.setJoinedDate(member.getJoinedDate());
    dto.setOccupation(member.getOccupation());
    dto.setRoleInChurch(member.getRoleInChurch());
    dto.setProfilePictureUrl(member.getProfilePictureUrl());

//    if (member.getDepartment() != null) {
//        dto.setDepartmentId(member.getDepartment().getDepartmentId());
//    }

    return dto;
}
// Method to map Members entity to MemberDto
    private Members mapToEntity(MemberDto dto) {
        Members member = new Members();
        member.setMemberId(dto.getMemberId());
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
        member.setMembershipStatus(dto.getMembershipStatus());
        member.setJoinedDate(dto.getJoinedDate());
        member.setOccupation(dto.getOccupation());
        member.setRoleInChurch(dto.getRoleInChurch());
        member.setProfilePictureUrl(dto.getProfilePictureUrl());

//        if (dto.getDepartmentId() != null) {
//            Departments department = departmentRepository.findById(dto.getDepartmentId())
//                    .orElseThrow(() -> new RuntimeException("Department not found"));
//            member.setDepartment(department);
//        }

        return member;
    }

    @Override
    public MemberDto createMember(MemberDto memberDto){
        Members member = mapToEntity(memberDto);
        Members savedMember = memberRepository.save(member);
        return mapToDto(savedMember);
    }
    @Override
    public MemberDto updateMember(Long memberId, MemberDto memberDto) {
        Members existing = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // Update only changed fields
        existing.setFirstName(memberDto.getFirstName());
        existing.setLastName(memberDto.getLastName());
        existing.setGender(memberDto.getGender());
        existing.setDateOfBirth(memberDto.getDateOfBirth());
        existing.setMaritalStatus(memberDto.getMaritalStatus());
        existing.setEmail(memberDto.getEmail());
        existing.setPhoneNumber(memberDto.getPhoneNumber());
        existing.setAddress(memberDto.getAddress());
        existing.setCountry(memberDto.getCountry());
        existing.setCity(memberDto.getCity());
        existing.setPostalCode(memberDto.getPostalCode());
        existing.setBaptismStatus(memberDto.getBaptismStatus());
        existing.setBaptismDate(memberDto.getBaptismDate());
        existing.setMembershipStatus(memberDto.getMembershipStatus());
        existing.setJoinedDate(memberDto.getJoinedDate());
        existing.setOccupation(memberDto.getOccupation());
        existing.setRoleInChurch(memberDto.getRoleInChurch());
        existing.setProfilePictureUrl(memberDto.getProfilePictureUrl());

        Members saved = memberRepository.save(existing);
        return mapToDto(saved);
    }

    @Override
    public void deleteMember(Long memberId) {
    memberRepository.deleteById(memberId);
    }
    @Override
    public MemberDto getMemberById(Long memberId) {
    Optional<Members> member= memberRepository .findById( memberId);
            return member.map(this::mapToDto).orElse(null);
    }
    @Override
    public List<MemberDto> getAllMembers(){
    return  memberRepository.findAll()
            .stream()
            .map(this::mapToDto)
            .collect(Collectors.toList());
    }

}
