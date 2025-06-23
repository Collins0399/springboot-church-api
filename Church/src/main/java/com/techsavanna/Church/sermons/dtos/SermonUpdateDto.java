package com.techsavanna.Church.sermons.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SermonUpdateDto {
    private String title;
    private String theme;
    private LocalDate sermonDate;
    private String videoUrl;
    private Long preacherId;
}
