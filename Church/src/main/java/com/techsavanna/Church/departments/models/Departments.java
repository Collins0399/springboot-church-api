package com.techsavanna.Church.departments.models;

import com.techsavanna.Church.members.models.Members;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "departments")
public class Departments {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String name;
    private String description;
    private LocalDate createdDate;

    private String leaderName;
    private String leaderPhone;
    private String leaderEmail;

    private Integer numberOfMembers;

    private String meetingSchedule;
    private String location;
    private Boolean isActive;

    private String notes;

    @OneToMany (mappedBy = "departments", cascade = CascadeType.ALL)
    private List<Members> members;

}
