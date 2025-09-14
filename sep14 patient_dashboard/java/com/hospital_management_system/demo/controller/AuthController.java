
package com.hospital_management_system.demo.controller;

import com.hospital_management_system.demo.entity.User;
import com.hospital_management_system.demo.entity.Patient;
import com.hospital_management_system.demo.service.UserService;
import com.hospital_management_system.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user,@ModelAttribute Patient patient, Model model) {
//        if (userService.userRepository.findByUsername(user.getUsername()) != null) {
//            model.addAttribute("error", "Username already exists");
//            return "register";
//        }
    	if (userService.existsByUsername(user.getUsername())) {
    	    model.addAttribute("error", "Username already exists");
    	    return "register";
    	}

    	user.setRole(User.Role.PATIENT);
        User savedUser = userService.registerUser(user);

        patient.setUserid(savedUser.getUserid());
        patientService.registerPatient(patient);

        return "redirect:/login?registerSuccess";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
    @GetMapping("/login")
    public String login() {
        return "redirect:/";
    }

}
