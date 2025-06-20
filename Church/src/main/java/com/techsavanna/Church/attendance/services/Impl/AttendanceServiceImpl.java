package com.techsavanna.Church.attendance.services.Impl;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.attendance.repos.AttendanceRepository;
import com.techsavanna.Church.attendance.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    //  Mapping methods to convert attendance Dto to attendance entity
    AttendanceCreateDto mapToDto (Attendance attendance) {
        AttendanceCreateDto dto = new AttendanceCreateDto() ;
        dto.setStatus(attendance.getStatus());


        return dto;
    }

    // Mapping methods to convert attendance entity to attendance Dto
    Attendance mapToEntity (AttendanceCreateDto attendanceCreateDto){
        Attendance attendance = new Attendance();
        attendance.setStatus(attendanceCreateDto.getStatus());

        return attendance;
    }

    @Override
    public AttendanceCreateDto createAttendance(AttendanceCreateDto attendanceCreateDto) {
        Attendance attendance = mapToEntity(attendanceCreateDto);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return mapToDto(savedAttendance);
    }

    @Override
    public AttendanceCreateDto updateAttendance(Long attendanceId, AttendanceCreateDto attendanceCreateDto) {
        Attendance existingAttendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new RuntimeException("Attendance not found with ID: "));

        existingAttendance.setStatus(attendanceCreateDto.getStatus());

        Attendance updated = attendanceRepository.save(existingAttendance);
        return mapToDto(updated);
    }

    @Override
    public void deleteAttendance(Long attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public AttendanceCreateDto getAttendanceById(Long attendanceId) {
        Optional<Attendance> attendance = attendanceRepository.findById(attendanceId);
        return attendance.map(this::mapToDto).orElse(null);
    }

    @Override
    public List<AttendanceCreateDto> getAllAttendance() {
        return attendanceRepository.findAll()
                .stream()
                .map( this::mapToDto)
                .collect(Collectors.toList());
    }

}
