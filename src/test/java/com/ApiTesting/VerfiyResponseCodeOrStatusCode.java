package com.ApiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerfiyResponseCodeOrStatusCode {

	@Test
	public void StatusCode() {
		
	Response res =	RestAssured.given().when().delete("https://reqres.in/api/users/2");

        int statuscode = res.getStatusCode();
        
        Assert.assertEquals(statuscode, 200);
	
	}

}
