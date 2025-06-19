//package com.techsavanna.Church.announcements.services.Impl;
//
//import com.techsavanna.Church.announcements.dtos.AnnouncementDto;
//import com.techsavanna.Church.announcements.models.Announcement;
//import com.techsavanna.Church.announcements.repos.AnnouncementRepository;
//import com.techsavanna.Church.announcements.services.AnnouncementService;
//import com.techsavanna.Church.events.dtos.EventDto;
//import com.techsavanna.Church.events.models.Event;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class AnnouncementServiceImpl implements AnnouncementService {
//    @Autowired
//    private AnnouncementRepository announcementRepository;
//
//    //Methods to map Dto to  entity
//    private AnnouncementDto mapToDto(Announcement announcement) {
//        AnnouncementDto dto =new AnnouncementDto();
//        dto.setEventId(event.getEventId());
//
//        return dto;
//    }
//
//    //Methods to map entity to Dto
//    private Announcement mapToEntity(AnnouncementDto announcementDto){
//        Announcement announcement = new Announcement ();
//        event.setEventName(eventDto.getEventName());
//
//
//        return announcement;
//    }
//
//    @Override
//    public AnnouncementDto createAnnouncement(AnnouncementDto announcementDto) {
//        Announcement announcement = mapToEntity( announcementDto) ;
//        Announcement savedAnnouncement = announcementRepository.save (announcement);
//        return mapToDto(savedAnnouncement);
//    }
//    @Override
//    public AnnouncementDto updateAnnouncement(Long announcementId, AnnouncementDto announcementDto) {
//        Event existingEvent = eventRepository.findById(eventId)
//                .orElseThrow(() -> new RuntimeException("Event not found"));
//
//        // Update only changed fields
//        existingEvent.setEventName(eventDto.getEventName());
//
//        Announcement saved = announcementRepository.save(existingAnnouncement);
//        return mapToDto(saved);
//    }
//    @Override
//    public void deleteAnnouncement(Long announcementId) {
//        eventRepository .deleteById(eventId);
//    }
//    @Override
//    public EventDto getEventById(Long eventId) {
//        Optional<Event> event = eventRepository.findById(eventId);
//        return event.map(this::mapToDto).orElse(null);
//    }
//    @Override
//    public List<EventDto> getAllEvents() {
//        return eventRepository.findAll()
//                .stream()
//                .map( this::mapToDto)
//                .collect(Collectors.toList());
//    }
//}
