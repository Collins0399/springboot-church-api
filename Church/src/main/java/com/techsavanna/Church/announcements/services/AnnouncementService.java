package com.techsavanna.Church.announcements.services;

import com.techsavanna.Church.announcements.dtos.AnnouncementCreateDto;

import java.util.List;

public interface AnnouncementService {
    AnnouncementCreateDto createAnnouncement(AnnouncementCreateDto announcementCreateDto);
    AnnouncementCreateDto updateAnnouncement(Long announcementId, AnnouncementCreateDto announcementCreateDto);
    void deleteAnnouncement(Long announcementId);
    AnnouncementCreateDto getAnnouncementById(Long announcementId);
    List <AnnouncementCreateDto> getAllAnnouncements();
}
