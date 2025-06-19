package com.techsavanna.Church.departments.models;

import com.techsavanna.Church.enums.MeetingSchedule;
import com.techsavanna.Church.members.models.Member;
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
public class Department {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String name;
    private String description;
    private LocalDate createdDate;
    @Enumerated(EnumType.STRING)
    private MeetingSchedule meetingSchedule;

    @OneToMany (mappedBy = "departments", cascade = CascadeType.ALL)
    private List<Member> members;

}
