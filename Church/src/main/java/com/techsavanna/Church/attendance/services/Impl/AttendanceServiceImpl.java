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
import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.members.repos.MemberRepository;

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
    public AttendanceResponseDto createAttendance(AttendanceCreateDto dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Attendance attendance = AttendanceMapper.toEntity(member, event, dto);
        Attendance saved = attendanceRepository.save(attendance);
        return AttendanceMapper.toResponseDto(saved);
    }

    @Override
    public AttendanceResponseDto updateAttendance(Long attendanceId, AttendanceUpdateDto dto) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        Attendance updated = AttendanceMapper.toUpdatedEntity(attendance, dto);
        return AttendanceMapper.toResponseDto(attendanceRepository.save(updated));
    }

    @Override
    public void deleteAttendance(Long attendanceId) {
        if (!attendanceRepository.existsById(attendanceId)) {
            throw new RuntimeException("Attendance not found");
        }
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public AttendanceResponseDto getAttendanceById(Long attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));
        return AttendanceMapper.toResponseDto(attendance);
    }

    @Override
    public List<AttendanceResponseDto> getAllAttendances() {
        return attendanceRepository.findAll()
                .stream()
                .map(AttendanceMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
