package com.techsavanna.Church.mappers;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceUpdateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceResponseDto;
import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.members.models.Member;

public class AttendanceMapper {

    public static Attendance toEntity(Member member, Event event, AttendanceCreateDto dto) {
        Attendance attendance = new Attendance();
        attendance.setMember(member); // member fetched from DB
        attendance.setEvent(event);   // event fetched from DB
        attendance.setStatus(dto.getStatus());
        return attendance;
    }

    public static Attendance toUpdatedEntity(Attendance attendance, AttendanceUpdateDto dto) {
        attendance.setStatus(dto.getStatus());
        return attendance;
    }

    public static AttendanceResponseDto toResponseDto(Attendance attendance) {
        AttendanceResponseDto dto = new AttendanceResponseDto();
        dto.setAttendanceId(attendance.getAttendanceId());
        dto.setMemberId(attendance.getMember().getMemberId());
        dto.setEventId(attendance.getEvent().getEventId());
        dto.setStatus(attendance.getStatus());
        return dto;
    }
}
