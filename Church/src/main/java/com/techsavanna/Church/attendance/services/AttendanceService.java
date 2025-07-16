package com.techsavanna.Church.attendance.services;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceUpdateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceResponseDto;
import com.techsavanna.Church.responses.ApiResponse;

import java.util.List;

public interface AttendanceService {
    ApiResponse<AttendanceResponseDto> createAttendance(AttendanceCreateDto dto);
    ApiResponse<AttendanceResponseDto> updateAttendance(Long attendanceId, AttendanceUpdateDto dto);
    ApiResponse<AttendanceResponseDto> getAttendanceById(Long attendanceId);
    ApiResponse<List<AttendanceResponseDto>> getAllAttendances();
    ApiResponse<Void> deleteAttendance(Long attendanceId);
}
