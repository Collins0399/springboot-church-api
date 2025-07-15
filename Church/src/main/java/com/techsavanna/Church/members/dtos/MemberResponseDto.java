package com.techsavanna.Church.members.dtos;

import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.members.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberResponseDto {
    private Long memberId;
    private Long familyId;
    private Long departmentId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String maritalStatus;

    private String email;
    private String phoneNumber;
    private String address;
    private String country;
    private String city;
    private String postalCode;

    private BaptismStatus baptismStatus;
    private LocalDate baptismDate;

    private LocalDate joinedDate;

    private String occupation;
    private String roleInChurch;
    private String profilePicturePath;
}
