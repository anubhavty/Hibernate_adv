package com.anubhavtyagi28.hibernateadv;

import com.anubhavtyagi28.hibernateadv.entity.Department;
import com.anubhavtyagi28.hibernateadv.entity.Doctor;
import com.anubhavtyagi28.hibernateadv.repository.DepartmentRepository;
import com.anubhavtyagi28.hibernateadv.repository.DoctorRepository;
import com.anubhavtyagi28.hibernateadv.service.DepartmentService;
import com.anubhavtyagi28.hibernateadv.service.DoctorService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
public class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Test
    public void assignDoctorsToDepartment() {
        Doctor doctor1 = doctorRepository.save(
                Doctor.builder()
                        .name("Dr A")
                        .specialization("Cardio")
                        .email("a@h.com")
                        .build()
        );


        Department department = departmentRepository.save(
                Department.builder()
                        .name("Cardiology")
                        .headDoctor(doctor1)
                        .build()
        );
        departmentService.assignDoctorToDepartment(
                department.getId(),
                doctor1.getId()
        );
        Department saved = departmentRepository
                .findById(department.getId())
                        .orElseThrow();
        assertThat(saved.getDoctors()).contains(doctor1);
    }
    @Test
    public void deleteDepartment_shouldNotDeleteDoctor() {

        // create doctor
        Doctor doctor = doctorRepository.save(
                Doctor.builder()
                        .name("Dr Delete")
                        .email("delete@hospital.com")
                        .specialization("Neuro")
                        .build()
        );

        // create department
        Department department = departmentRepository.save(
                Department.builder()
                        .name("Neurology")
                        .headDoctor(doctor)
                        .build()
        );

        // assign doctor to department
        departmentService.assignDoctorToDepartment(
                department.getId(),
                doctor.getId()
        );

        // delete department
        departmentService.deleteDepartment(department.getId());

        // assertions
        assertThat(departmentRepository.findById(department.getId())).isEmpty();
        assertThat(doctorRepository.findById(doctor.getId())).isPresent();
    }

}
