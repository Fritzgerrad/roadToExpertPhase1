package org.frz.hrbuddy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JsonManagedReference
    private User user;

    private String name;
    private String position;
    private String phone;
    private String personalEmail;
    private String workEmail;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(unique = false)
    private Department department;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(unique = false)
    private Location location;

    private String jobTitle;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    @JsonManagedReference
    private Staff supervisor;

    @OneToMany(mappedBy = "supervisor")
    private List<Staff> directReports;

    private double currentSalary;
    private int jobLevel;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
}
