package com.techsavanna.Church.events.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventResponseDto {
    private Long eventId;

    private String eventName;
    private String eventType;
    private String description;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private String location;
    private String host;

    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
