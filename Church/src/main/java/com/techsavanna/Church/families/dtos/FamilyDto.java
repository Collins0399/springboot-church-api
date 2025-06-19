package com.techsavanna.Church.families.dtos;

import lombok.Data;

@Data
public class FamilyDto {
    private Long familyId;

    private String familyName;
    private Integer numberOfChildren;

    private String emergencyContactName;
    private String emergencyContactPhone;

    private String address;
    private String country;
    private String city;
    private String postalCode;

    private String notes;
}
