package com.techsavanna.Church.contributions.models;

import com.techsavanna.Church.enums.ContributionType;
import com.techsavanna.Church.members.models.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table (name = "contributions")
public class Contribution {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    private Long contributionId;

    @Setter @Getter
    @Enumerated(EnumType.STRING)
    private ContributionType contributionType;
    @Setter @Getter
    private Double amount;
    @Setter @Getter
    private LocalDate dateGiven;
    @Setter @Getter
    private String paymentMethod;

    @Setter @Getter
    private LocalDateTime createdAt;
    @Setter @Getter
    private LocalDateTime updatedAt;

    @Setter @Getter
    @ManyToOne
    @JoinColumn (name = "memberId", nullable = false)
    private Member member;

}
