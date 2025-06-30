package com.techsavanna.Church.announcements.mappers;

import com.techsavanna.Church.announcements.dtos.*;
import com.techsavanna.Church.announcements.models.Announcement;
import com.techsavanna.Church.utils.AnnouncementStatusUtil;

import java.time.LocalDateTime;

public class AnnouncementMapper {

    public static Announcement toEntity(AnnouncementCreateDto dto) {
        Announcement announcement = new Announcement();
        announcement.setTitle(dto.getTitle());
        announcement.setMessage(dto.getMessage());
        announcement.setTargetAudience(dto.getTargetAudience());
        announcement.setStartDate(dto.getStartDate());
        announcement.setEndDate(dto.getEndDate());
        announcement.setCreatedAt(LocalDateTime.now());
        announcement.setUpdatedAt(LocalDateTime.now());

        announcement.setStatus(AnnouncementStatusUtil
                .determineStatus(dto.getStartDate(), dto.getEndDate()));

        return announcement;
    }

    public static void updateEntity(Announcement announcement, AnnouncementUpdateDto dto) {
        if (dto.getTitle() != null) announcement.setTitle(dto.getTitle());
        if (dto.getMessage() != null) announcement.setMessage(dto.getMessage());
        if (dto.getTargetAudience() != null) announcement.setTargetAudience(dto.getTargetAudience());
        if (dto.getStartDate() != null) announcement.setStartDate(dto.getStartDate());
        if (dto.getEndDate() != null) announcement.setEndDate(dto.getEndDate());

        announcement.setStatus(AnnouncementStatusUtil
            .determineStatus(dto.getStartDate(), dto.getEndDate()));

        announcement.setUpdatedAt(LocalDateTime.now());
    }

    public static AnnouncementResponseDto toResponseDto(Announcement announcement) {
        AnnouncementResponseDto dto = new AnnouncementResponseDto();
        dto.setAnnouncementId(announcement.getAnnouncementId());
        dto.setTitle(announcement.getTitle());
        dto.setMessage(announcement.getMessage());
        dto.setTargetAudience(announcement.getTargetAudience());
        dto.setCreatedAt(announcement.getCreatedAt());
        dto.setUpdatedAt(announcement.getUpdatedAt());
        dto.setStatus(announcement.getStatus());
        dto.setStartDate(announcement.getStartDate());
        dto.setEndDate(announcement.getEndDate());

        return dto;
    }
}


