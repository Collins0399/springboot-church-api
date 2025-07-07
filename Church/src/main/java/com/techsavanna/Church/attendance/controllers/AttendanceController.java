package com.techsavanna.Church.attendance.controllers;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceUpdateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceResponseDto;
import com.techsavanna.Church.attendance.services.AttendanceService;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<ApiResponse<AttendanceResponseDto>> createAttendance(@RequestBody AttendanceCreateDto dto) {
        AttendanceResponseDto created = attendanceService.createAttendance(dto);
        ApiResponse<AttendanceResponseDto> response = new ApiResponse<>("success", "Attendance created successfully", created);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AttendanceResponseDto>> updateAttendance(@PathVariable Long id, @RequestBody AttendanceUpdateDto dto) {
        AttendanceResponseDto updated = attendanceService.updateAttendance(id, dto);
        ApiResponse<AttendanceResponseDto> response = new ApiResponse<>("success", "Attendance updated successfully", updated);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AttendanceResponseDto>> getAttendanceById(@PathVariable Long id) {
        AttendanceResponseDto attendance = attendanceService.getAttendanceById(id);
        ApiResponse<AttendanceResponseDto> response = new ApiResponse<>("success", "Attendance fetched successfully", attendance);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AttendanceResponseDto>>> getAllAttendances() {
        List<AttendanceResponseDto> all = attendanceService.getAllAttendances();
        ApiResponse<List<AttendanceResponseDto>> response = new ApiResponse<>("success", "All attendance records retrieved successfully", all);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        ApiResponse<String> response = new ApiResponse<>("success", "Attendance record deleted successfully", "Attendance record deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
