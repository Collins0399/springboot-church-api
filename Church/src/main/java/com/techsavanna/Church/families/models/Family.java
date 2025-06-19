package com.techsavanna.Church.families.models;

import com.techsavanna.Church.members.models.Member;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@NoArgsConstructor
@Table (name = "families")
public class Family {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    private Long familyId;

    @Setter @Getter
    private String familyName;

    @Setter @Getter
    private String emergencyContactName;
    @Setter @Getter
    private String emergencyContactPhone;

    @Setter @Getter
    private String address;
    @Setter @Getter
    private String country;
    @Setter @Getter
    private String city;
    @Setter @Getter
    private String postalCode;

    @Setter @Getter
    @OneToMany (mappedBy = "family", cascade = CascadeType.ALL)
    private List<Member> member;

}
