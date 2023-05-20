package com.myProject.faisal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class employee {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userId;
	private String password;
	private String securityQuestion;
	private String securityAnswer;

	public employee(Long id2, String userId2, String password2, String securityQuestion2, String securityAnswer2) {		// TODO Auto-generated constructor stub
		this.id=id2;
		this.userId=userId2;
	    this.password=password2;
        this.securityQuestion=securityQuestion2;
        this.securityAnswer=securityAnswer2;
}
	public employee() {}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	

}
