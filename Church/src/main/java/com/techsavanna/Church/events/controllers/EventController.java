package com.techsavanna.Church.events.controllers;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.dtos.EventCreateDto;
import com.techsavanna.Church.events.dtos.EventUpdateDto;
import com.techsavanna.Church.events.dtos.EventResponseDto;
import com.techsavanna.Church.events.services.EventService;
import com.techsavanna.Church.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ApiResponse<EventResponseDto> createEvent(@RequestBody EventCreateDto eventDto) {
        return eventService.createEvent(eventDto);
    }

    @PutMapping("/{eventId}")
    public ApiResponse<EventResponseDto> updateEvent(@PathVariable Long eventId, @RequestBody EventUpdateDto eventDto) {
        return eventService.updateEvent(eventId, eventDto);
    }

    @DeleteMapping("/{eventId}")
    public ApiResponse<Void> deleteEvent(@PathVariable Long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @GetMapping("/{eventId}")
    public ApiResponse<EventResponseDto> getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping
    public ApiResponse<List<EventResponseDto>> getAllEvents() {
        return eventService.getAllEvents();
    }

    @DeleteMapping("/delete/completed")
    public ApiResponse<Void> deleteCompletedEvents() {
        return eventService.deleteCompletedEvents();
    }

    @GetMapping("/status/{status}")
    public ApiResponse<List<EventResponseDto>> getEventsByStatus(@PathVariable String status) {
        EventStatus eventStatus = EventStatus.valueOf(status.toUpperCase());
        return eventService.getEventsByStatus(eventStatus);
    }
}
