package com.techsavanna.Church.announcements.services;

import com.techsavanna.Church.announcements.dtos.*;
import com.techsavanna.Church.announcements.models.Announcement;
import com.techsavanna.Church.enums.AnnouncementStatus;
import com.techsavanna.Church.responses.ApiResponse;

import java.util.List;

public interface AnnouncementService {
    ApiResponse<AnnouncementResponseDto> createAnnouncement(AnnouncementCreateDto dto);
    ApiResponse<AnnouncementResponseDto> updateAnnouncement(Long announcementId, AnnouncementUpdateDto dto);
    ApiResponse<Void> deleteAnnouncement(Long announcementId);
    ApiResponse<AnnouncementResponseDto> getAnnouncementById(Long announcementId);
    ApiResponse<List<AnnouncementResponseDto>> getAllAnnouncements();
    ApiResponse<List<AnnouncementResponseDto>> findByStatusIgnoreCase(String status);
}
