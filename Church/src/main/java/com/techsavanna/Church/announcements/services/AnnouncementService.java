package com.techsavanna.Church.announcements.services;

import com.techsavanna.Church.announcements.dtos.*;

import java.util.List;

public interface AnnouncementService {
    AnnouncementResponseDto createAnnouncement(AnnouncementCreateDto dto);
    AnnouncementResponseDto updateAnnouncement(Long announcementId, AnnouncementUpdateDto dto);
    void deleteAnnouncement(Long announcementId);
    AnnouncementResponseDto getAnnouncementById(Long announcementId);
    List<AnnouncementResponseDto> getAllAnnouncements();
}
