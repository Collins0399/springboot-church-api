package com.techsavanna.Church.announcements.dtos;

import com.techsavanna.Church.enums.AnnouncementStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AnnouncementResponseDto {
    private Long announcementId;
    private String title;
    private String message;
    private String targetAudience;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate startDate;
    private LocalDate endDate;
    private AnnouncementStatus status;
}
