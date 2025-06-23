package com.techsavanna.Church.members.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberUpdateDto {
    private Long departmentId;
    private Long familyId;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String maritalStatus;

    private String email;
    private String phoneNumber;
    private String address;
    private String country;
    private String city;
    private String postalCode;

    private Boolean baptismStatus;
    private LocalDate baptismDate;

    private LocalDate joinedDate;

    private String occupation;
    private String roleInChurch;
    private String profilePictureUrl;
}
