package com.bridgelabz.restassuredbddframwork;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PostCallBDD {

	@Test
	public void testPostReq() {
		given()
			.headers("AppKey","key-value")
			.param("wfsfirst_name","first")
			.param("wfslast_name","last")
			.param("wfsemail","test@test.com")
		.when().post("http://api.fonts.com/rest/Json/Accounts/")
			.then()
			.statusCode(401).log().all();
				
		
	}
	
	
}
