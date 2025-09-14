package com.hospital_management_system.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hospital_management_system.demo.entity.User;
import com.hospital_management_system.demo.entity.Patient;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("patient", new Patient());
        return "home";
    }
    
}

