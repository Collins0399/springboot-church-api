package com.techsavanna.Church.attendance.controllers;

import com.techsavanna.Church.attendance.dtos.AttendanceDto;
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
    public ResponseEntity<AttendanceDto> createAttendance(@RequestBody AttendanceDto attendanceDto) {
        AttendanceDto created = attendanceService.createAttendance(attendanceDto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{attendanceId}")
    public ResponseEntity<AttendanceDto> updateAttendance(@PathVariable Long attendanceId, @RequestBody AttendanceDto attendanceDto) {
        AttendanceDto updated = attendanceService.updateAttendance(attendanceId, attendanceDto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{attendanceId}")
    public ResponseEntity<AttendanceDto> getAttendanceById(@PathVariable Long attendanceId) {
        AttendanceDto attendance = attendanceService.getAttendanceById(attendanceId);
        return ResponseEntity.ok(attendance);
    }

    @GetMapping
    public ResponseEntity<List<AttendanceDto>> getAllAttendance() {
        List<AttendanceDto> list = attendanceService.getAllAttendance();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{attendanceId}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long attendanceId) {
        attendanceService.deleteAttendance(attendanceId);
        return ResponseEntity.noContent().build();
    }


}
