package com.anubhavtyagi28.hibernateadv.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;


    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Doctor headDoctor;  //owning side

    @ManyToMany
    @Builder.Default
    private Set<Doctor> doctors = new HashSet<>(); //this will create join table by default
}
