package com.techsavanna.Church.events.services;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.dtos.EventCreateDto;
import com.techsavanna.Church.events.dtos.EventResponseDto;
import com.techsavanna.Church.events.dtos.EventUpdateDto;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventService {
    ApiResponse<EventResponseDto> createEvent(EventCreateDto dto);
    ApiResponse<EventResponseDto> updateEvent(Long eventId, EventUpdateDto dto);
    ApiResponse<Page<EventResponseDto>> getAllEvents(Pageable pageable);
    ApiResponse<EventResponseDto> getEventById(Long eventId);
    ApiResponse<Void> deleteEvent(Long eventId);
    ApiResponse<Void> deleteCompletedEvents();
    ApiResponse<Page<EventResponseDto>> getEventsByStatus(EventStatus status , Pageable pageable);
}
