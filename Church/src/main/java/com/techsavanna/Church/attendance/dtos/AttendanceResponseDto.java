package com.techsavanna.Church.attendance.dtos;

import com.techsavanna.Church.enums.AttendanceStatus;
import lombok.Data;

@Data
public class AttendanceResponseDto {
    private Long attendanceId;
    private Long memberId;
    private Long eventId;
    private AttendanceStatus status;
}
