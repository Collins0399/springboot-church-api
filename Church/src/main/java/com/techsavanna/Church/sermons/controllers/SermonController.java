package com.techsavanna.Church.sermons.controllers;

import com.techsavanna.Church.sermons.dtos.SermonCreateDto;
import com.techsavanna.Church.sermons.dtos.SermonResponseDto;
import com.techsavanna.Church.sermons.dtos.SermonUpdateDto;
import com.techsavanna.Church.sermons.services.SermonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sermons")
public class SermonController {
    @Autowired
    private SermonService sermonService;

    @PostMapping
    public ResponseEntity<SermonResponseDto> createSermon(@RequestBody SermonCreateDto dto) {
        SermonResponseDto created = sermonService.createSermon(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<SermonResponseDto>> getAllSermons() {
        return ResponseEntity.ok(sermonService.getAllSermons());
    }

    @GetMapping("/{sermonId}")
    public ResponseEntity<SermonResponseDto> getSermonById(@PathVariable Long sermonId) {
        return ResponseEntity.ok(sermonService.getSermonById(sermonId));
    }

    @PutMapping("/{sermonId}")
    public ResponseEntity<SermonResponseDto> updateSermon(@PathVariable Long sermonId, @RequestBody SermonUpdateDto dto) {
        return ResponseEntity.ok(sermonService.updateSermon(sermonId, dto));
    }

    @DeleteMapping("/{sermonId}")
    public ResponseEntity<Void> deleteSermon(@PathVariable Long sermonId) {
        sermonService.deleteSermon(sermonId);
        return ResponseEntity.noContent().build();
    }
}
