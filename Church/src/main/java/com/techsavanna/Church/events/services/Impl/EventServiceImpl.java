//package com.techsavanna.Church.events.services.Impl;
//
//import com.techsavanna.Church.events.dtos.EventCreateDto;
//import com.techsavanna.Church.events.models.Event;
//import com.techsavanna.Church.events.repos.EventRepository;
//import com.techsavanna.Church.events.services.EventService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class EventServiceImpl implements EventService {
//    @Autowired
//    private EventRepository eventRepository;
//
//    //Methods to map EventDto to Event entity
//    private EventCreateDto mapToDto(Event event) {
//        EventCreateDto dto =new EventCreateDto();
//        dto.setEventId(event.getEventId());
//        dto.setEventName(event.getEventName());
//        dto.setEventType(event.getEventType());
//        dto.setDescription(event.getDescription());
//        dto.setStartDateTime(event.getStartDateTime());
//        dto.setEndDateTime(event.getEndDateTime());
//        dto.setLocation(event.getLocation());
//        dto.setHost(event.getHost());
//        dto.setStatus(event.getStatus());
//        dto.setCreatedAt(event.getCreatedAt());
//        dto.setUpdatedAt(event.getUpdatedAt());
//
//        return dto;
//    }
//
//    //Methods to map Event entity to EventDto
//    private Event mapToEntity(EventCreateDto eventCreateDto){
//        Event event = new Event ();
//        event.setEventName(eventCreateDto.getEventName());
//        event.setEventType(eventCreateDto.getEventType());
//        event.setDescription(eventCreateDto.getDescription());
//        event.setStartDateTime(eventCreateDto.getStartDateTime());
//        event.setEndDateTime(eventCreateDto.getEndDateTime());
//        event.setLocation(eventCreateDto.getLocation());
//        event.setHost(eventCreateDto.getHost());
//        event.setStatus(eventCreateDto.getStatus());
//        event.setCreatedAt(LocalDateTime.now());
//        event.setUpdatedAt(LocalDateTime.now());
//
//        return event;
//    }
//
//    @Override
//    public EventCreateDto createEvent(EventCreateDto eventCreateDto) {
//        Event event = mapToEntity(eventCreateDto) ;
//        Event savedEvent = eventRepository.save (event);
//        return mapToDto(savedEvent);
//    }
//    @Override
//    public EventCreateDto updateEvent(long eventId , EventCreateDto eventCreateDto) {
//        Event existingEvent = eventRepository.findById(eventId)
//                .orElseThrow(() -> new RuntimeException("Event not found"));
//
//        // Update only changed fields
//        existingEvent.setEventName(eventCreateDto.getEventName());
//        existingEvent.setEventType(eventCreateDto.getEventType());
//        existingEvent.setDescription(eventCreateDto.getDescription());
//        existingEvent.setStartDateTime(eventCreateDto.getStartDateTime());
//        existingEvent.setEndDateTime(eventCreateDto.getEndDateTime());
//        existingEvent.setLocation(eventCreateDto.getLocation());
//        existingEvent.setHost(eventCreateDto.getHost());
//        existingEvent.setStatus(eventCreateDto.getStatus());
//        existingEvent.setUpdatedAt(LocalDateTime.now());
//
//        Event saved = eventRepository.save(existingEvent);
//        return mapToDto(saved);
//    }
//    @Override
//    public void deleteEvent(Long eventId) {
//        eventRepository .deleteById(eventId);
//    }
//    @Override
//    public EventCreateDto getEventById(Long eventId) {
//        Optional<Event> event = eventRepository.findById(eventId);
//        return event.map(this::mapToDto).orElse(null);
//    }
//    @Override
//    public List<EventCreateDto> getAllEvents() {
//        return eventRepository.findAll()
//                .stream()
//                .map( this::mapToDto)
//                .collect(Collectors.toList());
//    }
//}
