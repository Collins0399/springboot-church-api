package com.techsavanna.Church.contributions.repos;

import com.techsavanna.Church.contributions.models.Contributions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<Contributions, Long> {
}
