package org.frz.hrbuddy.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
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
    private Long id;

    @OneToOne
    @JsonManagedReference
    private User user;

    private String name;
    private String position;
    private String phone;
    private String personalEmail;
    private String workEmail;
    private String department;
    private String location;
    private String jobTitle;
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    @JsonManagedReference
    private Staff supervisor;

    @OneToMany(mappedBy = "supervisor")
    private Set<Staff> directReports;

    private double currentSalary;
    private int jobLevel;
    private Date createdDate;
}
