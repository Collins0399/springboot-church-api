package com.techsavanna.Church.utils;

import com.techsavanna.Church.enums.EventStatus;

import java.time.LocalDateTime;

public class EventStatusUtil {
    public static EventStatus determineStatus(LocalDateTime startDateTime, LocalDateTime endDateTime, boolean isCanceled, boolean isPostponed) {
        LocalDateTime today = LocalDateTime.now();

        if (isCanceled) return EventStatus.CANCELED;
        if (isPostponed) return EventStatus.POSTPONED;
        if (today.isBefore(startDateTime)) return EventStatus.UPCOMING;
        if (!today.isAfter(endDateTime)) return EventStatus.ONGOING;
        return EventStatus.COMPLETED;
    }
}
