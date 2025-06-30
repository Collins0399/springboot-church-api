package com.techsavanna.Church.announcements.dtos;

import com.techsavanna.Church.enums.AnnouncementStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnnouncementUpdateDto {
    private Long announcementId;

    private String title;
    private String message;
    private String targetAudience;
    private LocalDate startDate;
    private LocalDate endDate;
}
