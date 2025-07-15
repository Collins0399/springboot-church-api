package com.techsavanna.Church.members.services.Impl;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.departments.repos.DepartmentRepository;
import com.techsavanna.Church.handler.ResourceNotFoundException;
import com.techsavanna.Church.families.models.Family;
import com.techsavanna.Church.families.repos.FamilyRepository;
import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.members.mappers.MemberMapper;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.members.services.MemberService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired private MemberRepository memberRepository;
    @Autowired private FamilyRepository familyRepository;
    @Autowired private DepartmentRepository departmentRepository;

    private static final String UPLOAD_DIR = "uploads/profile-pictures/";

    private String saveProfilePicture(MultipartFile file) {
        if (file == null || file.isEmpty()) return null;
        try {
            String uploadDir = new File(UPLOAD_DIR).getAbsolutePath();
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            file.transferTo(filePath.toFile());
            return UPLOAD_DIR + fileName;
        } catch (Exception e) {
            throw new RuntimeException("Failed to store profile picture", e);
        }
    }

    @Override
    public ApiResponse<MemberResponseDto> createMember(MemberCreateDto dto, MultipartFile profilePicture) {
        Family family = dto.getFamilyId() != null
                ? familyRepository.findById(dto.getFamilyId())
                .orElseThrow(() -> new ResourceNotFoundException("Family not found with ID: " + dto.getFamilyId()))
                : null;

        Department department = dto.getDepartmentId() != null
                ? departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + dto.getDepartmentId()))
                : null;

        String storedPath = saveProfilePicture(profilePicture);
        dto.setProfilePicturePath(storedPath);

        Member saved = memberRepository.save(MemberMapper.toEntity(dto, family, department));
        return new ApiResponse<>("success", "Member created successfully", MemberMapper.toResponseDto(saved));
    }

    @Override
    public ApiResponse<MemberResponseDto> updateMember(Long memberId, MemberUpdateDto dto, MultipartFile profilePicture) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + memberId));

        Family family = dto.getFamilyId() != null
                ? familyRepository.findById(dto.getFamilyId())
                .orElseThrow(() -> new ResourceNotFoundException("Family not found with ID: " + dto.getFamilyId()))
                : null;

        Department department = dto.getDepartmentId() != null
                ? departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + dto.getDepartmentId()))
                : null;

        String storedPath = (profilePicture != null && !profilePicture.isEmpty())
                ? saveProfilePicture(profilePicture)
                : member.getProfilePicturePath();

        dto.setProfilePicturePath(storedPath);

        Member updated = MemberMapper.toUpdatedEntity(member, dto, family, department);
        return new ApiResponse<>("success", "Member updated successfully", MemberMapper.toResponseDto(memberRepository.save(updated)));
    }

    @Override
    public ApiResponse<Void> deleteMember(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new ResourceNotFoundException("Member not found with ID: " + memberId);
        }
        memberRepository.deleteById(memberId);
        return new ApiResponse<>("success", "Member deleted successfully", null);
    }

    @Override
    public ApiResponse<MemberResponseDto> getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + memberId));
        return new ApiResponse<>("success", "Member found", MemberMapper.toResponseDto(member));
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getAllMembers() {
        List<MemberResponseDto> list = memberRepository.findAll()
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "All members retrieved", list);
    }

    @Override
    public ApiResponse<MemberResponseDto> getMemberByEmail(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with email: " + email));
        return new ApiResponse<>("success", "Member found", MemberMapper.toResponseDto(member));
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> searchByFirstName(String namePart) {
        List<MemberResponseDto> list = memberRepository.findByFirstNameContainingIgnoreCase(namePart)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Search results", list);
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getMembersByMaritalStatus(String maritalStatus) {
        List<MemberResponseDto> list = memberRepository.findByMaritalStatus(maritalStatus)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Members by marital status retrieved", list);
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getMembersByDepartment(String departmentName) {
        List<MemberResponseDto> list = memberRepository.findByDepartmentIgnoreCase(departmentName)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Members by department retrieved", list);
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getMembersByFamilyName(String familyName) {
        List<MemberResponseDto> list = memberRepository.findByFamily_FamilyNameIgnoreCase(familyName)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Members by family name retrieved", list);
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getMembersByBaptismStatus(BaptismStatus status) {
        List<MemberResponseDto> list = memberRepository.findByBaptismStatus(status)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Members by baptism status retrieved", list);
    }
}
