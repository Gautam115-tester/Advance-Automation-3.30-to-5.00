package com.ApiTesting;
import java.util.HashMap;
import io.restassured.RestAssured;
public class PUT_Method {
	public static void main(String[] args) {
		
		HashMap map = new HashMap();
		map.put("name", "xyz");
		map.put("job", "Tester");
		
		RestAssured.given().contentType("application/json").body(map).when()
		.put("https://reqres.in/api/users/2").then().log().all();
	}
}