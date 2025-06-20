package com.techsavanna.Church.attendance.dtos;

import com.techsavanna.Church.enums.AttendanceStatus;
import lombok.Data;

@Data
public class AttendanceUpdateDto {
    private Long attendanceId;
    private Long memberId;
    private Long eventId;

    private AttendanceStatus status;
}
