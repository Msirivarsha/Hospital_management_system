package com.hospital_management_system.demo.entity;


import jakarta.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorid;

    private String name;
    private String specialization;
    private String contactNumber;

    @Lob
    private String availabilitySchedule;

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSpecialization() {
        return name;
    }

    public void setSpecialization(String specialization) {
        this.name = name;
    }
    public String getContactNumber() {
        return name;
    }

    public void setContactNumber(String contactNumber) {
        this.name = name;
    }

	
}