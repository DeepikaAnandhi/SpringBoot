package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.Employee;
import com.example.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService service;
	


	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}

	@GetMapping("/report")
	public String showReport(Map<String, Object> map) {
		List<Employee> empsList = service.fetchAllEmployees();
		map.put("empInfo", empsList);
		return "show_result";
	}

	@GetMapping("/register")
	public String regsterEmp(@ModelAttribute("emp") Employee emp) {
		return "employee_register_form";
	}

	@PostMapping("/register")
	public String addEmp(RedirectAttributes attr, @ModelAttribute("emp") Employee emp) {
		String msg = service.saveEmployee(emp);
		attr.addFlashAttribute("resultmsg", msg);
		return "redirect:report";

	}
	
	@GetMapping("/edit")
	public String shoWEdit(@RequestParam("no") int no, @ModelAttribute("memp") Employee memp) {
		System.out.println("EmpController.shoWEdit()");
		Employee emp = service.getEmpByNo(no);
		BeanUtils.copyProperties(emp, memp);
		return "edit_form";
	}
	
	@PostMapping("/edit")
	public String shoWEdit1(RedirectAttributes attr, @ModelAttribute("emp") Employee emp) {
		String msg = service.udateEmpByNo(emp);
		attr.addFlashAttribute("resultmsg", msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("no") int no, RedirectAttributes attr) {
		String msg = service.delEmp(no);
		attr.addFlashAttribute("resultmsg", msg);
		return "redirect:report";
		
	}
}
