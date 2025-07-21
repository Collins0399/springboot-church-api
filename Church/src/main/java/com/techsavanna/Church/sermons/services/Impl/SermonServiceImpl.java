package com.techsavanna.Church.sermons.services.Impl;

import com.techsavanna.Church.handler.ResourceNotFoundException;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.responses.ApiResponse;
import com.techsavanna.Church.sermons.dtos.SermonCreateDto;
import com.techsavanna.Church.sermons.dtos.SermonResponseDto;
import com.techsavanna.Church.sermons.dtos.SermonUpdateDto;
import com.techsavanna.Church.sermons.mappers.SermonMapper;
import com.techsavanna.Church.sermons.models.Sermon;
import com.techsavanna.Church.sermons.repos.SermonRepository;
import com.techsavanna.Church.sermons.services.SermonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ApiResponse<SermonResponseDto> createSermon(SermonCreateDto dto) {
        Member preacher = memberRepository.findById(dto.getPreacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Preacher not found with ID: " + dto.getPreacherId()));

        Sermon sermon = SermonMapper.toEntity(dto, preacher);
        Sermon saved = sermonRepository.save(sermon);
        SermonResponseDto response = SermonMapper.toResponseDto(saved);
        return new ApiResponse<>("success", "Sermon created successfully", response);
    }

    @Override
    public ApiResponse<SermonResponseDto> updateSermon(Long sermonId, SermonUpdateDto dto) {
        Sermon existing = sermonRepository.findById(sermonId)
                .orElseThrow(() -> new ResourceNotFoundException("Sermon not found with ID: " + sermonId));

        Member preacher = memberRepository.findById(dto.getPreacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Preacher not found with ID: " + dto.getPreacherId()));

        Sermon updated = SermonMapper.toUpdatedEntity(existing, dto, preacher);
        Sermon saved = sermonRepository.save(updated);
        SermonResponseDto response = SermonMapper.toResponseDto(saved);
        return new ApiResponse<>("success", "Sermon updated successfully", response);
    }

    @Override
    public ApiResponse<Void> deleteSermon(Long sermonId) {
        if (!sermonRepository.existsById(sermonId)) {
            throw new ResourceNotFoundException("Sermon not found with ID: " + sermonId);
        }
        sermonRepository.deleteById(sermonId);
        return new ApiResponse<>("success", "Sermon deleted successfully", null);
    }

    @Override
    public ApiResponse<SermonResponseDto> getSermonById(Long sermonId) {
        Sermon sermon = sermonRepository.findById(sermonId)
                .orElseThrow(() -> new ResourceNotFoundException("Sermon not found with ID: " + sermonId));
        SermonResponseDto response = SermonMapper.toResponseDto(sermon);
        return new ApiResponse<>("success", "Sermon retrieved successfully", response);
    }

    @Override
    public ApiResponse<Page<SermonResponseDto>> getAllSermons(Pageable pageable) {
        Page<SermonResponseDto> sermons = sermonRepository.findAll(pageable)
                .map(SermonMapper::toResponseDto);

        return new ApiResponse<>("success", "All sermons retrieved successfully", sermons);
    }

}
