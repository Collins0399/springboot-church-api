package com.techsavanna.Church.announcements.dtos;

import com.techsavanna.Church.enums.AnnouncementStatus;
import com.techsavanna.Church.utils.AnnouncementStatusUtil;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnnouncementCreateDto {
    private String title;
    private String message;
    private String targetAudience;
    private LocalDate startDate;
    private LocalDate endDate;

    public AnnouncementStatus computeStatus() {
        return AnnouncementStatusUtil.determineStatus(startDate, endDate);
    }
}
