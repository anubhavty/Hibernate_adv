package com.anubhavtyagi28.hibernateadv.service;


import com.anubhavtyagi28.hibernateadv.entity.Doctor;
import com.anubhavtyagi28.hibernateadv.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    @Transactional
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    @Transactional
    public void deleteDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        if(!doctor.getAppointments().isEmpty()) {
            throw new IllegalStateException("Cannot delete doctor with appointments");
        }
        doctorRepository.delete(doctor);
    }
}
