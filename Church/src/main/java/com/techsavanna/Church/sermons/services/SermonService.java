package com.techsavanna.Church.sermons.services;

import com.techsavanna.Church.sermons.dtos.SermonCreateDto;
import com.techsavanna.Church.sermons.dtos.SermonResponseDto;
import com.techsavanna.Church.sermons.dtos.SermonUpdateDto;

import java.util.List;

public interface SermonService {
    SermonResponseDto createSermon(SermonCreateDto dto);
    SermonResponseDto updateSermon(Long sermonId, SermonUpdateDto dto);
    void deleteSermon(Long sermonId);
    SermonResponseDto getSermonById(Long sermonId);
    List<SermonResponseDto> getAllSermons();
}
