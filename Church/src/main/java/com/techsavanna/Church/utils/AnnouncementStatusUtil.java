package com.techsavanna.Church.utils;

import com.techsavanna.Church.announcements.models.Announcement;
import com.techsavanna.Church.enums.AnnouncementStatus;

import java.time.LocalDate;

public class AnnouncementStatusUtil {
    public static AnnouncementStatus determineStatus(LocalDate startDate, LocalDate endDate) {
        LocalDate today = LocalDate.now();

        if (startDate == null || endDate == null) {
            return AnnouncementStatus.INACTIVE;
        }

        if (today.isBefore(startDate)) {
            return AnnouncementStatus.INACTIVE;
        } else if (!today.isAfter(endDate)) {
            return AnnouncementStatus.ACTIVE;
        } else {
            return AnnouncementStatus.ARCHIVED;
        }
    }
}
