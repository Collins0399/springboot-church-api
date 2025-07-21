package com.techsavanna.Church.events.repos;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.models.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.status = :status")
    Page<Event> findByStatus(@Param("status") EventStatus status, Pageable pageable);


    @Modifying
    @Query("DELETE FROM Event e WHERE e.status = 'COMPLETED'")
    void deleteCompletedEvents();

}
