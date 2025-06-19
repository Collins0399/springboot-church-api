package com.techsavanna.Church.announcements.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;

    private String title;
    private String message;
    private String targetAudience;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
