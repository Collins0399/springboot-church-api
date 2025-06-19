package com.techsavanna.Church.contributions.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ContributionDto {
    private Long contributionId;

    private String contributionType;
    private Double amount;
    private LocalDate dateGiven;
    private String paymentMethod;
    private String referenceNote;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
