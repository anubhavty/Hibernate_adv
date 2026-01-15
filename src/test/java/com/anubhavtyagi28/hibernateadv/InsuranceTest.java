package com.anubhavtyagi28.hibernateadv;


import com.anubhavtyagi28.hibernateadv.entity.Insurance;
import com.anubhavtyagi28.hibernateadv.service.InsuranceService;
import com.anubhavtyagi28.hibernateadv.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private PatientService patientService;
    @Test
    public void testAssignInsuranceToPatient() {

        Insurance insurance = Insurance.builder()
                .provider("HDFC")
                .policyNumber("HDFC_23G")
                .validUntil(LocalDate.of(2030, 1, 1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }
}

