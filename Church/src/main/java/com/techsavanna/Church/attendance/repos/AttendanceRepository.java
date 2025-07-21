package com.techsavanna.Church.attendance.repos;

import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.enums.AttendanceStatus;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.members.models.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Page<Attendance> findByStatus(AttendanceStatus status , Pageable pageable);
    Page<Attendance> findByMember(Member member , Pageable pageable);
    Page<Attendance> findByEvent(Event event , Pageable pageable);
}
