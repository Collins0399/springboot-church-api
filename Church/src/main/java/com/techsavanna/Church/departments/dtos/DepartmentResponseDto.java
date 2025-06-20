package com.techsavanna.Church.departments.dtos;

import com.techsavanna.Church.enums.MeetingSchedule;
import lombok.Data;

import java.time.LocalDate;
@Data
public class DepartmentResponseDto {
    private Long departmentId;
    private String name;
    private String description;
    private LocalDate createdDate;
    private Long leaderId;
    private String leaderFullName;
    private MeetingSchedule meetingSchedule;
}
