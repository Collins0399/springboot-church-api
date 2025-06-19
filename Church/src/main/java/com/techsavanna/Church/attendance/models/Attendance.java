package com.techsavanna.Church.attendance.models;

import com.techsavanna.Church.enums.AttendanceStatus;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.members.models.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Table (name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long attendanceId;

    @Setter @Getter
    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    @Setter @Getter
    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @Setter @Getter
    @ManyToOne
    @JoinColumn (name = "eventId")
    private Event event;
}
