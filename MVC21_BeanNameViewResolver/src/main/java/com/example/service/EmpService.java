package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repo.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo emprepo;
	
	
	public Iterable<Employee> getAllEmps(){
		return emprepo.findAll();
	}

}
