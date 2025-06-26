package com.techsavanna.Church.announcements.repos;

import com.techsavanna.Church.announcements.models.Announcement;
import com.techsavanna.Church.enums.AnnouncementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findByStatus(AnnouncementStatus status);
}
