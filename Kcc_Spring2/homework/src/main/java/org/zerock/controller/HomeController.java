package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.User;
import org.zerock.service.HomeService;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/home/*")
@Log4j
public class HomeController {
	
	private HomeService service;
	
	@GetMapping
	public String mainPage() {
		
		return "login";
	}
	
	@PostMapping("login")
	public String login(User loginUser, Model model) {
		
		User user = service.getUser(loginUser);
		if(user.getId().equals(loginUser.getId()) && user.getPassword().equals(loginUser.getPassword())) {
			
			return "checkOut";
		}
		else {
			log.info("실패");
		}
		
		return "";
	}
	
	@GetMapping("signup")
	public String signUp(User signupUser) {
		
		return "signup";
	}
}