package com.techsavanna.Church.events.controllers;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.dtos.EventCreateDto;
import com.techsavanna.Church.events.dtos.EventUpdateDto;
import com.techsavanna.Church.events.dtos.EventResponseDto;
import com.techsavanna.Church.events.services.EventService;

import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<ApiResponse<EventResponseDto>> createEvent(@RequestBody EventCreateDto eventDto) {
        EventResponseDto createdEvent = eventService.createEvent(eventDto);
        ApiResponse<EventResponseDto> response = new ApiResponse<>("success", "Event created successfully", createdEvent);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<ApiResponse<EventResponseDto>> updateEvent(@PathVariable Long eventId, @RequestBody EventUpdateDto eventDto) {
        EventResponseDto updatedEvent = eventService.updateEvent(eventId, eventDto);
        ApiResponse<EventResponseDto> response = new ApiResponse<>("success", "Event updated successfully", updatedEvent);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<ApiResponse<Void>> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        ApiResponse<Void> response = new ApiResponse<>("success", "Event deleted successfully", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<ApiResponse<EventResponseDto>> getEventById(@PathVariable Long eventId) {
        EventResponseDto event = eventService.getEventById(eventId);
        ApiResponse<EventResponseDto> response = new ApiResponse<>("success", "Event fetched successfully", event);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EventResponseDto>>> getAllEvents() {
        List<EventResponseDto> events = eventService.getAllEvents();
        ApiResponse<List<EventResponseDto>> response = new ApiResponse<>("success", "All events retrieved successfully", events);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/completed")
    public ResponseEntity<ApiResponse<String>> deleteCompletedEvents() {
        eventService.deleteCompletedEvents();
        ApiResponse<String> response = new ApiResponse<>("success", "All completed events deleted successfully.", "All completed events deleted successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse<List<EventResponseDto>>> getEventsByStatus(@PathVariable String status) {
        EventStatus eventStatus = EventStatus.valueOf(status.toUpperCase());
        List<EventResponseDto> events = eventService.getEventsByStatus(eventStatus);
        ApiResponse<List<EventResponseDto>> response = new ApiResponse<>("success", "Events by status fetched successfully", events);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

