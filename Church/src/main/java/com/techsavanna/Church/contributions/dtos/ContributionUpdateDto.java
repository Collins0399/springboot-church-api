package com.techsavanna.Church.contributions.dtos;

import com.techsavanna.Church.enums.ContributionType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ContributionUpdateDto {
    private ContributionType contributionType;
    private Double amount;
    private LocalDate dateGiven;
    private String paymentMethod;
    private Long memberId;
}
