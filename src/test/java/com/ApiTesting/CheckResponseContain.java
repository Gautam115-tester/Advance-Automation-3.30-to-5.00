package com.ApiTesting;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
public class CheckResponseContain {
	@Test
	public void responseBodyContain() {
		ResponseBody res = RestAssured.given().when()
				.get("https://reqres.in/api/users?page=2");  // Response body --> json / Xml / Plain text
		
		String body = res.asString(); // json / xml / plain text --> String
		
		String check = "Janet"; // String
		
//		Assert.assertEquals(body.contains(check), true); 
// validate body contain check
//if it's present then it will pass true otherwise it will pass false if match not found.
		
		JSONObject jo = new JSONObject(body);  // to convert value only in json format without pretty format.
		
		System.out.println(jo);
//		in here "data" is nothing but data present in json value after conversion in JSONObject
//		          Getting all "data" values in json format and length method giving how many data is present in format of int  eg :- 6
		for(int i = 0; i < jo.getJSONArray("data").length();i++) {
		   //getJsonObject(i) related  //It getting value of data on the based of index and given data are first , last , email and etc 
			String emails = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			
			System.out.println(emails);
		}
		                
	}
	
}
