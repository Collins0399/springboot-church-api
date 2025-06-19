package com.techsavanna.Church.departments.models;

import com.techsavanna.Church.enums.MeetingSchedule;
import com.techsavanna.Church.members.models.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Table (name = "departments")
public class Department {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    private Long departmentId;

    @Setter @Getter
    private String name;
    @Setter @Getter
    private String description;
    @Setter @Getter
    private LocalDate createdDate;
    @Setter @Getter
    private String leaderName;
    @Setter @Getter
    @Enumerated(EnumType.STRING)
    private MeetingSchedule meetingSchedule;

    @Setter @Getter
    @OneToMany (mappedBy = "departments", cascade = CascadeType.ALL)
    private List<Member> member;

}
