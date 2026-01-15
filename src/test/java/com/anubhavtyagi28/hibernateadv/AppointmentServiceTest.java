package com.anubhavtyagi28.hibernateadv;


import com.anubhavtyagi28.hibernateadv.entity.Appointment;
import com.anubhavtyagi28.hibernateadv.service.AppointmentService;
import com.anubhavtyagi28.hibernateadv.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();
        var updatedAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
        System.out.println(updatedAppointment);
        patientService.deletePatient(1L);


    }
}
