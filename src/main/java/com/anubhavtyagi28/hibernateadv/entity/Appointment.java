package com.anubhavtyagi28.hibernateadv.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Patient patient;  //owning side


    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Doctor doctor;   //owning side
}
