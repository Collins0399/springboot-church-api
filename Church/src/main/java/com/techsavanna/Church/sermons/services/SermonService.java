package com.techsavanna.Church.sermons.services;

import com.techsavanna.Church.responses.ApiResponse;
import com.techsavanna.Church.sermons.dtos.SermonCreateDto;
import com.techsavanna.Church.sermons.dtos.SermonResponseDto;
import com.techsavanna.Church.sermons.dtos.SermonUpdateDto;

import java.util.List;

public interface SermonService {
    ApiResponse<SermonResponseDto> createSermon(SermonCreateDto dto);
    ApiResponse<SermonResponseDto> updateSermon(Long sermonId, SermonUpdateDto dto);
    ApiResponse<Void> deleteSermon(Long sermonId);
    ApiResponse<SermonResponseDto> getSermonById(Long sermonId);
    ApiResponse<List<SermonResponseDto>> getAllSermons();
}
