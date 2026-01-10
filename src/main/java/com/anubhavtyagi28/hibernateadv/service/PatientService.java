package com.anubhavtyagi28.hibernateadv.service;


import com.anubhavtyagi28.hibernateadv.entity.Patient;
import com.anubhavtyagi28.hibernateadv.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction(){
        Patient p1 = patientRepository.findById(1L).orElseThrow();
        Patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 +" "+ p2);
        System.out.println(p1 == p2);

        p1.setName("Random");
    }
}
