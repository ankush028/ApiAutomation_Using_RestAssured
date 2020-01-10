package com.bridgelabz.restassured.oauth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author Ankush Kumar Agrawal
 *
 */
public class Twitter {

	/**
	 * @request POST
	 * @purpose create test for tweet in twitter
	 */
	@Test
	public void postTweet() {
		
		Response response = RestAssured.given().auth()
				.oauth("5IEndJKw87g7aXXXXXXX",
						"fPkcKbNKGEh73ADtGs3SDTrS49qLaVAh4ndV9wyaXXXXXXX",
						"2838134280-PgCso4dAQJdY7JvqdSREfDj5SUBaXXXXXXX",
						"PsO5paAyfKbTcgO4lXXLeZDMM9Q8IKwfqqvaXXXXXXX")
				.post("https://api.twitter.com/1.1/statuses/update.json?="
						+ "status= My first Rest Assured Api Test tweet ");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().jsonPath().prettify());
		
	}
	@Test
	public void deleteTweet() {
		
		Response response = RestAssured.given().auth()
				.oauth("5IEndJKw87g7UidifaXKi0tcu",
						"fPkcKbNKGEh73ADtGs3SDTrS49qLaVAh4ndV9wyanaXXXXXXX",
						"2838134280-PgCso4dAQJdY7JvqdSREfDj5aXXXXXXXKNdZ",
						"PsO5paAyfKbTcgO4lXXLeZDMM9Q8IKwaXXXXXXX")
				.delete("https://api.twitter.com/1.1/statuses/destroy/:12155854947984aXXXXXXX4");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().jsonPath().prettify());
		
	}
}
