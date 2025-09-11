package com.hospital_management_system.demo.service;

import com.hospital_management_system.demo.entity.Doctor;
import com.hospital_management_system.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(int id, Doctor doctor) {
        doctor.setDoctorid(id);
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorDetails(int id) {
        return doctorRepository.findById(id);
    }

    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
