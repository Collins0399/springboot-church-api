package com.techsavanna.Church.members.controllers;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.members.services.MemberService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ApiResponse<MemberResponseDto> createMember(@RequestBody MemberCreateDto dto) {
        return memberService.createMember(dto, null);
    }



    @PutMapping("/{memberId}")
    public ApiResponse<MemberResponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateDto dto) {
        return memberService.updateMember(memberId, dto, null);
    }


    @DeleteMapping("/{memberId}")
    public ApiResponse<Void> deleteMember(@PathVariable Long memberId) {
        return memberService.deleteMember(memberId);
    }

    @GetMapping("/{memberId}")
    public ApiResponse<MemberResponseDto> getByMemberId(@PathVariable Long memberId) {
        return memberService.getMemberById(memberId);
    }

    @GetMapping("/by-email")
    public ApiResponse<MemberResponseDto> getMemberByEmail(@RequestParam String email) {
        return memberService.getMemberByEmail(email);
    }

    @GetMapping
    public ApiResponse<Page<MemberResponseDto>> getAllMembers(
            @PageableDefault(size = 10, sort = "firstName") Pageable pageable) {
        return memberService.getAllMembers(pageable);
    }

    @GetMapping("/search-by-name")
    public ApiResponse<Page<MemberResponseDto>> searchByFirstName(@RequestParam String namePart, Pageable pageable) {
        return memberService.searchByFirstName(namePart, pageable);
    }

    @GetMapping("/by-marital-status")
    public ApiResponse<Page<MemberResponseDto>> getByMaritalStatus(@RequestParam String maritalStatus, Pageable pageable) {
        return memberService.getMembersByMaritalStatus(maritalStatus, pageable);
    }

    @GetMapping("/by-department")
    public ApiResponse<Page<MemberResponseDto>> getByDepartment(@RequestParam String departmentName, Pageable pageable) {
        return memberService.getMembersByDepartment(departmentName, pageable);
    }

    @GetMapping("/by-family-name")
    public ApiResponse<Page<MemberResponseDto>> getByFamilyName(@RequestParam String familyName, Pageable pageable) {
        return memberService.getMembersByFamilyName(familyName, pageable);
    }

    @GetMapping("/by-baptism-status")
    public ApiResponse<Page<MemberResponseDto>> getByBaptismStatus(@RequestParam BaptismStatus status, Pageable pageable) {
        return memberService.getMembersByBaptismStatus(status, pageable);
    }
}
