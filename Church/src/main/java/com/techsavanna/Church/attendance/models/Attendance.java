package com.techsavanna.Church.attendance.models;

import com.techsavanna.Church.enums.AttendanceStatus;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.members.models.Member;
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

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member members;

    @ManyToOne
    @JoinColumn (name = "eventId")
    private Event event;
}
