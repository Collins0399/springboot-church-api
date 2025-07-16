package com.techsavanna.Church.attendance.services.Impl;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceUpdateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceResponseDto;
import com.techsavanna.Church.attendance.mappers.AttendanceMapper;
import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.attendance.repos.AttendanceRepository;
import com.techsavanna.Church.attendance.services.AttendanceService;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.events.repos.EventRepository;
import com.techsavanna.Church.handler.ResourceNotFoundException;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public ApiResponse<AttendanceResponseDto> createAttendance(AttendanceCreateDto dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + dto.getMemberId()));

        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + dto.getEventId()));

        Attendance attendance = AttendanceMapper.toEntity(member, event, dto);
        Attendance saved = attendanceRepository.save(attendance);

        return new ApiResponse<>("success", "Attendance created successfully", AttendanceMapper.toResponseDto(saved));
    }

    @Override
    public ApiResponse<AttendanceResponseDto> updateAttendance(Long attendanceId, AttendanceUpdateDto dto) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with ID: " + attendanceId));

        Attendance updated = AttendanceMapper.toUpdatedEntity(attendance, dto);
        return new ApiResponse<>("success", "Attendance updated successfully", AttendanceMapper.toResponseDto(attendanceRepository.save(updated)));
    }

    @Override
    public ApiResponse<AttendanceResponseDto> getAttendanceById(Long attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with ID: " + attendanceId));
        return new ApiResponse<>("success", "Attendance fetched successfully", AttendanceMapper.toResponseDto(attendance));
    }

    @Override
    public ApiResponse<List<AttendanceResponseDto>> getAllAttendances() {
        List<AttendanceResponseDto> list = attendanceRepository.findAll()
                .stream()
                .map(AttendanceMapper::toResponseDto)
                .collect(Collectors.toList());
        return new ApiResponse<>("success", "All attendance records retrieved successfully", list);
    }

    @Override
    public ApiResponse<Void> deleteAttendance(Long attendanceId) {
        if (!attendanceRepository.existsById(attendanceId)) {
            throw new ResourceNotFoundException("Attendance not found with ID: " + attendanceId);
        }
        attendanceRepository.deleteById(attendanceId);
        return new ApiResponse<>("success", "Attendance deleted successfully", null);
    }
}
