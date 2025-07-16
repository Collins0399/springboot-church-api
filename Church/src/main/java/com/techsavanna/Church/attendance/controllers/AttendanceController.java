package com.techsavanna.Church.attendance.controllers;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceUpdateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceResponseDto;
import com.techsavanna.Church.attendance.services.AttendanceService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ApiResponse<List<AttendanceResponseDto>> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteAttendance(@PathVariable Long id) {
        return attendanceService.deleteAttendance(id);
    }
}
