package com.myProject.faisal.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.faisal.customexception.BusinessException;
import com.myProject.faisal.customexception.ControllerException;
import com.myProject.faisal.entity.employee;
import com.myProject.faisal.service.employeeService;
import com.myProject.faisal.service.myExternalService;
@RestController
@RequestMapping("/Employee")
public class employeeController {
	
	@Autowired
	private employeeService employeeserv;
	
	@GetMapping("/isAlive")
	public Boolean isAlive() {
		return true;
	}
	

	@GetMapping(value = "/getEmployee")
	public List<employee> getUsers() {
		List<employee> users= employeeserv.getUsers();
		return users;
	}
	@GetMapping(value = "/getEmployee/{employeeId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("employeeId") Long employeeId){
		employee emp=employeeserv.getEmployeeByID(employeeId);
		return  new ResponseEntity<employee>(emp, HttpStatus.OK);}
	
	@PostMapping(value ="/createEmployee")
	public String createUser(@RequestBody employee e) {
		employeeserv.register(e.getUserId(),e.getPassword(),e.getSecurityQuestion(),e.getSecurityAnswer());
		return e.toString() + "created.";
	}
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<?> updateEmployee(@RequestBody employee emp,
			@PathVariable("employeeId") Long employeeId) {
		employee updatedEmployee = employeeserv.updateEmployee(emp, employeeId);
		return new ResponseEntity<employee>(updatedEmployee, HttpStatus.CREATED);
	}

	// Delete operation by id
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("employeeId") Long employeeId) {
		String deletedEmployee = employeeserv.deleteEmployeeById(employeeId);
		return new ResponseEntity<String>(deletedEmployee, HttpStatus.OK);
	}
	
	// Read operation All
	@GetMapping("/someExternalService")
	public boolean someExternalService() {
		return myExternalService.callExternalService();
	}

	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException (BusinessException e){
		ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
	return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleBusinessException1 (Exception e){
		ControllerException ce = new ControllerException("100212", "code fatt gya");
	return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	}
	

	

}
