package com.SpringSecurity.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
}
