package com.techsavanna.Church.sermons.controllers;

import com.techsavanna.Church.responses.ApiResponse;
import com.techsavanna.Church.sermons.dtos.SermonCreateDto;
import com.techsavanna.Church.sermons.dtos.SermonResponseDto;
import com.techsavanna.Church.sermons.dtos.SermonUpdateDto;
import com.techsavanna.Church.sermons.services.SermonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sermons")
public class SermonController {
    @Autowired
    private SermonService sermonService;

    @PostMapping
    public ResponseEntity<ApiResponse<SermonResponseDto>> createSermon(@RequestBody SermonCreateDto dto) {
        SermonResponseDto created = sermonService.createSermon(dto);
        ApiResponse<SermonResponseDto> response = new ApiResponse<>("success", "Sermon created successfully", created);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SermonResponseDto>>> getAllSermons() {
        List<SermonResponseDto> sermons = sermonService.getAllSermons();
        ApiResponse<List<SermonResponseDto>> response = new ApiResponse<>("success", "All sermons retrieved successfully", sermons);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{sermonId}")
    public ResponseEntity<ApiResponse<SermonResponseDto>> getSermonById(@PathVariable Long sermonId) {
        SermonResponseDto sermon = sermonService.getSermonById(sermonId);
        ApiResponse<SermonResponseDto> response = new ApiResponse<>("success", "Sermon fetched successfully", sermon);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{sermonId}")
    public ResponseEntity<ApiResponse<SermonResponseDto>> updateSermon(@PathVariable Long sermonId, @RequestBody SermonUpdateDto dto) {
        SermonResponseDto updated = sermonService.updateSermon(sermonId, dto);
        ApiResponse<SermonResponseDto> response = new ApiResponse<>("success", "Sermon updated successfully", updated);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{sermonId}")
    public ResponseEntity<ApiResponse<String>> deleteSermon(@PathVariable Long sermonId) {
        sermonService.deleteSermon(sermonId);
        ApiResponse<String> response = new ApiResponse<>("success", "Sermon deleted successfully", "Sermon deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
