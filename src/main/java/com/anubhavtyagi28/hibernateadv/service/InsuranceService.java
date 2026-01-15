package com.anubhavtyagi28.hibernateadv.service;


import com.anubhavtyagi28.hibernateadv.entity.Insurance;
import com.anubhavtyagi28.hibernateadv.entity.Patient;
import com.anubhavtyagi28.hibernateadv.repository.InsuranceRepository;
import com.anubhavtyagi28.hibernateadv.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return insurance;

    }
}
