package com.hospital_management_system.demo.service;

import com.hospital_management_system.demo.entity.Patient;
import com.hospital_management_system.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(int id, Patient patient) {
        patient.setPatientid(id);
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientDetails(int id) {
        return patientRepository.findById(id);
    }

    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
