package com.techsavanna.Church.events.controllers;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.dtos.EventCreateDto;
import com.techsavanna.Church.events.dtos.EventUpdateDto;
import com.techsavanna.Church.events.dtos.EventResponseDto;
import com.techsavanna.Church.events.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventCreateDto eventDto) {
        EventResponseDto createdEvent = eventService.createEvent(eventDto);
        return ResponseEntity.ok(createdEvent);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable Long eventId, @RequestBody EventUpdateDto eventDto) {
        EventResponseDto updatedEvent = eventService.updateEvent(eventId, eventDto);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable Long eventId) {
        EventResponseDto event = eventService.getEventById(eventId);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        List<EventResponseDto> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
    @DeleteMapping("/delete/completed")
    public ResponseEntity<String> deleteCompletedEvents() {
        eventService.deleteCompletedEvents();
        return ResponseEntity.ok("All completed events deleted successfully.");
    }
//    @GetMapping("/status/{status}")
//    public ResponseEntity<List<EventResponseDto>> getEventsByStatus(@PathVariable("status") EventStatus status) {
//        EventStatus eventStatus = EventStatus.valueOf(status.toUpperCase());
//        List<EventResponseDto> events = eventService.getEventsByStatus(status);
//        return ResponseEntity.ok(events);
//    }
@GetMapping("/status/{status}")
public ResponseEntity<List<EventResponseDto>> getEventsByStatus(@PathVariable String status) {
    EventStatus eventStatus = EventStatus.valueOf(status.toUpperCase());
    List<EventResponseDto> events = eventService.getEventsByStatus(eventStatus);
    return ResponseEntity.ok(events);
}


}

