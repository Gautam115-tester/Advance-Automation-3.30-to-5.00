package com.ApiTesting;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

public class VerifyResponseBody {

	public static void main(String[] args) {
		
		ResponseBody res = RestAssured.given().when().get("https://reqres.in/api/users?page=2");  // Response body --> json , xml ,plain text
		
	String body = 	res.asString();  // xml , json , plain text --> String  ("/"/"")
	
//	System.out.println(body);
//	
//	String check = "sharma";
//	
//	
//	if(body.contains(check)) {
//		System.out.println("Contain found in Body variable");
//	} else {
//System.out.println("Contain not found in body variable");
//	}
	                               // String --> json
	JSONObject jo = new JSONObject(body);
	
//	String email = jo.getJSONObject("data").get("email").toString();
//	System.out.println(email);
	
	for(int i = 0; i<jo.getJSONArray("data").length();i++) {
		String emails = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
		
		System.out.println(emails);
	}
	
	

	}

}
