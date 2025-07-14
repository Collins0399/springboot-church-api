package com.techsavanna.Church.announcements.services.Impl;

import com.techsavanna.Church.announcements.dtos.*;
import com.techsavanna.Church.announcements.mappers.AnnouncementMapper;
import com.techsavanna.Church.announcements.models.Announcement;
import com.techsavanna.Church.announcements.repos.AnnouncementRepository;
import com.techsavanna.Church.announcements.services.AnnouncementService;
import com.techsavanna.Church.enums.AnnouncementStatus;
import com.techsavanna.Church.handler.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository repository;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository repository) {
        this.repository = repository;
    }

    @Override
    public AnnouncementResponseDto createAnnouncement(AnnouncementCreateDto dto) {
        Announcement entity = AnnouncementMapper.toEntity(dto);
        return AnnouncementMapper.toResponseDto(repository.save(entity));
    }

    @Override
    public AnnouncementResponseDto updateAnnouncement(Long announcementId, AnnouncementUpdateDto dto) {
        Announcement announcement = repository.findById(announcementId)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found with ID: " + announcementId));

        AnnouncementMapper.updateEntity(announcement, dto);
        return AnnouncementMapper.toResponseDto(repository.save(announcement));
    }

    @Override
    public void deleteAnnouncement(Long announcementId) {
        if (!repository.existsById(announcementId)) {
            throw new ResourceNotFoundException("Announcement not found with ID: " + announcementId);
        }
        repository.deleteById(announcementId);
    }

    @Override
    public AnnouncementResponseDto getAnnouncementById(Long announcementId) {
        Announcement announcement = repository.findById(announcementId)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found with ID: " + announcementId));
        return AnnouncementMapper.toResponseDto(announcement);
    }

    @Override
    public List<AnnouncementResponseDto> getAllAnnouncements() {
        return repository.findAll().stream()
                .map(AnnouncementMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnnouncementResponseDto> findByStatusIgnoreCase(String status) {
        List<Announcement> announcements = repository.findByStatusIgnoreCase(status);
        return announcements.stream()
                .map(AnnouncementMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}
