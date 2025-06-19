package com.techsavanna.Church.sermons.models;

import com.techsavanna.Church.members.models.Members;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sermons")
public class Sermon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sermonId;

    private String title;
    private String theme;
    private String bibleVerse;
    private String description;
    private LocalDate sermonDate;

    @ManyToOne
    @JoinColumn(name = "memberId")//This is the id of the preacher from members table
    private Members preacher;
}
