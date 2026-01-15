package com.anubhavtyagi28.hibernateadv.repository;

import com.anubhavtyagi28.hibernateadv.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}