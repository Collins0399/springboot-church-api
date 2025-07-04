package com.techsavanna.Church.events.mappers;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.dtos.EventCreateDto;
import com.techsavanna.Church.events.dtos.EventUpdateDto;
import com.techsavanna.Church.events.dtos.EventResponseDto;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.utils.EventStatusUtil;

import java.time.LocalDateTime;

public class EventMapper {

    public static Event toEntity(EventCreateDto dto) {
        Event event = new Event();
        event.setEventName(dto.getEventName());
        event.setEventType(dto.getEventType());
        event.setDescription(dto.getDescription());
        event.setStartDateTime(dto.getStartDateTime());
        event.setEndDateTime(dto.getEndDateTime());
        event.setLocation(dto.getLocation());
        event.setHost(dto.getHost());

        event.setStatus(EventStatusUtil.determineStatus(
                dto.getStartDateTime(),
                dto.getEndDateTime()
        ));

        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());

        return event;
    }

    public static Event toUpdatedEntity(Event event, EventUpdateDto dto) {
        event.setEventName(dto.getEventName());
        event.setEventType(dto.getEventType());
        event.setDescription(dto.getDescription());
        event.setStartDateTime(dto.getStartDateTime());
        event.setEndDateTime(dto.getEndDateTime());
        event.setLocation(dto.getLocation());
        event.setHost(dto.getHost());

        event.setStatus(EventStatusUtil.determineStatus(
                dto.getStartDateTime(),
                dto.getEndDateTime()
        ));

        event.setUpdatedAt(LocalDateTime.now());
        return event;
    }

    public static EventResponseDto toResponseDto(Event event) {
        EventResponseDto dto = new EventResponseDto();
        dto.setEventId(event.getEventId());
        dto.setEventName(event.getEventName());
        dto.setEventType(event.getEventType());
        dto.setDescription(event.getDescription());
        dto.setStartDateTime(event.getStartDateTime());
        dto.setEndDateTime(event.getEndDateTime());
        dto.setLocation(event.getLocation());
        dto.setHost(event.getHost());
        dto.setStatus(event.getStatus().name());
        dto.setCreatedAt(event.getCreatedAt());
        dto.setUpdatedAt(event.getUpdatedAt());
        return dto;
    }
}

