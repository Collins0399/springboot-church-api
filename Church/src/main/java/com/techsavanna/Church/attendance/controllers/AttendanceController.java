package com.techsavanna.Church.attendance.controllers;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<AttendanceCreateDto> createAttendance(@RequestBody AttendanceCreateDto attendanceCreateDto) {
        AttendanceCreateDto created = attendanceService.createAttendance(attendanceCreateDto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{attendanceId}")
    public ResponseEntity<AttendanceCreateDto> updateAttendance(@PathVariable Long attendanceId, @RequestBody AttendanceCreateDto attendanceCreateDto) {
        AttendanceCreateDto updated = attendanceService.updateAttendance(attendanceId, attendanceCreateDto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{attendanceId}")
    public ResponseEntity<AttendanceCreateDto> getAttendanceById(@PathVariable Long attendanceId) {
        AttendanceCreateDto attendance = attendanceService.getAttendanceById(attendanceId);
        return ResponseEntity.ok(attendance);
    }

    @GetMapping
    public ResponseEntity<List<AttendanceCreateDto>> getAllAttendance() {
        List<AttendanceCreateDto> list = attendanceService.getAllAttendance();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{attendanceId}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long attendanceId) {
        attendanceService.deleteAttendance(attendanceId);
        return ResponseEntity.noContent().build();
    }


}
