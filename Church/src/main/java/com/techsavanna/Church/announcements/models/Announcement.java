package com.techsavanna.Church.announcements.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table (name = "announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long announcementId;

    @Setter @Getter
    private String title;
    @Setter @Getter
    private String message;
    @Setter @Getter
    private String targetAudience;
    @Setter @Getter
    private LocalDateTime createdAt;
    @Setter @Getter
    private LocalDateTime updatedAt;
}
