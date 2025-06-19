package com.techsavanna.Church.sermons.models;

import com.techsavanna.Church.members.models.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "sermons")
public class Sermon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long sermonId;

    @Setter @Getter
    private String title;
    @Setter @Getter
    private String theme;
    @Setter @Getter
    private LocalDate sermonDate;
    @Setter @Getter
    private String videoUrl;

    @Setter @Getter
    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member preacher;
}
