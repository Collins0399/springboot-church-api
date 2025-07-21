package com.techsavanna.Church.contributions.repos;

import com.techsavanna.Church.contributions.models.Contribution;
import com.techsavanna.Church.enums.PaymentMethod;
import com.techsavanna.Church.members.models.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, Long> {
    Page<Contribution> findByPaymentMethod(PaymentMethod paymentMethod , Pageable pageable);
    Page<Contribution> findByMemberAndPaymentMethod(Member member, PaymentMethod method , Pageable pageable);

}
