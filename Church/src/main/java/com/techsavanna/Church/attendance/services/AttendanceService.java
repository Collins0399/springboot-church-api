package com.techsavanna.Church.attendance.services;

import com.techsavanna.Church.attendance.dtos.AttendanceDto;

import java.util.List;

public interface AttendanceService {
    AttendanceDto createAttendance(AttendanceDto attendanceDto);
    AttendanceDto updateAttendance(Long attendanceId, AttendanceDto attendanceDto);
    void deleteAttendance(Long attendanceId);
    AttendanceDto getAttendanceById(Long attendanceId);
    List<AttendanceDto> getAllAttendance();
}
