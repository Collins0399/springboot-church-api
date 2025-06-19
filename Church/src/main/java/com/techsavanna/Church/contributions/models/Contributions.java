package com.techsavanna.Church.contributions.models;

import com.techsavanna.Church.members.models.Members;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "contributions")
public class Contributions {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long contributionId;

    private String contributionType;
    private Double amount;
    private LocalDate dateGiven;
    private String paymentMethod;
    private String referenceNote;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn (name = "memberId", nullable = false)
    private Members members;

}
