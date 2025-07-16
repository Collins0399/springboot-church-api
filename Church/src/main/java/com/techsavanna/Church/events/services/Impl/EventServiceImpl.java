package com.techsavanna.Church.events.services.Impl;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.handler.ResourceNotFoundException;
import com.techsavanna.Church.events.dtos.EventCreateDto;
import com.techsavanna.Church.events.dtos.EventUpdateDto;
import com.techsavanna.Church.events.dtos.EventResponseDto;
import com.techsavanna.Church.events.mappers.EventMapper;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.events.repos.EventRepository;
import com.techsavanna.Church.events.services.EventService;
import com.techsavanna.Church.responses.ApiResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public ApiResponse<EventResponseDto> createEvent(EventCreateDto dto) {
        Event event = EventMapper.toEntity(dto);
        Event savedEvent = eventRepository.save(event);
        return new ApiResponse<>("success", "Event created successfully", EventMapper.toResponseDto(savedEvent));
    }

    @Override
    public ApiResponse<EventResponseDto> updateEvent(Long eventId, EventUpdateDto dto) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));

        Event updatedEvent = EventMapper.toUpdatedEntity(event, dto);
        return new ApiResponse<>("success", "Event updated successfully", EventMapper.toResponseDto(eventRepository.save(updatedEvent)));
    }

    @Override
    public ApiResponse<Void> deleteEvent(Long eventId) {
        if (!eventRepository.existsById(eventId)) {
            throw new ResourceNotFoundException("Event not found with ID: " + eventId);
        }
        eventRepository.deleteById(eventId);
        return new ApiResponse<>("success", "Event deleted successfully", null);
    }

    @Override
    public ApiResponse<EventResponseDto> getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));
        return new ApiResponse<>("success", "Event fetched successfully", EventMapper.toResponseDto(event));
    }

    @Override
    public ApiResponse<List<EventResponseDto>> getAllEvents() {
        List<EventResponseDto> events = eventRepository.findAll()
                .stream()
                .map(EventMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "All events retrieved successfully", events);
    }

    @Override
    @Transactional
    public ApiResponse<Void> deleteCompletedEvents() {
        eventRepository.deleteCompletedEvents();
        return new ApiResponse<>("success", "All completed events deleted successfully", null);
    }

    @Override
    public ApiResponse<List<EventResponseDto>> getEventsByStatus(EventStatus status) {
        List<Event> events = eventRepository.findByStatus(status);
        List<EventResponseDto> dtos = events.stream()
                .map(EventMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "Events with status " + status + " retrieved successfully", dtos);
    }
}
