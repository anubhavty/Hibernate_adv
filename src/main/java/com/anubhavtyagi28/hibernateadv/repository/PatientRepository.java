package com.anubhavtyagi28.hibernateadv.repository;

import com.anubhavtyagi28.hibernateadv.dto.BloodGroupStats;
import com.anubhavtyagi28.hibernateadv.dto.CPatientInfo;
import com.anubhavtyagi28.hibernateadv.dto.IPatientInfo;
import com.anubhavtyagi28.hibernateadv.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByEmailContaining(String d);

    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("select new com.anubhavtyagi28.hibernateadv.dto.CPatientInfo (p.id, p.name) " + " from Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("select new com.anubhavtyagi28.hibernateadv.dto.BloodGroupStats (p.bloodGroup, " + "COUNT(p)) from Patient p group by p.bloodGroup order by COUNT(p) DESC")
    List<BloodGroupStats> getBloodGroupStats();


    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name = :name where p.id = :id ")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);
}
