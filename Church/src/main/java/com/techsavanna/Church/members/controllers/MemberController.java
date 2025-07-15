package com.techsavanna.Church.members.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.members.services.MemberService;
import com.techsavanna.Church.responses.ApiResponse;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:5173")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // ✅ Create member (pure JSON, no image)
    @PostMapping(consumes = "application/json")
    public ResponseEntity<ApiResponse<MemberResponseDto>> createMember(@RequestBody MemberCreateDto memberDto) {
        return ResponseEntity
                .status(201)
                .body(memberService.createMember(memberDto, null)); // No image uploaded
    }

    // ✅ Update member (pure JSON, no image)
    @PutMapping(value = "/{memberId}", consumes = "application/json")
    public ResponseEntity<ApiResponse<MemberResponseDto>> updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberUpdateDto memberDto) {
        return ResponseEntity
                .ok(memberService.updateMember(memberId, memberDto, null));
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
        return memberService.getMemberByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.status(404).body(
                                new ApiResponse<>("error", "Member not found", null)
                        ));
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

