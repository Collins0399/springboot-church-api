package com.techsavanna.Church.attendance.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttendanceDto {
    private Long attendanceId;


    private Boolean attended;
    private LocalDateTime timestamp;

}
