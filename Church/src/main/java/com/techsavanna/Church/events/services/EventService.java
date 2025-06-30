package com.techsavanna.Church.events.services;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.dtos.EventCreateDto;
import com.techsavanna.Church.events.dtos.EventResponseDto;
import com.techsavanna.Church.events.dtos.EventUpdateDto;
import com.techsavanna.Church.members.dtos.MemberCreateDto;
import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.dtos.MemberUpdateDto;
import java.util.List;

public interface EventService {
    EventResponseDto createEvent(EventCreateDto dto);
    EventResponseDto updateEvent(Long eventId, EventUpdateDto dto);
    List<EventResponseDto> getAllEvents();
    EventResponseDto getEventById(Long eventId);
    void deleteEvent(Long eventId);
    void deleteCompletedEvents();
    List<EventResponseDto> getEventsByStatus(EventStatus status);

}
