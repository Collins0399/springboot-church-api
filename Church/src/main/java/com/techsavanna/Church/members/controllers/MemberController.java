package com.techsavanna.Church.members.controllers;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.members.services.MemberService;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<ApiResponse<MemberResponseDto>> createMember(@RequestBody MemberCreateDto dto) {
        return ResponseEntity.ok(memberService.createMember(dto, null));
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponseDto>> updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberUpdateDto dto) {
        return ResponseEntity.ok(memberService.updateMember(memberId, dto, null));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<ApiResponse<Void>> deleteMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.deleteMember(memberId));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponseDto>> getByMemberId(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMemberById(memberId));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/by-email")
    public ResponseEntity<ApiResponse<MemberResponseDto>> getMemberByEmail(@RequestParam String email) {
        return ResponseEntity.ok(memberService.getMemberByEmail(email));
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> searchByFirstName(@RequestParam String namePart) {
        return ResponseEntity.ok(memberService.searchByFirstName(namePart));
    }

    @GetMapping("/by-marital-status")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getByMaritalStatus(@RequestParam String maritalStatus) {
        return ResponseEntity.ok(memberService.getMembersByMaritalStatus(maritalStatus));
    }

    @GetMapping("/by-department")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getByDepartment(@RequestParam String departmentName) {
        return ResponseEntity.ok(memberService.getMembersByDepartment(departmentName));
    }

    @GetMapping("/by-family-name")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getByFamilyName(@RequestParam String familyName) {
        return ResponseEntity.ok(memberService.getMembersByFamilyName(familyName));
    }

    @GetMapping("/by-baptism-status")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getByBaptismStatus(@RequestParam BaptismStatus status) {
        return ResponseEntity.ok(memberService.getMembersByBaptismStatus(status));
    }
}
