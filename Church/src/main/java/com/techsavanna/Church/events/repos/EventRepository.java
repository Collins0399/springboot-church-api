package com.techsavanna.Church.events.repos;

import com.techsavanna.Church.enums.EventStatus;
import com.techsavanna.Church.events.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStatus(EventStatus status);
}
