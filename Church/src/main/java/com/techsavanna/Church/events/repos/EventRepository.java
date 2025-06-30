package com.techsavanna.Church.events.repos;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.startDateTime > CURRENT_TIMESTAMP")
    List<Event> findAllUpcomingEvents();

    @Query("SELECT e FROM Event e WHERE e.status = :status")
    List<Event> findByStatus(@Param("status") EventStatus status);

    @Query("SELECT e FROM Event e WHERE e.startDateTime BETWEEN :start AND :end")
    List<Event> findEventsWithin(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Modifying
    @Query("DELETE FROM Event e WHERE e.status = 'COMPLETED'")
    void deleteCompletedEvents();

}
