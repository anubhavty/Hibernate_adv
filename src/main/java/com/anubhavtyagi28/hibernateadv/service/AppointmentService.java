package com.anubhavtyagi28.hibernateadv.service;


import com.anubhavtyagi28.hibernateadv.entity.Appointment;
import com.anubhavtyagi28.hibernateadv.entity.Doctor;
import com.anubhavtyagi28.hibernateadv.entity.Patient;
import com.anubhavtyagi28.hibernateadv.repository.AppointmentRepository;
import com.anubhavtyagi28.hibernateadv.repository.DoctorRepository;
import com.anubhavtyagi28.hibernateadv.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId ) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointmentRepository.save(appointment);
        return appointment;
        //to make it bi-directional  -> optional
    }
    @Transactional
    public void deleteAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointmentRepository.delete(appointment);
    }
}
