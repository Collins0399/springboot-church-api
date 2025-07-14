package com.techsavanna.Church.members.controllers;

import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.mappers.MemberMapper;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.services.MemberService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:5173")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<ApiResponse<MemberResponseDto>> createMember(@RequestBody MemberCreateDto memberDto) {
        MemberResponseDto result = memberService.createMember(memberDto);
        ApiResponse<MemberResponseDto> response = new ApiResponse<>(
                "success", "Member Created successfully", result
        );
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponseDto>> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateDto memberDto) {
        MemberResponseDto result = memberService.updateMember(memberId, memberDto);
        ApiResponse<MemberResponseDto> response = new ApiResponse<>(
                "success", "Member Updated successfully", result
        );
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<ApiResponse<Void>> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        ApiResponse<Void> response = new ApiResponse<>(
                "success", "Member Deleted successfully", null
        );
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponseDto>> getByMemberId(@PathVariable Long memberId) {
        MemberResponseDto memberDto = memberService.getMemberById(memberId);
        ApiResponse<MemberResponseDto> response = new ApiResponse<>("success", "Member fetched successfully", memberDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getAllMembers() {
        List<MemberResponseDto> members = memberService.getAllMembers();
        ApiResponse<List<MemberResponseDto>> response = new ApiResponse<>("success", "All members retrieved successfully", members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/by-email")
    public ResponseEntity<ApiResponse<MemberResponseDto>> getMemberByEmail(@RequestParam String email) {
        return memberService.getMemberByEmail(email)
                .map(member -> new ResponseEntity<>(
                        new ApiResponse<>("success", "Member found", member), HttpStatus.OK))
                .orElse(new ResponseEntity<>(
                        new ApiResponse<>("error", "Member not found", null), HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> searchByFirstName(@RequestParam String namePart) {
        List<MemberResponseDto> members = memberService.searchByFirstName(namePart);
        ApiResponse<List<MemberResponseDto>> response = new ApiResponse<>("success", "Members matching name found", members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/by-marital-status")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getByMaritalStatus(@RequestParam String maritalStatus) {
        List<MemberResponseDto> members = memberService.getMembersByMaritalStatus(maritalStatus);
        ApiResponse<List<MemberResponseDto>> response = new ApiResponse<>("success", "Members by marital status retrieved", members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/by-department")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getByDepartment(@RequestParam String departmentName) {
        List<MemberResponseDto> members = memberService.getMembersByDepartment(departmentName);
        ApiResponse<List<MemberResponseDto>> response = new ApiResponse<>("success", "Members by department retrieved", members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/by-family-name")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getByFamilyName(@RequestParam String familyName) {
        List<MemberResponseDto> members = memberService.getMembersByFamilyName(familyName);
        ApiResponse<List<MemberResponseDto>> response = new ApiResponse<>("success", "Members by family retrieved", members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/by-baptism-status")
    public ResponseEntity<ApiResponse<List<MemberResponseDto>>> getByBaptismStatus(@RequestParam boolean status) {
        List<MemberResponseDto> members = memberService.getMembersByBaptismStatus(status);
        ApiResponse<List<MemberResponseDto>> response = new ApiResponse<>("success", "Members by baptism status retrieved", members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
