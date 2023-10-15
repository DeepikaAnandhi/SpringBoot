package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.DeptRepo;
import com.example.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;
	
	@Autowired
	private DeptRepo deptRepo;

	public List<Employee> fetchAllEmployees() {
		return repo.findAll();

	}

	public String saveEmployee(Employee emp) {
		int id = repo.save(emp).getEmpno();
		return " Registration Successful with the EmpId: " + id;
	}

	public Employee getEmpByNo(int id) {
		Employee emp = repo.getReferenceById(id);
		return emp;
	}

	public String udateEmpByNo(Employee emp) {
		Optional<Employee> opt = repo.findById(emp.getEmpno());
		if (opt.isPresent()) {
			repo.save(emp);
			return "Employee with employeeId: " + emp.getEmpno() + " is Updated Successfully";
		}
		return emp.getEmpno() + " Employee is not available for update";
	}

	public String delEmp(int no) {
		repo.deleteById(no);
		return "Employee with EmpId: " + no + " was deleted Successfully";
	}
	
	
	public List<Integer> showAllDept(){
		return deptRepo.fetchAllDeptNo();
	}

}
