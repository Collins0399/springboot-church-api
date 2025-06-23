package com.techsavanna.Church.sermons.services.Impl;

import com.techsavanna.Church.mappers.SermonMapper;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.sermons.dtos.SermonCreateDto;
import com.techsavanna.Church.sermons.dtos.SermonResponseDto;
import com.techsavanna.Church.sermons.dtos.SermonUpdateDto;
import com.techsavanna.Church.sermons.models.Sermon;
import com.techsavanna.Church.sermons.repos.SermonRepository;
import com.techsavanna.Church.sermons.services.SermonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SermonServiceImpl implements SermonService {
    @Autowired
    private SermonRepository sermonRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public SermonResponseDto createSermon(SermonCreateDto dto) {
        Member preacher = memberRepository.findById(dto.getPreacherId())
                .orElseThrow(() -> new EntityNotFoundException("Preacher not found with ID: " + dto.getPreacherId()));

        Sermon sermon = SermonMapper.toEntity(dto, preacher);
        Sermon saved = sermonRepository.save(sermon);
        return SermonMapper.toResponseDto(saved);
    }

    @Override
    public List<SermonResponseDto> getAllSermons() {
        return sermonRepository.findAll()
                .stream()
                .map(SermonMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public SermonResponseDto getSermonById(Long sermonId) {
        Sermon sermon = sermonRepository.findById(sermonId)
                .orElseThrow(() -> new EntityNotFoundException("Sermon not found with ID: " + sermonId));
        return SermonMapper.toResponseDto(sermon);
    }

    @Override
    public SermonResponseDto updateSermon(Long sermonId, SermonUpdateDto dto) {
        Sermon existing = sermonRepository.findById(sermonId)
                .orElseThrow(() -> new EntityNotFoundException("Sermon not found with ID: " + sermonId));

        Member preacher = memberRepository.findById(dto.getPreacherId())
                .orElseThrow(() -> new EntityNotFoundException("Preacher not found with ID: " + dto.getPreacherId()));

        Sermon updated = SermonMapper.toUpdatedEntity(existing, dto, preacher);
        Sermon saved = sermonRepository.save(updated);
        return SermonMapper.toResponseDto(saved);
    }

    @Override
    public void deleteSermon(Long sermonId) {
        if (!sermonRepository.existsById(sermonId)) {
            throw new EntityNotFoundException("Sermon not found with ID: " + sermonId);
        }
        sermonRepository.deleteById(sermonId);
    }
}
