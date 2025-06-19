package com.techsavanna.Church.families.repos;

import com.techsavanna.Church.families.models.Families;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Families, Long> {
}
