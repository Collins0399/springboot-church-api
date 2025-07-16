package com.techsavanna.Church.announcements.controllers;

import com.techsavanna.Church.announcements.dtos.*;
import com.techsavanna.Church.announcements.services.AnnouncementService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService service;

    @PostMapping
    public ApiResponse<AnnouncementResponseDto> createAnnouncement(@RequestBody AnnouncementCreateDto dto) {
        return service.createAnnouncement(dto);
    }

    @PutMapping("/{announcementId}")
    public ApiResponse<AnnouncementResponseDto> updateAnnouncement(
            @PathVariable Long announcementId,
            @RequestBody AnnouncementUpdateDto dto) {
        return service.updateAnnouncement(announcementId, dto);
    }

    @DeleteMapping("/{announcementId}")
    public ApiResponse<Void> deleteAnnouncement(@PathVariable Long announcementId) {
        return service.deleteAnnouncement(announcementId);
    }

    @GetMapping("/{announcementId}")
    public ApiResponse<AnnouncementResponseDto> getAnnouncementById(@PathVariable Long announcementId) {
        return service.getAnnouncementById(announcementId);
    }

    @GetMapping
    public ApiResponse<List<AnnouncementResponseDto>> getAllAnnouncements() {
        return service.getAllAnnouncements();
    }

    @GetMapping("/status/{status}")
    public ApiResponse<List<AnnouncementResponseDto>> getByStatus(@PathVariable String status) {
        return service.findByStatusIgnoreCase(status);
    }
}
