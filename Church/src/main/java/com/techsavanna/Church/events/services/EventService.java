package com.techsavanna.Church.events.services;

import com.techsavanna.Church.events.dtos.EventDto;
import com.techsavanna.Church.events.models.Event;

import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto);
    EventDto updateEvent(long eventId , EventDto eventDto);
    void deleteEvent(Long eventId);
    EventDto getEventById(Long eventId);
    List<EventDto> getAllEvents();
}
