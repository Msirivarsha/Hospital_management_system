package com.hospital_management_system.demo.controller;

import com.hospital_management_system.demo.entity.Patient;
import com.hospital_management_system.demo.entity.User;
import com.hospital_management_system.demo.service.PatientService;
import com.hospital_management_system.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientDashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient/dashboard")
    public String patientDashboard(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        if (user == null) {
            return "redirect:/login?error";
        }
        Patient patient = patientService.findByUserid(user.getUserid());
        model.addAttribute("patient", patient);
        return "patient-dashboard";
    }

    @GetMapping("/patient/profile")
    public String patientProfile(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        if (user == null) {
            return "redirect:/login?error";
        }
        Patient patient = patientService.findByUserid(user.getUserid());
        model.addAttribute("patient", patient);
        return "patient-profile";
    }
}
