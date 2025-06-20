package com.techsavanna.Church.families.dtos;

import lombok.Data;

@Data
public class FamilyResponseDto {
    private Long familyId;

    private String familyName;

    private String emergencyContactName;
    private String emergencyContactPhone;

    private String address;
    private String country;
    private String city;
    private String postalCode;
}
