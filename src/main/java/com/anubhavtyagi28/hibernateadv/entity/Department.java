package com.anubhavtyagi28.hibernateadv.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;


    @OneToOne
    @JoinColumn(nullable = false)
    private Doctor headDoctor;  //owning side

    @ManyToMany
    private Set<Doctor> doctors = new HashSet<>();
}
