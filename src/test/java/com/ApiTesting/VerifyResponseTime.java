package com.ApiTesting;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyResponseTime {

	public static void main(String[] args) {
		
		
	Response res =	RestAssured.given().when().get("https://reqres.in/api/users?page=2");
	
	long time = res.getTime();
	
	System.out.println(time+" milliseconds");
	
	res.then().time(Matchers.lessThan(1000l));

	}

}
