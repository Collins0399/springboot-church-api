package com.techsavanna.Church.events.dtos;

import com.techsavanna.Church.enums.EventStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventCreateDto {

    private String eventName;
    private String eventType;
    private String description;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private String location;
    private String host;
}
