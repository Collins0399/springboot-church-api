package com.techsavanna.Church.families.models;

import com.techsavanna.Church.members.models.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "families")
public class Family {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long familyId;

    private String familyName;

    private String emergencyContactName;
    private String emergencyContactPhone;

    private String address;
    private String country;
    private String city;
    private String postalCode;


    @OneToMany (mappedBy = "family", cascade = CascadeType.ALL)
    private List<Member> members;

}
