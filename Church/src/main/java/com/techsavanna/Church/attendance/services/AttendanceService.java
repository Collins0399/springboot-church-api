package com.techsavanna.Church.attendance.services;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceUpdateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceResponseDto;

import java.util.List;

public interface AttendanceService {
    AttendanceResponseDto createAttendance(AttendanceCreateDto dto);
    AttendanceResponseDto updateAttendance(Long attendanceId, AttendanceUpdateDto dto);
    AttendanceResponseDto getAttendanceById(Long attendanceId);
    List<AttendanceResponseDto> getAllAttendances();
    void deleteAttendance(Long attendanceId);
}
