package com.techsavanna.Church.announcements.services;

import com.techsavanna.Church.announcements.dtos.AnnouncementDto;

import java.util.List;

public interface AnnouncementService {
    AnnouncementDto createAnnouncement(AnnouncementDto announcementDto);
    AnnouncementDto updateAnnouncement(Long announcementId, AnnouncementDto announcementDto);
    void deleteAnnouncement(Long announcementId);
    AnnouncementDto getAnnouncementById(Long announcementId);
    List <AnnouncementDto> getAllAnnouncements();
}
