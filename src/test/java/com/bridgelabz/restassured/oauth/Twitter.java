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
				.oauth("5IEndJKw87g7UidifaXKi0tcu",
						"fPkcKbNKGEh73ADtGs3SDTrS49qLaVAh4ndV9wyanL9K1xKxe6",
						"2838134280-PgCso4dAQJdY7JvqdSREfDj5SUBSTBSK2kkKNdZ",
						"PsO5paAyfKbTcgO4lXXLeZDMM9Q8IKwfqqvfW8KhsLDpU")
				.post("https://api.twitter.com/1.1/statuses/update.json?="
						+ "status= My first Rest Assured Api Test tweet ");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().jsonPath().prettify());
		
	}
	@Test
	public void deleteTweet() {
		
		Response response = RestAssured.given().auth()
				.oauth("5IEndJKw87g7UidifaXKi0tcu",
						"fPkcKbNKGEh73ADtGs3SDTrS49qLaVAh4ndV9wyanL9K1xKxe6",
						"2838134280-PgCso4dAQJdY7JvqdSREfDj5SUBSTBSK2kkKNdZ",
						"PsO5paAyfKbTcgO4lXXLeZDMM9Q8IKwfqqvfW8KhsLDpU")
				.delete("https://api.twitter.com/1.1/statuses/destroy/:1215585494798495744");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().jsonPath().prettify());
		
	}
}
