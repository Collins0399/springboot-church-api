package com.techsavanna.Church.attendance.repos;

import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.enums.AttendanceStatus;
import com.techsavanna.Church.events.models.Event;
import com.techsavanna.Church.members.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStatus(AttendanceStatus status);
    List<Attendance> findByMember(Member member);
    List<Attendance> findByEvent(Event event);
}
