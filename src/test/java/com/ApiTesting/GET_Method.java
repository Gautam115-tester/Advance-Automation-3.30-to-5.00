package com.ApiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GET_Method {

//	response header and response body
	
	@Test
	public void info() {
		
		RestAssured.given().when().get("https://reqres.in/api/users/2").
		then().log().all();
		
	}
	
	
}
