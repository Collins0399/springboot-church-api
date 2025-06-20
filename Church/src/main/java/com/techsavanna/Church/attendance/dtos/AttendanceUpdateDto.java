package com.techsavanna.Church.attendance.dtos;

import com.techsavanna.Church.enums.AttendanceStatus;
import lombok.Data;

@Data
public class AttendanceUpdateDto {
    private AttendanceStatus status;
}
