package org.frz.hrbuddy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Department {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @Column(unique = true, length = 3)
    private String shortCode;

    private double budget;

    @OneToOne
            @JsonManagedReference
            @JoinColumn
    private Staff manager;

    @OneToMany
            @JsonBackReference
    @JoinColumn
    private List<Staff> members;

    @ManyToOne
    @JsonManagedReference
    private Location location;

    private boolean active;
}
