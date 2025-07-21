package com.techsavanna.Church.announcements.services.Impl;

import com.techsavanna.Church.announcements.dtos.*;
import com.techsavanna.Church.announcements.mappers.AnnouncementMapper;
import com.techsavanna.Church.announcements.models.Announcement;
import com.techsavanna.Church.announcements.repos.AnnouncementRepository;
import com.techsavanna.Church.announcements.services.AnnouncementService;
import com.techsavanna.Church.enums.AnnouncementStatus;
import com.techsavanna.Church.handler.ResourceNotFoundException;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.mappers.MemberMapper;
import com.techsavanna.Church.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository repository;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApiResponse<AnnouncementResponseDto> createAnnouncement(AnnouncementCreateDto dto) {
        Announcement entity = AnnouncementMapper.toEntity(dto);
        Announcement saved = repository.save(entity);
        return new ApiResponse<>("success", "Announcement created successfully", AnnouncementMapper.toResponseDto(saved));
    }

    @Override
    public ApiResponse<AnnouncementResponseDto> updateAnnouncement(Long announcementId, AnnouncementUpdateDto dto) {
        Announcement announcement = repository.findById(announcementId)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found with ID: " + announcementId));

        AnnouncementMapper.updateEntity(announcement, dto);
        Announcement updated = repository.save(announcement);

        return new ApiResponse<>("success", "Announcement updated successfully", AnnouncementMapper.toResponseDto(updated));
    }

    @Override
    public ApiResponse<Void> deleteAnnouncement(Long announcementId) {
        if (!repository.existsById(announcementId)) {
            throw new ResourceNotFoundException("Announcement not found with ID: " + announcementId);
        }
        repository.deleteById(announcementId);
        return new ApiResponse<>("success", "Announcement deleted successfully", null);
    }

    @Override
    public ApiResponse<AnnouncementResponseDto> getAnnouncementById(Long announcementId) {
        Announcement announcement = repository.findById(announcementId)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found with ID: " + announcementId));

        return new ApiResponse<>("success", "Announcement retrieved", AnnouncementMapper.toResponseDto(announcement));
    }

    @Override
    public ApiResponse<Page<AnnouncementResponseDto>> getAllAnnouncements(Pageable pageable) {
        Page<Announcement> page = repository.findAll(pageable);
        Page<AnnouncementResponseDto> dtoPage = page.map(AnnouncementMapper::toResponseDto);
        return new ApiResponse<>("success", "All announcements retrieved", dtoPage);
    }

    @Override
    public ApiResponse<Page<AnnouncementResponseDto>> findByStatusIgnoreCase(String status, Pageable pageable) {
        Page<Announcement> page = repository.findByStatusIgnoreCase(status, pageable);
        Page<AnnouncementResponseDto> dtoPage = page.map(AnnouncementMapper::toResponseDto);
        return new ApiResponse<>("success", "Announcements filtered by status", dtoPage);
    }

}
