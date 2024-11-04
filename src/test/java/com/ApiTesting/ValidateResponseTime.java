package com.ApiTesting;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class ValidateResponseTime {
	@Test
	public void time() {
		Response res = RestAssured.given().when().get("https://reqres.in/api/users/2");
		
	long t =	res.getTime();
		
	System.out.println(t +" Milliseconds");
	
	res.then().time(Matchers.lessThanOrEqualTo(1000l));
	}	
}