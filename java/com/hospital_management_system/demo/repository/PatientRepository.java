package com.hospital_management_system.demo.repository;


import com.hospital_management_system.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {}

