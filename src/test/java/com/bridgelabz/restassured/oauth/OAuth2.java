package com.bridgelabz.restassured.oauth;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth2 {
	
	
	@Test
	public void acessValidApi() {
	Response response	= 
			RestAssured.given().auth()
			.oauth2("ef5298a58728bef1d13b578e3e4b7f24d589b50e")
			.post("http://coop.apps.symfonycasts.com/api/670/chickens-feed");
	
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().jsonPath().prettify());
		
	}
	
	@Test
	public void acessValidApiUsing_TokenTest() {
		Response respose =RestAssured.given().formParam("client_id","RestAssuredLearning")
		.formParam("client_secret","455c7e891d27d360bd6f1017a513cea5")
		.formParam("grant_type", "client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println(respose.getBody().jsonPath().prettify());
		String token = respose.getBody().jsonPath().get("access_token");
		
		Response response = RestAssured.given().auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/670/chickens-feed");
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	@Test
	public void acessInvalidApi() {
		Response respose =RestAssured.given().formParam("client_id","RestAssuredLearning")
				.formParam("client_secret","455c7e891d27d360bd6f1017a513cea5")
				.formParam("grant_type", "client_credentials")
				.post("http://coop.apps.symfonycasts.com/token");
			
				String token = respose.getBody().jsonPath().get("access_token");
				
				Response response = RestAssured.given().auth().oauth2(token)
						.post("http://coop.apps.symfonycasts.com/api/670/egg-collect");
				Assert.assertEquals(response.getStatusCode(),401);
	}
}
