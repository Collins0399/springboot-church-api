package com.techsavanna.Church.events.models;

import com.techsavanna.Church.attendance.models.Attendance;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long eventId;

    @Setter @Getter
    private String eventName;
    @Setter @Getter
    private String eventType;
    @Setter @Getter
    private String description;

    @Setter @Getter
    private LocalDateTime startDateTime;
    @Setter @Getter
    private LocalDateTime endDateTime;

    @Setter @Getter
    private String location;
    @Setter @Getter
    private String host;

    @Setter @Getter
    private String status;

    @Setter @Getter
    private LocalDateTime createdAt;
    @Setter @Getter
    private LocalDateTime updatedAt;

    @Setter @Getter
    @OneToMany(mappedBy = "event")
    private List<Attendance> attendance;

}
