package com.techsavanna.Church.events.models;

import com.techsavanna.Church.attendance.models.Attendance;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String eventName;
    private String eventType;
    private String description;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private String location;
    private String host;

    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "event")
    private List<Attendance> attendances;

}
