package com.myProject.faisal.controllerAdvice.java;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myProject.faisal.customexception.BusinessException;
import com.myProject.faisal.customexception.ControllerException;

@ControllerAdvice
public class controllerAdvice {
	
	
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
