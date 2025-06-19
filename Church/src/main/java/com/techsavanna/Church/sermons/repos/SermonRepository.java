package com.techsavanna.Church.sermons.repos;

import com.techsavanna.Church.sermons.models.Sermon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SermonRepository extends JpaRepository<Sermon, Long> {
}
