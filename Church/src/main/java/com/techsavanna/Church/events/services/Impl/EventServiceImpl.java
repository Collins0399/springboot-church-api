package com.techsavanna.Church.events.services.Impl;

import com.techsavanna.Church.events.dtos.EventCreateDto;
import com.techsavanna.Church.events.dtos.EventUpdateDto;
import com.techsavanna.Church.events.dtos.EventResponseDto;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.events.repos.EventRepository;
import com.techsavanna.Church.events.services.EventService;
import com.techsavanna.Church.mappers.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventResponseDto createEvent(EventCreateDto dto) {
        Event event = EventMapper.toEntity(dto);
        Event savedEvent = eventRepository.save(event);
        return EventMapper.toResponseDto(savedEvent);
    }

    @Override
    public EventResponseDto updateEvent(Long eventId, EventUpdateDto dto) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Event updatedEvent = EventMapper.toUpdatedEntity(event, dto);
        return EventMapper.toResponseDto(eventRepository.save(updatedEvent));
    }

    @Override
    public void deleteEvent(Long eventId) {
        if (!eventRepository.existsById(eventId)) {
            throw new RuntimeException("Event not found");
        }
        eventRepository.deleteById(eventId);
    }

    @Override
    public EventResponseDto getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return EventMapper.toResponseDto(event);
    }

    @Override
    public List<EventResponseDto> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(EventMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
