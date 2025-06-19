package com.techsavanna.Church.events.services.Impl;

import com.techsavanna.Church.events.dtos.EventDto;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.events.repos.EventRepository;
import com.techsavanna.Church.events.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    //Methods to map EventDto to Event entity
    private EventDto mapToDto(Event event) {
        EventDto dto =new EventDto();
        dto.setEventId(event.getEventId());
        dto.setEventName(event.getEventName());
        dto.setEventType(event.getEventType());
        dto.setDescription(event.getDescription());
        dto.setStartDateTime(event.getStartDateTime());
        dto.setEndDateTime(event.getEndDateTime());
        dto.setLocation(event.getLocation());
        dto.setHost(event.getHost());
        dto.setStatus(event.getStatus());
        dto.setCreatedAt(event.getCreatedAt());
        dto.setUpdatedAt(event.getUpdatedAt());

        return dto;
    }

    //Methods to map Event entity to EventDto
    private Event mapToEntity(EventDto eventDto){
        Event event = new Event ();
        event.setEventName(eventDto.getEventName());
        event.setEventType(eventDto.getEventType());
        event.setDescription(eventDto.getDescription());
        event.setStartDateTime(eventDto.getStartDateTime());
        event.setEndDateTime(eventDto.getEndDateTime());
        event.setLocation(eventDto.getLocation());
        event.setHost(eventDto.getHost());
        event.setStatus(eventDto.getStatus());
        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());

        return event;
    }

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = mapToEntity( eventDto) ;
        Event savedEvent = eventRepository.save (event);
        return mapToDto(savedEvent);
    }
    @Override
    public EventDto updateEvent(long eventId , EventDto eventDto) {
        Event existingEvent = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Update only changed fields
        existingEvent.setEventName(eventDto.getEventName());
        existingEvent.setEventType(eventDto.getEventType());
        existingEvent.setDescription(eventDto.getDescription());
        existingEvent.setStartDateTime(eventDto.getStartDateTime());
        existingEvent.setEndDateTime(eventDto.getEndDateTime());
        existingEvent.setLocation(eventDto.getLocation());
        existingEvent.setHost(eventDto.getHost());
        existingEvent.setStatus(eventDto.getStatus());
        existingEvent.setUpdatedAt(LocalDateTime.now());

        Event saved = eventRepository.save(existingEvent);
        return mapToDto(saved);
    }
    @Override
    public void deleteEvent(Long eventId) {
        eventRepository .deleteById(eventId);
    }
    @Override
    public EventDto getEventById(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        return event.map(this::mapToDto).orElse(null);
    }
    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map( this::mapToDto)
                .collect(Collectors.toList());
    }
}
