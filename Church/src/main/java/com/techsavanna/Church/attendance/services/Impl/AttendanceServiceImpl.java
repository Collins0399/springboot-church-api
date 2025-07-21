package com.techsavanna.Church.attendance.services.Impl;

import com.techsavanna.Church.attendance.dtos.AttendanceCreateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceUpdateDto;
import com.techsavanna.Church.attendance.dtos.AttendanceResponseDto;
import com.techsavanna.Church.attendance.mappers.AttendanceMapper;
import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.attendance.repos.AttendanceRepository;
import com.techsavanna.Church.attendance.services.AttendanceService;
import com.techsavanna.Church.enums.AttendanceStatus;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.events.repos.EventRepository;
import com.techsavanna.Church.handler.ResourceNotFoundException;
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;
import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        Attendance saved = attendanceRepository.save(updated);

        return new ApiResponse<>("success", "Attendance updated successfully", AttendanceMapper.toResponseDto(saved));
    }

    @Override
    public ApiResponse<AttendanceResponseDto> getAttendanceById(Long attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with ID: " + attendanceId));

        return new ApiResponse<>("success", "Attendance fetched successfully", AttendanceMapper.toResponseDto(attendance));
    }

    @Override
    public ApiResponse<Page<AttendanceResponseDto>> getAllAttendances(Pageable pageable) {
        Page<Attendance> page = attendanceRepository.findAll(pageable);
        Page<AttendanceResponseDto> dtoPage = page.map(AttendanceMapper::toResponseDto);

        return new ApiResponse<>("success", "All attendance records retrieved successfully", dtoPage);
    }

    @Override
    public ApiResponse<Page<AttendanceResponseDto>> getByStatus(AttendanceStatus status, Pageable pageable) {
        Page<Attendance> page = attendanceRepository.findByStatus(status, pageable);
        Page<AttendanceResponseDto> dtoPage = page.map(AttendanceMapper::toResponseDto);

        return new ApiResponse<>("success", "Attendance records filtered by status", dtoPage);
    }

    @Override
    public ApiResponse<Page<AttendanceResponseDto>> getByMemberId(Long memberId, Pageable pageable) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + memberId));

        Page<Attendance> page = attendanceRepository.findByMember(member, pageable);
        Page<AttendanceResponseDto> dtoPage = page.map(AttendanceMapper::toResponseDto);

        return new ApiResponse<>("success", "Attendance records for member retrieved", dtoPage);
    }

    @Override
    public ApiResponse<Page<AttendanceResponseDto>> getByEventId(Long eventId, Pageable pageable) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));

        Page<Attendance> page = attendanceRepository.findByEvent(event, pageable);
        Page<AttendanceResponseDto> dtoPage = page.map(AttendanceMapper::toResponseDto);

        return new ApiResponse<>("success", "Attendance records for event retrieved", dtoPage);
    }

    @Override
    public ApiResponse<Void> deleteAttendance(Long attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with ID: " + attendanceId));

        attendanceRepository.delete(attendance);
        return new ApiResponse<>("success", "Attendance record deleted successfully", null);
    }
}
