package com.techsavanna.Church.attendance.models;

import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.members.models.Members;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;


    private Boolean attended;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Members members;

    @ManyToOne
    @JoinColumn (name = "eventId")
    private Event event;
}
