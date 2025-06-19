package com.techsavanna.Church.families.models;

import com.techsavanna.Church.members.models.Members;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "families")
public class Families {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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

    @OneToMany (mappedBy = "family", cascade = CascadeType.ALL)
    private List<Members> members;

}
