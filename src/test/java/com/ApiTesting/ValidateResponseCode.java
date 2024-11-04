package com.ApiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateResponseCode {

	@Test
	public void validate(){
		Response res = RestAssured.given().when().get("https://reqres.in/api/users/2");
		int resposecode = res.statusCode();
		Assert.assertEquals(resposecode, 200);
	}
	
}
