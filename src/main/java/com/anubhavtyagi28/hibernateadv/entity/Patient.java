package com.anubhavtyagi28.hibernateadv.entity;

import com.anubhavtyagi28.hibernateadv.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString(exclude = "insurance")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_insurance", unique = true)
    private Insurance insurance;    //owning side is parent


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)   //inverse side
    private Set<Appointment> appointments = new HashSet<>();
}
