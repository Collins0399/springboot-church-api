package com.techsavanna.Church.members.models;

import com.techsavanna.Church.announcements.models.Announcement;
import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.contributions.models.Contribution;
import com.techsavanna.Church.departments.models.Department;
import com.techsavanna.Church.families.models.Family;
import com.techsavanna.Church.sermons.models.Sermon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "members")
public class Member {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long memberId;

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

    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family family;

    @ManyToOne
    @JoinColumn (name = "departmentId")
    private Department departments;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<Contribution> contributions;

    @OneToMany(mappedBy = "members")
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "member")
    private List<Sermon> sermons;
}
