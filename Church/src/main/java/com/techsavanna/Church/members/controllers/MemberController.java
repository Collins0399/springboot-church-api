//package com.techsavanna.Church.members.controllers;
//
//import com.techsavanna.Church.members.dtos.MemberCreateDto;
//import com.techsavanna.Church.members.services.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/members")
//public class MemberController {
//    @Autowired
//    private MemberService memberService;
//
//    @PostMapping
//    public ResponseEntity<MemberCreateDto> createMember(@RequestBody MemberCreateDto memberDto) {
//        MemberCreateDto createdMember = memberService.createMember(memberDto);
//        return ResponseEntity.ok(createdMember);
//    }
//
//    @PutMapping("/{memberId}")
//    public ResponseEntity<MemberCreateDto> updateMember(@PathVariable Long memberId, @RequestBody MemberCreateDto memberDto) {
//        MemberCreateDto updatedMember = memberService.updateMember(memberId, memberDto);
//        return ResponseEntity.ok(updatedMember);
//    }
//
//    @DeleteMapping("/{memberId}")
//    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
//        memberService.deleteMember(memberId);
//        return ResponseEntity.noContent().build();
//    }
//
//
//    @GetMapping("/{memberId}")
//    public ResponseEntity<MemberCreateDto> getByMemberId(@PathVariable Long memberId) {
//        MemberCreateDto memberDto = memberService.getMemberById(memberId);
//        if (memberDto != null) {
//            return ResponseEntity.ok(memberDto);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<List<MemberCreateDto>> getAll() {
//        List<MemberCreateDto> members = memberService.getAllMembers();
//        return ResponseEntity.ok(members);
//    }
//}
