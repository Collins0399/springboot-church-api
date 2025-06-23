package com.techsavanna.Church.announcements.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnouncementCreateDto {
    private String title;
    private String message;
    private String targetAudience;
}
