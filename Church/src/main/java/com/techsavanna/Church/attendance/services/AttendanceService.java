package com.techsavanna.Church.attendance.services;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;

import java.util.List;

public interface AttendanceService {
    AttendanceCreateDto createAttendance(AttendanceCreateDto attendanceCreateDto);
    AttendanceCreateDto updateAttendance(Long attendanceId, AttendanceCreateDto attendanceCreateDto);
    void deleteAttendance(Long attendanceId);
    AttendanceCreateDto getAttendanceById(Long attendanceId);
    List<AttendanceCreateDto> getAllAttendance();
}
