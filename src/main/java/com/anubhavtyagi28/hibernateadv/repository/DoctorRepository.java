package com.anubhavtyagi28.hibernateadv.repository;

import com.anubhavtyagi28.hibernateadv.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}