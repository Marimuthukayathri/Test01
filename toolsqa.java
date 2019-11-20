package test02;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class toolsqa {

	@SuppressWarnings("unchecked")
	@Test
	public void RegistrationSuccessful() 
	{ 
	
	//	RestAssured.baseURI ="https://tccuatwebapiduplicate.azurewebsites.net/api/masterdata/types";
	 RequestSpecification request = RestAssured.given();
	// request.given().auth().basic("qapmtest", "Toppan@2").when().get("https://tccuatwebapiduplicate.azurewebsites.net/api/masterdata/types");
	 
	// JSONObject requestParams = new JSONObject();
	// request.body(requestParams.toJSONString());
	  
/*	request.header("Content-Type", "application/json"); 
	request.header("cache-control", "no-cache, no-store, must-revalidate"); 
	request.header("Expires", "0"); 
	request.header("Pragma", "no-cache");
	request.header("Referer", "https://tccuatwebapp.azurewebsites.net/Home/Dashboard");
	request.header("Sec-Fetch-Mode", "cors"); */
	request.header("Token", "Token:8f062ef6-454b-4b40-8b28-ce29865807d6"); 
	
	Response response = request.post("https://tccuatwebapiduplicate.azurewebsites.net/api/masterdata/types"); 
	
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	System.out.println("Response body: " + response.body().asString());
	System.out.println("Response Headers: " + response.headers()); 
	
	Assert.assertEquals(statusCode, 200);
	 
	 
	 
		}
	
}
