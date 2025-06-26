package com.techsavanna.Church.departments.repos;

import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.members.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByName(String name);
}
