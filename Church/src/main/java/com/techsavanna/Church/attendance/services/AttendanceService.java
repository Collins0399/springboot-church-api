package com.techsavanna.Church.attendance.services;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceUpdateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceResponseDto;
import com.techsavanna.Church.enums.AttendanceStatus;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AttendanceService {
    ApiResponse<AttendanceResponseDto> createAttendance(AttendanceCreateDto dto);
    ApiResponse<AttendanceResponseDto> updateAttendance(Long attendanceId, AttendanceUpdateDto dto);
    ApiResponse<AttendanceResponseDto> getAttendanceById(Long attendanceId);
    ApiResponse<Page<AttendanceResponseDto>> getAllAttendances(Pageable pageable);
    ApiResponse<Void> deleteAttendance(Long attendanceId);
    ApiResponse<Page<AttendanceResponseDto>> getByStatus(AttendanceStatus status, Pageable pageable);
    ApiResponse<Page<AttendanceResponseDto>> getByMemberId(Long memberId, Pageable pageable);
    ApiResponse<Page<AttendanceResponseDto>> getByEventId(Long eventId, Pageable pageable);

}
