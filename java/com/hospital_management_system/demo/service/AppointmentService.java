package com.hospital_management_system.demo.service;

import com.hospital_management_system.demo.entity.Appointment;
import com.hospital_management_system.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment scheduleAppointment(Appointment appointment) {
        // Add possible validation logic here
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> getAppointmentDetails(int id) {
        return appointmentRepository.findById(id);
    }

    public void cancelAppointment(int id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment != null) {
            appointment.setStatus(Appointment.Status.CANCELLED);
            appointmentRepository.save(appointment);
        }
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
