package com.techsavanna.Church.contributions.repos;

import com.techsavanna.Church.contributions.models.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, Long> {
}
