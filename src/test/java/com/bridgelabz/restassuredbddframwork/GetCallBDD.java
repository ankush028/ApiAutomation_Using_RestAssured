package com.bridgelabz.restassuredbddframwork;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetCallBDD {
	
	@Test
	public void test_numberOfCircuits_2007() {
		
			given()	
				.when()
			.get("http://ergast.com/api/f1/2017/circuits.json")
				.then()
				.assertThat()
			.statusCode(200)
				.and()
			.body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
			
			//.and().header("content-length",equalTo(4551));
	}
	
	@Test
	public void testGetWithContentType() {
		Response response=given()
			.when()
				.get("https://reqres.in/api/users/2")
				.then().assertThat().statusCode(200).and()
					.body("data.first_name",equalTo("Janet"))
					.body("data.id",equalTo(2))
					.body("data.last_name",equalTo("Weaver")).extract().response();
//			.and()
//					.contentType("application/Json");


	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	
	}
	
	
	
	
}
