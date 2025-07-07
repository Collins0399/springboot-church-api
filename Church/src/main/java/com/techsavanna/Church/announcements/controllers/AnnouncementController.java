package com.techsavanna.Church.announcements.controllers;

import com.techsavanna.Church.announcements.dtos.*;
import com.techsavanna.Church.announcements.services.AnnouncementService;
import com.techsavanna.Church.enums.AnnouncementStatus;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiResponse<AnnouncementResponseDto>> create(@RequestBody AnnouncementCreateDto dto) {
        AnnouncementResponseDto result = service.createAnnouncement(dto);
        ApiResponse<AnnouncementResponseDto> response = new ApiResponse<>("success", "Announcement created successfully", result);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{announcementId}")
    public ResponseEntity<ApiResponse<AnnouncementResponseDto>> updateAnnouncement(
            @PathVariable Long announcementId,
            @RequestBody AnnouncementUpdateDto dto) {
        AnnouncementResponseDto result = service.updateAnnouncement(announcementId, dto);
        ApiResponse<AnnouncementResponseDto> response = new ApiResponse<>("success", "Announcement updated successfully", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{announcementId}")
    public ResponseEntity<ApiResponse<String>> deleteAnnouncement(@PathVariable Long announcementId) {
        service.deleteAnnouncement(announcementId);
        ApiResponse<String> response = new ApiResponse<>("success", "Announcement deleted successfully", "Announcement deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{announcementId}")
    public ResponseEntity<ApiResponse<AnnouncementResponseDto>> getAnnouncementById(@PathVariable Long announcementId) {
        AnnouncementResponseDto result = service.getAnnouncementById(announcementId);
        ApiResponse<AnnouncementResponseDto> response = new ApiResponse<>("success", "Announcement fetched successfully", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AnnouncementResponseDto>>> getAllAnnouncements() {
        List<AnnouncementResponseDto> result = service.getAllAnnouncements();
        ApiResponse<List<AnnouncementResponseDto>> response = new ApiResponse<>("success", "All announcements retrieved successfully", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse<List<AnnouncementResponseDto>>> getByStatus(@PathVariable String status) {
        List<AnnouncementResponseDto> result = service.findByStatusIgnoreCase(status);
        ApiResponse<List<AnnouncementResponseDto>> response = new ApiResponse<>("success", "Announcements by status retrieved successfully", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
