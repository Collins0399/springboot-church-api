package com.techsavanna.Church.events.services;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.dtos.EventCreateDto;
import com.techsavanna.Church.events.dtos.EventResponseDto;
import com.techsavanna.Church.events.dtos.EventUpdateDto;
import com.techsavanna.Church.responses.ApiResponse;

import java.util.List;

public interface EventService {
    ApiResponse<EventResponseDto> createEvent(EventCreateDto dto);
    ApiResponse<EventResponseDto> updateEvent(Long eventId, EventUpdateDto dto);
    ApiResponse<List<EventResponseDto>> getAllEvents();
    ApiResponse<EventResponseDto> getEventById(Long eventId);
    ApiResponse<Void> deleteEvent(Long eventId);
    ApiResponse<Void> deleteCompletedEvents();
    ApiResponse<List<EventResponseDto>> getEventsByStatus(EventStatus status);
}
