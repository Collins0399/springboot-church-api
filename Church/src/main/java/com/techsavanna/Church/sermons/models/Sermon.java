package com.techsavanna.Church.sermons.models;

import com.techsavanna.Church.members.models.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
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
    private LocalDate sermonDate;
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member preacher;
}
