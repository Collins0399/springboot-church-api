package com.techsavanna.Church.attendance.controllers;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceUpdateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceResponseDto;
import com.techsavanna.Church.attendance.services.AttendanceService;
import com.techsavanna.Church.enums.AttendanceStatus;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public ApiResponse<AttendanceResponseDto> createAttendance(@RequestBody AttendanceCreateDto dto) {
        return attendanceService.createAttendance(dto);
    }

    @PutMapping("/{id}")
    public ApiResponse<AttendanceResponseDto> updateAttendance(@PathVariable Long id, @RequestBody AttendanceUpdateDto dto) {
        return attendanceService.updateAttendance(id, dto);
    }

    @GetMapping("/{id}")
    public ApiResponse<AttendanceResponseDto> getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @GetMapping
    public ApiResponse<Page<AttendanceResponseDto>> getAllAttendances(Pageable pageable) {
        return attendanceService.getAllAttendances(pageable);
    }

    @GetMapping("/by-status")
    public ApiResponse<Page<AttendanceResponseDto>> getByStatus(@RequestParam AttendanceStatus status, Pageable pageable) {
        return attendanceService.getByStatus(status, pageable);
    }

    @GetMapping("/by-member")
    public ApiResponse<Page<AttendanceResponseDto>> getByMemberId(@RequestParam Long memberId, Pageable pageable) {
        return attendanceService.getByMemberId(memberId, pageable);
    }

    @GetMapping("/by-event")
    public ApiResponse<Page<AttendanceResponseDto>> getByEventId(@RequestParam Long eventId, Pageable pageable) {
        return attendanceService.getByEventId(eventId, pageable);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteAttendance(@PathVariable Long id) {
        return attendanceService.deleteAttendance(id);
    }
}
