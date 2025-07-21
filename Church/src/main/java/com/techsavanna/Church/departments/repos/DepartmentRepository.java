package com.techsavanna.Church.departments.repos;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.members.models.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Page<Department> findByName(String name , Pageable pageable);
}
