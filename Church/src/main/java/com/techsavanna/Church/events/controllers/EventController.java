//package com.techsavanna.Church.events.controllers;
//
//import com.techsavanna.Church.events.dtos.EventCreateDto;
//import com.techsavanna.Church.events.services.EventService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/events")
//public class EventController {
//    @Autowired
//    private EventService eventService;
//
//    @PostMapping
//    public ResponseEntity<EventCreateDto> createEvent(@RequestBody EventCreateDto eventCreateDto) {
//        EventCreateDto created = eventService.createEvent(eventCreateDto);
//        return ResponseEntity.ok(created);
//    }
//
//    @PutMapping("/{eventId}")
//    public ResponseEntity<EventCreateDto> updateEvent(@PathVariable Long eventId, @RequestBody EventCreateDto eventCreateDto) {
//        EventCreateDto updated = eventService.updateEvent(eventId, eventCreateDto);
//        return ResponseEntity.ok(updated);
//    }
//
//    @GetMapping("/{eventId}")
//    public ResponseEntity<EventCreateDto> getEventById(@PathVariable Long eventId) {
//        EventCreateDto event = eventService.getEventById(eventId);
//        return ResponseEntity.ok(event);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<EventCreateDto>> getAllEvents() {
//        List<EventCreateDto> list = eventService.getAllEvents();
//        return ResponseEntity.ok(list);
//    }
//
//    @DeleteMapping("/{eventId}")
//    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
//        eventService.deleteEvent(eventId);
//        return ResponseEntity.noContent().build();
//    }
//
//}
