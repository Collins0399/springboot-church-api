package com.techsavanna.Church.announcements.repos;

import com.techsavanna.Church.announcements.models.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcements, Long> {
}
