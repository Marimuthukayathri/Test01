package test02;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class getdata  {

	public static String TokenNo;
	
	
	@Test 
	public void Login()  {
		
	System.out.println("Add Job Function is started"); 	
	
	 RequestSpecification request = RestAssured.given();
	 request.given().auth().basic("qapmtest", "Toppan@2").when().get("https://tccuatwebapiduplicate.azurewebsites.net/api/account/Login");

	 Response response = request.post("https://tccuatwebapiduplicate.azurewebsites.net/api/account/Login"); 
	
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	System.out.println("Response body: " + response.body().asString());
	TokenNo = response.getHeader("Token");
	System.out.println(TokenNo); 
	
	Assert.assertEquals(statusCode, 200);
	 
	 
	}
	
	
	
	@Test (dependsOnMethods = { "Login" }) 
	 public void Get_01 () throws IOException   {

		System.out.println(TokenNo); 
		System.out.println("Get Method01 is Started ");
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()   
		.url("https://tccuatwebapiduplicate.azurewebsites.net/api/users/GetConfiguredHKPMTeams")
		.get() .addHeader("Token", TokenNo) .build(); 

		okhttp3.Response response = client.newCall(request).execute();  
		
		String data = response.toString();
		int code = response.code();
		System.out.println("Data is : " +data);
		System.out.println("Response from server" + code);
		System.out.println("Response body: " + response.body().string()); 
		System.out.println("\"Get Method01 is Ended\n ");
		Assert.assertEquals(code, 20);
		
	 }

	
	@Test (dependsOnMethods = { "Login" }) 
	 public void Get_02 () throws IOException   {

		System.out.println(TokenNo); 
		System.out.println("Get Method02 is Started ");
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()   
		.url("https://tccuatwebapiduplicate.azurewebsites.net/api/users/GetSalesUsers?locationId=-4")
		.get() .addHeader("Token", TokenNo) .build(); 

		okhttp3.Response response = client.newCall(request).execute();  
		
		String data = response.toString();
		int code = response.code();
		System.out.println("Data is : " +data);
		System.out.println("Response from server" + code);
		System.out.println("Response body: " + response.body().string()); 
		Assert.assertEquals(code, 20);
		System.out.println("\"Get Method02 is Ended\n ");
	 }
	
	@Test (dependsOnMethods = { "Login" }) 
		 public void Get_03 () throws IOException   {

		System.out.println(TokenNo); 
		System.out.println("Get Method03 is Started ");
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()   
		.url("https://tccuatwebapiduplicate.azurewebsites.net/api/project/GetProjectIdsAndNamesForAddUpdate?locationId=-4")
		.get() .addHeader("Token", TokenNo) .build(); 

		okhttp3.Response response = client.newCall(request).execute();  
		
		String data = response.toString();
		int code = response.code();
		System.out.println("Data is : " +data);
		System.out.println("Response from server" + code);
		System.out.println("Response body: " + response.body().string()); 
		Assert.assertEquals(code, 20);
		System.out.println("\"Get Method03 is Ended\n ");
	 }
	 
	@Test (dependsOnMethods = { "Login" }) 
	 public void Get_04 () throws IOException   {

		 System.out.println(TokenNo); 
		System.out.println("Get Method04 is Started ");
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()   
		.url("https://tccuatwebapiduplicate.azurewebsites.net/api/company/GetCompanyNames?locationId=-4&taskIdentity=null")
		.get() .addHeader("Token", TokenNo) .build(); 

		okhttp3.Response response = client.newCall(request).execute();  
		
		String data = response.toString();
		int code = response.code();
		System.out.println("Data is : " +data);
		System.out.println("Response from server: " + code);
		System.out.println("Response body: " + response.body().string()); 
		Assert.assertEquals(code, 20);
		System.out.println("\"Get Method04 is Ended \n ");
	 }
	
	@Test (dependsOnMethods = { "Login" }) 
	 public void Get_05 () throws IOException   {
		 System.out.println(TokenNo); 
		System.out.println("Get Method05 is Started ");
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()   
		.url("https://tccuatwebapiduplicate.azurewebsites.net/api/masterdata/getJobTypeAndTeamMapping") 
		.get() .addHeader("Token", TokenNo) .build(); 

		okhttp3.Response response = client.newCall(request).execute();  
		
		String data = response.toString();
		int code = response.code();
		System.out.println("Data is : " +data);
		System.out.println("Response from server: " + code);
		System.out.println("Response body: " + response.body().string()); 
		Assert.assertEquals(code, 20);
		System.out.println("\"Get Method05 is Ended\n ");
	 }

	 
	@Test (dependsOnMethods = { "Login" }) 
			public void Postmethod_001() throws IOException  {
	
			System.out.println("Post method is Started\n ");
			
			OkHttpClient client = new OkHttpClient();
				
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "");   
						Request request = new Request.Builder()
			.url("https://tccuatwebapiduplicate.azurewebsites.net/api/masterdata/types")
			.post(body) 
			.addHeader("Token", TokenNo ).build();  

			okhttp3.Response response = client.newCall(request).execute(); 
						
			String data = response.toString();
			System.out.println("Data is : " +data);
			int statusCode = response.code();
			System.out.println("The status code recieved: " + statusCode);
			System.out.println("Response body: " + response.body().string());     
			System.out.println("Response Msg: " + response.message()); 
			Assert.assertEquals(statusCode, 20);
		    System.out.println("Post method is Ended ");
	 }
	
	 
	 
	// @Test
		public void Postmethod_002() throws IOException  {

		System.out.println("Post method is Started\n ");
		
		OkHttpClient client = new OkHttpClient();
			
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "");   
					Request request = new Request.Builder()
		.url("http://localhost:51783/api/Jobs/GetSubJobTypes?jobTypeId=115")
		.post(body) 
		.addHeader("Token", TokenNo ).build();  

		okhttp3.Response response = client.newCall(request).execute(); 
					
		String data = response.toString();
		System.out.println("Data is : " +data);
		int statusCode = response.code();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().string());     
		System.out.println("Response Msg: " + response.message()); 
		Assert.assertEquals(statusCode, 20);
	    System.out.println("Post method is Ended ");
}
	 
	 
		@Test (dependsOnMethods = { "Login" }) 
			public void Postmethod_003() throws IOException  {

		System.out.println("Post method is Started\n ");
		
		OkHttpClient client = new OkHttpClient();
			
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "");   
					Request request = new Request.Builder()
		.url("https://tccuatwebapiduplicate.azurewebsites.net/api/Jobs/AddJob")
		.post(body) 
		.addHeader("Token", TokenNo ).build();  

		okhttp3.Response response = client.newCall(request).execute(); 
					
		String data = response.toString();
		System.out.println("Data is : " +data);
		int statusCode = response.code();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().string());     
		System.out.println("Response Msg: " + response.message()); 
		Assert.assertEquals(statusCode, 20);
	    System.out.println("Post method is Ended ");
 }
		
	
}