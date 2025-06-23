package com.techsavanna.Church.mappers;

import com.techsavanna.Church.announcements.dtos.*;
import com.techsavanna.Church.announcements.models.Announcement;

import java.time.LocalDateTime;

public class AnnouncementMapper {

    public static Announcement toEntity(AnnouncementCreateDto dto) {
        Announcement announcement = new Announcement();
        announcement.setTitle(dto.getTitle());
        announcement.setMessage(dto.getMessage());
        announcement.setTargetAudience(dto.getTargetAudience());
//        announcement.setCreatedAt(LocalDateTime.now());
//        announcement.setUpdatedAt(LocalDateTime.now());
        return announcement;
    }

    public static void updateEntity(Announcement announcement, AnnouncementUpdateDto dto) {
        if (dto.getTitle() != null) announcement.setTitle(dto.getTitle());
        if (dto.getMessage() != null) announcement.setMessage(dto.getMessage());
        if (dto.getTargetAudience() != null) announcement.setTargetAudience(dto.getTargetAudience());

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
        return dto;
    }
}

