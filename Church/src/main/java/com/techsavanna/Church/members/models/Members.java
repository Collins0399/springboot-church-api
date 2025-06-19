package com.techsavanna.Church.members.models;

import com.techsavanna.Church.announcements.models.Announcements;
import com.techsavanna.Church.attendance.models.Attendance;
import com.techsavanna.Church.contributions.models.Contributions;
import com.techsavanna.Church.departments.models.Departments;
import com.techsavanna.Church.families.models.Families;
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
public class Members {
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

    private String membershipStatus;
    private LocalDate joinedDate;

    private String occupation;
    private String roleInChurch;
    private String profilePictureUrl;

    @ManyToOne
    @JoinColumn(name = "familyId")
    private Families family;

    @ManyToOne
    @JoinColumn (name = "departmentId")
    private Departments departments;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<Contributions> contributions;

    @OneToMany(mappedBy = "members")
    private List<Attendance> attendances;

    @ManyToMany
    @JoinTable(
            name = "member_announcements",
            joinColumns = @JoinColumn(name = "memberId"),
            inverseJoinColumns = @JoinColumn(name = "announcementId")
    )
    private  List<Announcements> announcements;

    @OneToMany(mappedBy = "preacher")
    private List<Sermon> sermons;

}
