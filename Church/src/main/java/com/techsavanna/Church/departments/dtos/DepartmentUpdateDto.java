package com.techsavanna.Church.departments.dtos;

import com.techsavanna.Church.enums.MeetingSchedule;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DepartmentUpdateDto {
    private String name;
    private String description;
    private Long leaderId;
    private MeetingSchedule meetingSchedule;
    private LocalDate createdDate;
}
