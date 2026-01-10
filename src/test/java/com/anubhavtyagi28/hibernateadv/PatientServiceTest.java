package com.anubhavtyagi28.hibernateadv;


import com.anubhavtyagi28.hibernateadv.dto.BloodGroupStats;
import com.anubhavtyagi28.hibernateadv.dto.CPatientInfo;
import com.anubhavtyagi28.hibernateadv.dto.IPatientInfo;
import com.anubhavtyagi28.hibernateadv.entity.Patient;
import com.anubhavtyagi28.hibernateadv.repository.PatientRepository;
import com.anubhavtyagi28.hibernateadv.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;


    @Test
    public void testPatient() {
//        List<Patient> patientList = patientRepository.findAll();
//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();

//        for(IPatientInfo p : patientList) {
//            System.out.println(p.toStringValue());
//        }
//        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
//
//        for(var p : patientList) {
//            System.out.println(p);
//        }
//        int rowsAffected = patientRepository.updatePatientNameWithId("Anubhav Tyagi", 1L);
//        System.out.println(rowsAffected);
//
//        Patient patient = new Patient(); // here Patient entity is in transient state
//        patientRepository.save(patient); // this save() method will call the persist() method from entity manager

        patientService.testPatientTransaction();


    }
}
