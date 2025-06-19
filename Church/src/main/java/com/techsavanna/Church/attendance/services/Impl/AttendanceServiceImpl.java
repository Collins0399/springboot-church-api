package com.techsavanna.Church.attendance.services.Impl;

import com.techsavanna.Church.attendance.dtos.AttendanceDto;
import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.attendance.repos.AttendanceRepository;
import com.techsavanna.Church.attendance.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    //  Mapping methods to convert attendance Dto to attendance entity
    AttendanceDto mapToDto (Attendance attendance) {
        AttendanceDto dto = new AttendanceDto() ;
        dto.setAttendanceId(attendance.getAttendanceId());
        dto.setAttended(attendance.getAttended());
        dto.setTimestamp(attendance.getTimestamp());


        return dto;
    }

    // Mapping methods to convert attendance entity to attendance Dto
    Attendance mapToEntity (AttendanceDto attendanceDto){
        Attendance attendance = new Attendance();
        attendance.setAttendanceId(attendanceDto.getAttendanceId());
        attendance.setAttended(attendanceDto.getAttended());
        attendance.setTimestamp(LocalDateTime.now());

        return attendance;
    }

    @Override
    public AttendanceDto createAttendance(AttendanceDto attendanceDto) {
        Attendance attendance = mapToEntity(attendanceDto);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return mapToDto(savedAttendance);
    }

    @Override
    public AttendanceDto updateAttendance(Long attendanceId, AttendanceDto attendanceDto) {
        Attendance existingAttendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new RuntimeException("Attendance not found with ID: "));

        existingAttendance.setAttended(attendanceDto.getAttended());
        existingAttendance.setTimestamp(attendanceDto.getTimestamp() != null
                ? attendanceDto.getTimestamp()
                : LocalDateTime.now());

        Attendance updated = attendanceRepository.save(existingAttendance);
        return mapToDto(updated);
    }

    @Override
    public void deleteAttendance(Long attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public AttendanceDto getAttendanceById(Long attendanceId) {
        Optional<Attendance> attendance = attendanceRepository.findById(attendanceId);
        return attendance.map(this::mapToDto).orElse(null);
    }

    @Override
    public List<AttendanceDto> getAllAttendance() {
        return attendanceRepository.findAll()
                .stream()
                .map( this::mapToDto)
                .collect(Collectors.toList());
    }

}
