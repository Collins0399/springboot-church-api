package com.techsavanna.Church.departments.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DepartmentDto {
    private Long departmentId;

    private String name;
    private String description;
    private LocalDate createdDate;

    private String leaderName;
    private String leaderPhone;
    private String leaderEmail;

    private Integer numberOfMembers;

    private String meetingSchedule;
    private String location;
    private Boolean isActive;

    private String notes;

}
