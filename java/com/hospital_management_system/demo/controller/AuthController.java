
package com.hospital_management_system.demo.controller;

import com.hospital_management_system.demo.entity.User;
import com.hospital_management_system.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
//        if (userService.userRepository.findByUsername(user.getUsername()) != null) {
//            model.addAttribute("error", "Username already exists");
//            return "register";
//        }
    	if (userService.existsByUsername(user.getUsername())) {
    	    model.addAttribute("error", "Username already exists");
    	    return "register";
    	}

        userService.registerUser(user);
        return "redirect:/login?registerSuccess";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
