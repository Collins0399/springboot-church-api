package com.techsavanna.Church.departments.dtos;

import com.techsavanna.Church.enums.MeetingSchedule;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DepartmentDto {
    private Long departmentId;

    private String name;
    private String description;
    private LocalDate createdDate;
    private String leaderName;

    private MeetingSchedule meetingSchedule;

}
