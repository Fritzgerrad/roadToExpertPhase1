package org.frz.hrbuddy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(unique = true, length = 2)
    private String shortCode;

    @OneToOne
            @JoinColumn
            @JsonManagedReference
    private Staff president;

    @OneToMany
    @JoinColumn()
    @JsonBackReference
    private List<Department> departments;

    private String country;

    private boolean functional;
}
