package com.vs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OctSpringresttemplateApplication {

	static RestTemplate restTemplate = new RestTemplate();
	static String baseUrl = "http://dummy.restapiexample.com/api/v1/employees";

	public static void main(String[] args) {
		SpringApplication.run(OctSpringresttemplateApplication.class, args);
		restmethods();
	}

	private static void restmethods() {
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
			Data dt = new Data();
			dt.setEmployee_name("prasad");
			dt.setEmployee_age("28");
			dt.setEmployee_salary("1234");
			dt.setProfile_image("null");
             requestEntity=new HttpEntity<>(dt,headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity,
					String.class);
			HttpStatus status = responseEntity.getStatusCode();
			System.out.println("status is" + status);
			String users = responseEntity.getBody();
			System.out.println("body is" + users);
			HttpHeaders hdrs = responseEntity.getHeaders();
			System.out.println("headers are" + hdrs);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		// This is for get method
//	private static void restmethods() {
//		try {
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
//			ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET,
//					requestEntity, String.class);
//			HttpStatus status = responseEntity.getStatusCode();
//			System.out.println("status is"+status);
//           String users= responseEntity.getBody();
//           System.out.println("body is"+users);
//           HttpHeaders hdrs=responseEntity.getHeaders();
//         System.out.println("headers are"+hdrs);
//		} catch (Exception e) {
//			System.out.println("Exception is " + e.getMessage());
//		}
	}

}
