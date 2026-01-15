package com.anubhavtyagi28.hibernateadv.repository;

import com.anubhavtyagi28.hibernateadv.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}