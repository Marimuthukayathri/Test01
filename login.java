package test02;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class login {

	public static String TokenNo;
	
	@Test
	public void Login()  {
	
	 RequestSpecification request = RestAssured.given();
	 request.given().auth().basic("qapmtest", "Toppan@2").when().get("https://tccuatwebapiduplicate.azurewebsites.net/api/account/Login");

	 Response response = request.post("https://tccuatwebapiduplicate.azurewebsites.net/api/account/Login"); 
	
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	System.out.println("Response body: " + response.body().asString());
	TokenNo = response.getHeader("Token");
	System.out.println("Response Headers: " + TokenNo); 
	
	Assert.assertEquals(statusCode, 200);
	 
	 
	}
	
}