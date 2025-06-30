package com.techsavanna.Church.announcements.repos;

import com.techsavanna.Church.announcements.models.Announcement;
import com.techsavanna.Church.enums.AnnouncementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    @Query("SELECT a FROM Announcement a WHERE LOWER(a.status) = LOWER(:status)")
    List<Announcement> findByStatusIgnoreCase(@Param("status") String status);
@Query("SELECT a FROM Announcement a WHERE a.announcementId = :announcementId")
    Announcement findByAnnouncementId (Long announcementId);

}
