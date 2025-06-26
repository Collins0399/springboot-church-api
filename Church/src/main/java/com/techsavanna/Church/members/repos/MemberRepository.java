package com.techsavanna.Church.members.repos;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.members.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
        Optional<Member> findByEmail(String email);

        List<Member> findByFirstNameContainingIgnoreCase(String namePart);

        List<Member> findByMaritalStatus(String maritalStatus);

        List<Member> findByDepartment(Department department);

        List<Member> findByFamily_FamilyName(String familyName);

        List<Member> findByBaptismStatusTrue();
        List<Member> findByBaptismStatusFalse();

    }

