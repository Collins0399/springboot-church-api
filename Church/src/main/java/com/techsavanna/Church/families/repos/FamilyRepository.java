package com.techsavanna.Church.families.repos;

import com.techsavanna.Church.families.models.Family;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
    Page<Family> findByFamilyNameIgnoreCase(String familyName , Pageable pageable);
}
