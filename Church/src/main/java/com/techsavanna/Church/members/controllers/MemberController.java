package com.techsavanna.Church.members.controllers;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.mappers.MemberMapper;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberCreateDto memberDto) {
        MemberResponseDto createdMember = memberService.createMember(memberDto);
        return ResponseEntity.ok(createdMember);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateDto memberDto) {
        MemberResponseDto updatedMember = memberService.updateMember(memberId, memberDto);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> getByMemberId(@PathVariable Long memberId) {
        MemberResponseDto memberDto = memberService.getMemberById(memberId);
        return ResponseEntity.ok(memberDto);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getAllMembers() {
        List<MemberResponseDto> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/by-email")
    public ResponseEntity<MemberResponseDto> getMemberByEmail(@RequestParam String email) {
        return memberService.getMemberByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<List<MemberResponseDto>> searchByFirstName(@RequestParam String namePart) {
        List<MemberResponseDto> members = memberService.searchByFirstName(namePart);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/by-marital-status")
    public ResponseEntity<List<MemberResponseDto>> getByMaritalStatus(@RequestParam String maritalStatus) {
        List<MemberResponseDto> members = memberService.getMembersByMaritalStatus(maritalStatus);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/by-department")
    public ResponseEntity<List<MemberResponseDto>> getByDepartment(@RequestParam String departmentName) {
        List<MemberResponseDto> members = memberService.getMembersByDepartment(departmentName);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/by-family-name")
    public ResponseEntity<List<MemberResponseDto>> getByFamilyName(@RequestParam String familyName) {
        List<MemberResponseDto> members = memberService.getMembersByFamilyName(familyName);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/by-baptism-status")
    public ResponseEntity<List<MemberResponseDto>> getByBaptismStatus(@RequestParam boolean status) {
        List<MemberResponseDto> members = memberService.getMembersByBaptismStatus(status);
        return ResponseEntity.ok(members);
    }
}
