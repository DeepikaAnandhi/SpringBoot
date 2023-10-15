package com.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.entity.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override			//Checks whether correct model class has come or not
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Employee emp = (Employee) target;
		
		
		//write validation logics
		if(emp.getEname()== null|| emp.getEname().isBlank()) {
			System.out.println("EmployeeValidator.validate()");
			errors.reject("emp.name.required");
			
		}
		else if(emp.getEname().length()<5 ||emp.getEname().length()>20) {
			System.out.println("EmployeeValidator.validate()");
			errors.rejectValue("employeeLength", "emp.name.length");
		}
		
		if(emp.getJob().equals("")|| emp.getJob().length()==0) {
			System.out.println("EmployeeValidator.validate()");
			errors.rejectValue("job", "emp.job.required");
		}
		
		
		if(emp.getDeptno()==null) {
			System.out.println("EmployeeValidator.validate()");
			errors.rejectValue("dept", "emp.deptno.required");
		}
		
		
		if(emp.getSal()==null) {
			System.out.println("EmployeeValidator.validate()");
			errors.rejectValue("sal", "emp.sal.required");
		}
		else if(emp.getSal()<10000 ||emp.getSal()>200000) {
			System.out.println("EmployeeValidator.validate()");
			errors.rejectValue("sal","emp.sal.range");
		}
	}

}
