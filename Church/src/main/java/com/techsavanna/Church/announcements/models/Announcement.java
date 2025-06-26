package com.techsavanna.Church.announcements.models;

import com.techsavanna.Church.enums.AnnouncementStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Table (name = "announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;

    @Setter
    private String title;

    @Setter
    private String message;

    @Setter
    private String targetAudience;

    @Setter
    private LocalDate startDate;

    @Setter
    private LocalDate endDate;

    @Setter
    @Enumerated(EnumType.STRING)
    private AnnouncementStatus status;

    @Setter
    private LocalDateTime createdAt;
    @Setter
    private LocalDateTime updatedAt;
}
