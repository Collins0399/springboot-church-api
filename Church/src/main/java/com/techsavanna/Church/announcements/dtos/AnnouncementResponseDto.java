package com.techsavanna.Church.announcements.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnouncementResponseDto {
    private Long announcementId;
    private String title;
    private String message;
    private String targetAudience;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
