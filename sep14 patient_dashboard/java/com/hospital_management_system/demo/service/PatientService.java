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
    public Optional<Patient> getPatientDetails(int id) {
        return patientRepository.findById(id);
    }

    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
    public Patient registerPatient(Patient patient) {
    	 try {
    	        Patient savedPatient = patientRepository.save(patient);
    	        System.out.println("Patient saved: " + savedPatient.getPatientid());
    	        return savedPatient;
    	    } catch(Exception e) {
    	        e.printStackTrace();
    	        throw e;
    	    }
    }

    public Patient findByUserid(int userid) {
        return patientRepository.findByUserid(userid);
    }
    
//    public Patient addPatient(Patient patient) {
//        return patientRepository.save(patient);
//    }

    public Patient updatePatient(Patient patient) {
//        patient.setPatientid(id);
        return patientRepository.save(patient);
    }

//    public Optional<Patient> getPatientDetails(int id) {
//        return patientRepository.findById(id);
//    }

//    public void deletePatient(int id) {
//        patientRepository.deleteById(id);
//    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
