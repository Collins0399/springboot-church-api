package com.techsavanna.Church.contributions.repos;

import com.techsavanna.Church.contributions.models.Contribution;
import com.techsavanna.Church.enums.PaymentMethod;
import com.techsavanna.Church.members.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, Long> {
    List<Contribution> findByPaymentMethod(PaymentMethod paymentMethod);
    List<Contribution> findByMemberAndPaymentMethod(Member member, PaymentMethod method);

}
