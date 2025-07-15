package com.techsavanna.Church.members.services.Impl;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.departments.repos.DepartmentRepository;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

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
        Family family = null;
        if (dto.getFamilyId() != null) {
            family = familyRepository.findById(dto.getFamilyId())
                    .orElseThrow(() -> new RuntimeException("Family not found with ID: " + dto.getFamilyId()));
        }

        Department department = null;
        if (dto.getDepartmentId() != null) {
            department = departmentRepository.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found with ID: " + dto.getDepartmentId()));
        }

        String storedPath = saveProfilePicture(profilePicture);
        dto.setProfilePicturePath(storedPath);

        Member member = MemberMapper.toEntity(dto, family, department);
        Member savedMember = memberRepository.save(member);

        return new ApiResponse<>("success", "Member created successfully", MemberMapper.toResponseDto(savedMember));
    }

    @Override
    public ApiResponse<MemberResponseDto> updateMember(Long memberId, MemberUpdateDto dto, MultipartFile profilePicture) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with ID: " + memberId));

        Family family = null;
        if (dto.getFamilyId() != null) {
            family = familyRepository.findById(dto.getFamilyId())
                    .orElseThrow(() -> new RuntimeException("Family not found with ID: " + dto.getFamilyId()));
        }

        Department department = null;
        if (dto.getDepartmentId() != null) {
            department = departmentRepository.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found with ID: " + dto.getDepartmentId()));
        }

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
            throw new RuntimeException("Member not found");
        }
        memberRepository.deleteById(memberId);
        return new ApiResponse<>("success", "Member deleted successfully", null);
    }

    @Override
    public ApiResponse<MemberResponseDto> getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member with ID " + memberId + " not found"));
        return new ApiResponse<>("success", "Member fetched successfully", MemberMapper.toResponseDto(member));
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getAllMembers() {
        List<MemberResponseDto> members = memberRepository.findAll()
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "All members retrieved successfully", members);
    }

    @Override
    public Optional<ApiResponse<MemberResponseDto>> getMemberByEmail(String email) {
        return memberRepository.findByEmail(email)
                .map(member -> new ApiResponse<>("success", "Member found", MemberMapper.toResponseDto(member)))
                .map(Optional::of)
                .orElse(Optional.empty());
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> searchByFirstName(String namePart) {
        List<MemberResponseDto> results = memberRepository.findByFirstNameContainingIgnoreCase(namePart)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Members matching name found", results);
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getMembersByMaritalStatus(String maritalStatus) {
        List<MemberResponseDto> results = memberRepository.findByMaritalStatus(maritalStatus)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Members by marital status retrieved", results);
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getMembersByDepartment(String departmentName) {
        List<MemberResponseDto> results = memberRepository.findByDepartmentIgnoreCase(departmentName)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Members by department retrieved", results);
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getMembersByFamilyName(String familyName) {
        List<MemberResponseDto> results = memberRepository.findByFamily_FamilyNameIgnoreCase(familyName)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Members by family name retrieved", results);
    }

    @Override
    public ApiResponse<List<MemberResponseDto>> getMembersByBaptismStatus(BaptismStatus status) {
        List<MemberResponseDto> results = memberRepository.findByBaptismStatus(status)
                .stream()
                .map(MemberMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Members by baptism status retrieved", results);
    }
}
