package com.hospital_management_system.demo.controller;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;


@Controller
public class DashboardController {

	@GetMapping("/dashboard")
	public String dashboard(Authentication auth) {
	    if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
	        return "redirect:/admin/dashboard";
	    }
	    else if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_DOCTOR"))) {
	        return "redirect:/doctor/dashboard";
	    }
	    else if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_PATIENT"))) {
	        return "redirect:/patient/dashboard";
	    }
	    return "redirect:/?error";
	}
}
