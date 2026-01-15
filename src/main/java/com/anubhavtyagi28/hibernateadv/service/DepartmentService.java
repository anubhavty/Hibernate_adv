package com.anubhavtyagi28.hibernateadv.service;


import com.anubhavtyagi28.hibernateadv.entity.Department;
import com.anubhavtyagi28.hibernateadv.entity.Doctor;
import com.anubhavtyagi28.hibernateadv.repository.DepartmentRepository;
import com.anubhavtyagi28.hibernateadv.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    public DepartmentService(DepartmentRepository departmentRepository, DoctorRepository doctorRepository) {
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
    }
    @Transactional
    public Department createNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    //asign doctor to deparment -> many to many
    @Transactional
    public Department assignDoctorToDepartment(Long departmentId, Long doctorId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        department.getDoctors().add(doctor);
        return department;
    }
    @Transactional
    public void removeDoctorFromDepartment(Long departmentId, Long doctorId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        department.getDoctors().remove(doctor);
    }
    // Assign head doctor
    @Transactional
    public void assignHeadDoctor(Long departmentId, Long doctorId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        department.setHeadDoctor(doctor);
    }

    // Remove head doctor (doctor stays)
    @Transactional
    public void removeHeadDoctor(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow();

        department.setHeadDoctor(null);
    }
    @Transactional
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow();
        department.getDoctors().clear();//it will clear the join table
        departmentRepository.delete(department);
    }
}
