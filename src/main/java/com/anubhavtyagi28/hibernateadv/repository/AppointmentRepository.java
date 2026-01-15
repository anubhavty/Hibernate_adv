package com.anubhavtyagi28.hibernateadv.repository;

import com.anubhavtyagi28.hibernateadv.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}