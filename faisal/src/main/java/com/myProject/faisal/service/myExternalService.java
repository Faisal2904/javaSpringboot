package com.myProject.faisal.service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class myExternalService {
	
	public static boolean callExternalService() {
		
		RestTemplate restTemplate =new RestTemplate();
		HttpHeaders headers	= new HttpHeaders();
		
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		return (boolean) restTemplate
				.exchange("http://localhost:1010/isAlive", HttpMethod.GET, jwtEntity, Object.class)
				.getBody();	
		}

}
