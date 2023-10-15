package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.model.JobSeekerModel;
import com.example.service.JobSeekerService;

@Controller
public class JobSeekerController {
	@Autowired
	private JobSeekerService service;
	
	
	@GetMapping("/")
	public String showHome(){
		return "index";
	}
	
	@GetMapping("/js_register")
	public String registerForm(@ModelAttribute("js") JobSeekerModel jobSeekerModel) {
		return "registrationForm";
	}
	

}
