package com.techsavanna.Church.members.repos;

import com.techsavanna.Church.members.models.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Members, Long> {

}
