package com.techsavanna.Church.members.services;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


public interface MemberService {

    ApiResponse<MemberResponseDto> createMember(MemberCreateDto memberDto, MultipartFile profilePicture);

    ApiResponse<MemberResponseDto> updateMember(Long memberId, MemberUpdateDto memberDto, MultipartFile profilePicture);

    ApiResponse<Void> deleteMember(Long memberId);

    ApiResponse<MemberResponseDto> getMemberById(Long memberId);

    ApiResponse<MemberResponseDto> getMemberByEmail(String email);

    ApiResponse<Page<MemberResponseDto>> getAllMembers(Pageable pageable);

    ApiResponse<Page<MemberResponseDto>> searchByFirstName(String namePart, Pageable pageable);

    ApiResponse<Page<MemberResponseDto>> getMembersByMaritalStatus(String maritalStatus, Pageable pageable);

    ApiResponse<Page<MemberResponseDto>> getMembersByDepartment(String departmentName, Pageable pageable);

    ApiResponse<Page<MemberResponseDto>> getMembersByFamilyName(String familyName, Pageable pageable);

    ApiResponse<Page<MemberResponseDto>> getMembersByBaptismStatus(BaptismStatus status, Pageable pageable);
}
