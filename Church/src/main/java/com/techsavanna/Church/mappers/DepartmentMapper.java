package com.techsavanna.Church.mappers;

import com.techsavanna.Church.departments.dtos.*;
import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.enums.MeetingSchedule;
import com.techsavanna.Church.members.models.Member;

public class DepartmentMapper {

    // Convert CreateDto to Entity
    public static Department toEntity(DepartmentCreateDto dto, Member leader) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setDescription(dto.getDescription());
        department.setLeader(leader);
        department.setMeetingSchedule(dto.getMeetingSchedule());

        if (dto.getCreatedDate() != null) {
            department.setCreatedDate(dto.getCreatedDate());
        } else {
            department.setCreatedDate(java.time.LocalDate.now());
        }

        return department;
    }

    // Update existing entity with UpdateDto
    public static void updateEntity(Department department, DepartmentUpdateDto dto, Member leader) {
        if (dto.getName() != null)
            department.setName(dto.getName());

        if (dto.getDescription() != null)
            department.setDescription(dto.getDescription());

        if (dto.getMeetingSchedule() != null)
            department.setMeetingSchedule(dto.getMeetingSchedule());

        if (dto.getCreatedDate() != null)
            department.setCreatedDate(dto.getCreatedDate());

        if (leader != null)
            department.setLeader(leader);
    }

    // Convert Entity to ResponseDto
    public static DepartmentResponseDto toResponseDto(Department department) {
        DepartmentResponseDto dto = new DepartmentResponseDto();
        dto.setDepartmentId(department.getDepartmentId());
        dto.setName(department.getName());
        dto.setDescription(department.getDescription());
        dto.setCreatedDate(department.getCreatedDate());
        dto.setMeetingSchedule(department.getMeetingSchedule());

        if (department.getLeader() != null) {
            dto.setLeaderId(department.getLeader().getMemberId());
            dto.setLeaderFullName(
                    department.getLeader().getFirstName() + " " + department.getLeader().getLastName()
            );
        } else {
            dto.setLeaderFullName("N/A");
        }

        return dto;
    }
}
