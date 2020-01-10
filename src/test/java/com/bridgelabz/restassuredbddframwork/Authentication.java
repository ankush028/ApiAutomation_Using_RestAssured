package com.bridgelabz.restassuredbddframwork;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class Authentication extends BaseClass{
	
	@Test
	public void testWithAuthentication() {
		/*
		RestAssured.given().auth().preemptive().basic("ToolsQA","TestPassword")
						.get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
				.getStatusCode();		
		 *
		 * */
			
		int code =	RestAssured.given()
						.get()
				.getStatusCode();		
		System.out.println("Respnonse code from server : "+code);
	}
	
}
