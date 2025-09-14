package com.hospital_management_system.demo.controller;


import com.hospital_management_system.demo.entity.Appointment;
import com.hospital_management_system.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments";
    }

    @GetMapping("/schedule")
    public String showScheduleForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "schedule-appointment";
    }

    @PostMapping("/schedule")
    public String scheduleAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.scheduleAppointment(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/cancel/{id}")
    public String cancelAppointment(@PathVariable("id") int id) {
        appointmentService.cancelAppointment(id);
        return "redirect:/appointments";
    }

    @GetMapping("/details/{id}")
    public String viewAppointmentDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("appointment", appointmentService.getAppointmentDetails(id).orElse(null));
        return "appointment-details";
    }
}
