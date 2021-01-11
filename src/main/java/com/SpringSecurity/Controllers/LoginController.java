package com.SpringSecurity.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String showLoginPage() {
		return "fancy-login";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "accessDenied";
	}
	
	
}