package com.techsavanna.Church.sermons.controllers;

import com.techsavanna.Church.responses.ApiResponse;
import com.techsavanna.Church.sermons.dtos.SermonCreateDto;
import com.techsavanna.Church.sermons.dtos.SermonResponseDto;
import com.techsavanna.Church.sermons.dtos.SermonUpdateDto;
import com.techsavanna.Church.sermons.services.SermonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sermons")
public class SermonController {

    @Autowired
    private SermonService sermonService;

    @PostMapping
    public ApiResponse<SermonResponseDto> createSermon(@RequestBody SermonCreateDto dto) {
        return sermonService.createSermon(dto);
    }

    @GetMapping
    public ApiResponse<Page<SermonResponseDto>> getAllSermons(Pageable pageable) {
        return sermonService.getAllSermons(pageable);
    }


    @GetMapping("/{sermonId}")
    public ApiResponse<SermonResponseDto> getSermonById(@PathVariable Long sermonId) {
        return sermonService.getSermonById(sermonId);
    }

    @PutMapping("/{sermonId}")
    public ApiResponse<SermonResponseDto> updateSermon(@PathVariable Long sermonId, @RequestBody SermonUpdateDto dto) {
        return sermonService.updateSermon(sermonId, dto);
    }

    @DeleteMapping("/{sermonId}")
    public ApiResponse<Void> deleteSermon(@PathVariable Long sermonId) {
        return sermonService.deleteSermon(sermonId);
    }
}
