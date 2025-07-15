package com.techsavanna.Church.members.controllers;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.members.services.MemberService;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ApiResponse<List<MemberResponseDto>> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/by-email")
    public ApiResponse<MemberResponseDto> getMemberByEmail(@RequestParam String email) {
        return memberService.getMemberByEmail(email);
    }

    @GetMapping("/search-by-name")
    public ApiResponse<List<MemberResponseDto>> searchByFirstName(@RequestParam String namePart) {
        return memberService.searchByFirstName(namePart);
    }

    @GetMapping("/by-marital-status")
    public ApiResponse<List<MemberResponseDto>> getByMaritalStatus(@RequestParam String maritalStatus) {
        return memberService.getMembersByMaritalStatus(maritalStatus);
    }

    @GetMapping("/by-department")
    public ApiResponse<List<MemberResponseDto>> getByDepartment(@RequestParam String departmentName) {
        return memberService.getMembersByDepartment(departmentName);
    }

    @GetMapping("/by-family-name")
    public ApiResponse<List<MemberResponseDto>> getByFamilyName(@RequestParam String familyName) {
        return memberService.getMembersByFamilyName(familyName);
    }

    @GetMapping("/by-baptism-status")
    public ApiResponse<List<MemberResponseDto>> getByBaptismStatus(@RequestParam BaptismStatus status) {
        return memberService.getMembersByBaptismStatus(status);
    }
}