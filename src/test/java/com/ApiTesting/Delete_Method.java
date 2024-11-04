package com.ApiTesting;

import io.restassured.RestAssured;

public class Delete_Method {

	public static void main(String[] args) {
		
		RestAssured.given().when().delete("https://reqres.in/api/users/93") // <--Account create Id
		.then().log().all();

	}

}
