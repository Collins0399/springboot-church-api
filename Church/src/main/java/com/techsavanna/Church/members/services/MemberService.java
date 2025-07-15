package com.techsavanna.Church.members.services;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    ApiResponse<MemberResponseDto> createMember(MemberCreateDto dto, MultipartFile profilePicture);
    ApiResponse<MemberResponseDto> updateMember(Long memberId, MemberUpdateDto dto, MultipartFile profilePicture);
    ApiResponse<Void> deleteMember(Long memberId);
    ApiResponse<MemberResponseDto> getMemberById(Long memberId);
    ApiResponse<List<MemberResponseDto>> getAllMembers();
    Optional<ApiResponse<MemberResponseDto>> getMemberByEmail(String email);
    ApiResponse<List<MemberResponseDto>> searchByFirstName(String namePart);
    ApiResponse<List<MemberResponseDto>> getMembersByMaritalStatus(String maritalStatus);
    ApiResponse<List<MemberResponseDto>> getMembersByDepartment(String departmentName);
    ApiResponse<List<MemberResponseDto>> getMembersByFamilyName(String familyName);
    ApiResponse<List<MemberResponseDto>> getMembersByBaptismStatus(BaptismStatus status);

}
