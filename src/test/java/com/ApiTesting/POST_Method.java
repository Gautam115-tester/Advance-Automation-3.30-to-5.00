package com.ApiTesting;

import java.util.HashMap;

import io.restassured.RestAssured;

public class POST_Method {

	public static void main(String[] args) {	
		HashMap map = new HashMap();
		map.put("name", "xyz");
		map.put("job", "QA");
		
		RestAssured.given().contentType("application/json").body(map).when().
		post("https://reqres.in/api/users").then().log().all();
	}

}
