package com.myProject.faisal.service;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myProject.faisal.customexception.BusinessException;
import com.myProject.faisal.customexception.ControllerException;
import com.myProject.faisal.entity.employee;
import com.myProject.faisal.repository.employeeRepository;

@Service
public class employeeServiceImplementation implements employeeService {
    @Autowired
	private employeeRepository employeeRepo;
    
    
	@Override
	public void register(String userId, String password, String securityQuestion, String securityAnswer) {
		// TODO Auto-generated method stub
		 Random rand = new Random();
		Long id=rand.nextLong();
		employee e=new employee(id,userId,password,securityQuestion,securityAnswer);
		
		if(e.getUserId().isEmpty()) {
			throw new BusinessException("302","please send userId");
		}
		
		 employeeRepo.save(e);

		
	}

	@Override
	public List<employee> getUsers() {
	
		List<employee> allemployee=(List<employee>)employeeRepo.findAll();
		return allemployee;
	}

	@Override
	public employee updateEmployee(employee emp, Long employeeId) {
		// TODO Auto-generated method stub
		employee empl=employeeRepo.findById(employeeId).get();

		if (Objects.nonNull(emp.getUserId()) && !"".equalsIgnoreCase(emp.getUserId())) {
			empl.setUserId(emp.getUserId());
		}

		if (Objects.nonNull(emp.getPassword()) && !"".equalsIgnoreCase(emp.getPassword())) {
			empl.setPassword(emp.getPassword());
		}

		if (Objects.nonNull(emp.getSecurityQuestion()) && !"".equalsIgnoreCase(emp.getSecurityQuestion())) {
			empl.setSecurityQuestion(emp.getSecurityQuestion());
		}
		if (Objects.nonNull(emp.getSecurityAnswer()) && !"".equalsIgnoreCase(emp.getSecurityAnswer())) {
			empl.setSecurityAnswer(emp.getSecurityAnswer());
		}
		return employeeRepo.save(empl);
		
		
	}

	@Override
	public String deleteEmployeeById(Long employeeId) {
		employeeRepo.deleteById(employeeId);
		// TODO Auto-generated method stub
		return "Employee with id='" + employeeId + "' has been successfully deleted";
	}

	@Override
	public employee getEmployeeByID(Long employeeId) {
		// TODO Auto-generated method stub
		employee empl=employeeRepo.findById(employeeId).get();
		return empl;
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException (BusinessException e){
		ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
	return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	}
}
