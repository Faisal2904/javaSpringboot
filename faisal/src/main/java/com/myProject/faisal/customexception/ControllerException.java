package com.myProject.faisal.customexception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;
	
	public ControllerException(String errorMessage, String errorCode) {
		super(null,null,false,false);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	

	public ControllerException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getErrorMessage() {
		return errorMessage;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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
