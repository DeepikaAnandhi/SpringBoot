package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Employee;
import com.example.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/report")
	public String generateReort(@RequestParam("type")String type ,Map<String,Object>map) {
		
		Iterable<Employee> empList = empService.getAllEmps();	
		map.put("empList", empList);
		if(type.equalsIgnoreCase("pdf")) return "pdfreport";
		else return "excelreport";
		
	}

}
