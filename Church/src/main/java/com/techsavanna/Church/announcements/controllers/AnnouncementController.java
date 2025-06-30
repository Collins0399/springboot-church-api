package com.techsavanna.Church.announcements.controllers;

import com.techsavanna.Church.announcements.dtos.*;
import com.techsavanna.Church.announcements.services.AnnouncementService;
import com.techsavanna.Church.enums.AnnouncementStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    private final AnnouncementService service;

    @Autowired
    public AnnouncementController(AnnouncementService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AnnouncementResponseDto> create(@RequestBody AnnouncementCreateDto dto) {
        return ResponseEntity.ok(service.createAnnouncement(dto));
    }

    @PutMapping("/{announcementId}")
    public ResponseEntity<AnnouncementResponseDto> updateAnnouncement(@PathVariable Long announcementId, @RequestBody AnnouncementUpdateDto dto) {
        return ResponseEntity.ok(service.updateAnnouncement(announcementId, dto));
    }

    @DeleteMapping("/{announcementId}")
    public ResponseEntity<String> deleteAnnouncement(@PathVariable Long announcementId) {
        service.deleteAnnouncement(announcementId);
        return ResponseEntity.ok("Announcement deleted successfully.");
    }

    @GetMapping("/{announcementId}")
    public ResponseEntity<AnnouncementResponseDto> getAnnouncementById(@PathVariable Long announcementId) {
        return ResponseEntity.ok(service.getAnnouncementById(announcementId));
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementResponseDto>> getAllAnnouncements() {
        return ResponseEntity.ok(service.getAllAnnouncements());
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<AnnouncementResponseDto>> getByStatus(@PathVariable String status) {
        List<AnnouncementResponseDto> result = service.findByStatusIgnoreCase(status);
        return ResponseEntity.ok(result);
    }
}
