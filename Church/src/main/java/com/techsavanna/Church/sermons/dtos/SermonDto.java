package com.techsavanna.Church.sermons.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SermonDto {
    private Long sermonId;

    private String title;
    private String theme;
    private String bibleVerse;
    private String description;
    private LocalDate sermonDate;
}
