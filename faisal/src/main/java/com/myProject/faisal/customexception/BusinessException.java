package com.myProject.faisal.customexception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;
	
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public BusinessException(String errorMessage, String errorCode) {
		super(null,null,false,false);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	


	public String getErrorMessage() {
		return errorMessage;
	}



	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



	public String getErrorCode() {
		return errorCode;
	}



	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
