package com.techsavanna.Church.members.repos;

import com.techsavanna.Church.members.dtos.MemberResponseDto;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.members.models.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

        @Query("SELECT m FROM Member m WHERE m.email = :email")
        Optional<Member> findByEmail(@Param("email") String email);

        @Query("SELECT m FROM Member m WHERE LOWER(m.firstName) LIKE LOWER(CONCAT('%', :namePart, '%'))")
        Page<Member> findByFirstNameContainingIgnoreCase(@Param("namePart") String namePart, Pageable pageable);

        @Query("SELECT m FROM Member m WHERE m.maritalStatus = :maritalStatus")
        Page<Member> findByMaritalStatus(@Param("maritalStatus") String maritalStatus, Pageable pageable);

        @Query("SELECT m FROM Member m WHERE LOWER(m.department.name) = LOWER(:departmentName)")
        Page<Member> findByDepartmentIgnoreCase(@Param("departmentName") String departmentName, Pageable pageable);

        @Query("SELECT m FROM Member m WHERE LOWER(m.family.familyName) = LOWER(:familyName)")
        Page<Member> findByFamily_FamilyNameIgnoreCase(@Param("familyName") String familyName, Pageable pageable);

        @Query("SELECT m FROM Member m WHERE m.baptismStatus = :status")
        Page<Member> findByBaptismStatus(@Param("status") BaptismStatus status, Pageable pageable);
}
