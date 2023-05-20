package com.myProject.faisal.service;

import java.util.ArrayList;
import java.util.List;


import com.myProject.faisal.entity.employee;

public interface employeeService {
	
	


	public void register(String userId, String password, String securityQuestion, String securityAnswer);
	
	public List<employee> getUsers();
	employee getEmployeeByID(Long employeeId);
	
	employee updateEmployee(employee emp, Long employeeId);

	// Delete operation by id
	String deleteEmployeeById(Long employeeId);

}
