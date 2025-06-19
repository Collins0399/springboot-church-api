package com.techsavanna.Church.attendance.dtos;

import com.techsavanna.Church.enums.AttendanceStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttendanceDto {
    private Long attendanceId;
    private Long memberId;
    private Long eventId;

    private AttendanceStatus status;

}
