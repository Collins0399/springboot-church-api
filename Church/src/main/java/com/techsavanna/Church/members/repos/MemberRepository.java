package com.techsavanna.Church.members.repos;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.members.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
        @Query("SELECT m FROM Member m WHERE m.email = :email")
        Optional<Member> findByEmail(@Param("email") String email);

        @Query("SELECT m FROM Member m WHERE LOWER(m.firstName) LIKE LOWER(CONCAT('%', :namePart, '%'))")
        List<Member> findByFirstNameContainingIgnoreCase(@Param("namePart") String namePart);

        @Query("SELECT m FROM Member m WHERE m.maritalStatus = :maritalStatus")
        List<Member> findByMaritalStatus(@Param("maritalStatus") String maritalStatus);

        @Query("SELECT m FROM Member m WHERE LOWER(m.department.name) = LOWER(:departmentName)")
        List<Member> findByDepartmentIgnoreCase(@Param("departmentName") String departmentName);

        @Query("SELECT m FROM Member m WHERE LOWER(m.family.familyName) = LOWER(:familyName)")
        List<Member> findByFamily_FamilyNameIgnoreCase(@Param("familyName") String familyName);

        @Query("SELECT m FROM Member m WHERE m.baptismStatus = :status")
        List<Member> findByBaptismStatus(@Param("status") BaptismStatus status);
}

