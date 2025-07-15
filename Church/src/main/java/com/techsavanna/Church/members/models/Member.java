package com.techsavanna.Church.members.models;

import com.techsavanna.Church.announcements.models.Announcement;
import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.contributions.models.Contribution;
import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.families.models.Family;
import com.techsavanna.Church.members.enums.BaptismStatus;
import com.techsavanna.Church.members.enums.Gender;
import com.techsavanna.Church.sermons.models.Sermon;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name= "members")
public class Member {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    private Long memberId;

    @Setter @Getter
    private String firstName;
    @Setter @Getter
    private String lastName;
    @Setter @Getter
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Setter @Getter
    private LocalDate dateOfBirth;
    @Setter @Getter
    private String maritalStatus;

    @Setter @Getter
    @Column(name = "email" , unique = true , nullable = false)
    private String email;
    @Setter @Getter
    private String phoneNumber;
    @Setter @Getter
    private String address;
    @Setter @Getter
    private String country;
    @Setter @Getter
    private String city;
    @Setter @Getter
    private String postalCode;

    @Setter @Getter
    @Enumerated(EnumType.STRING)
    private BaptismStatus baptismStatus;
    @Setter @Getter
    private LocalDate baptismDate;

    @Setter @Getter
    private LocalDate joinedDate;

    @Setter @Getter
    private String occupation;
    @Setter @Getter
    private String roleInChurch;

    @Setter @Getter
    @Column(name = "profile_picture_path")
    private String profilePicturePath;


    @Setter @Getter
    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family family;

    @Setter @Getter
    @ManyToOne
    @JoinColumn (name = "departmentId")
    private Department department;

    @Setter @Getter
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Contribution> contribution;

    @Setter @Getter
    @OneToMany(mappedBy = "member")
    private List<Attendance> attendance;

    @Setter @Getter
    @OneToMany(mappedBy = "preacher")
    private List<Sermon> sermon;
}
