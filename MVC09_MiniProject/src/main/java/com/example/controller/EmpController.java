package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.Employee;
import com.example.service.EmpService;
import com.example.validator.EmployeeValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {

	@Autowired
	private EmpService service;
	
	@Autowired
	private EmployeeValidator empValidator;
	
	


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
	public String addEmp(HttpSession sess, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		if(empValidator.supports(emp.getClass())) {
			System.out.println("EmpController.addEmp() -- validator if block");
			empValidator.validate(emp, errors);
		}
		if(errors.hasErrors()) {
			return "employee_register_form";
		}
		System.out.println("EmpController.addEmp() --codes after validator method");
		String msg = service.saveEmployee(emp);
		sess.setAttribute("resultmsg", msg);
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
	public String shoWEdit1(RedirectAttributes attr, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		if(empValidator.supports(Employee.class)) {
			empValidator.validate(emp, errors);
		}
		if(errors.hasErrors()) {
			return "employee_register_form";
		}
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
	
// method of reference data holding the dept names
	@ModelAttribute("dNoList")
	public List<Integer> populateDeptNames(){
		return service.showAllDept();
	}
	
}
