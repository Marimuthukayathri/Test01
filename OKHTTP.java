package test02;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;



public class OKHTTP {

	
	@Test
	public void login() throws IOException  {
	 
		OkHttpClient client = new OkHttpClient();
		
	//	OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor("qapmtest", "Toppan@2")).build(); 
			    
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "");   
					Request request = new Request.Builder()
		  .url("https://tccuatwebapiduplicate.azurewebsites.net/api/account/Login")
		  .post(body) 
		  .addHeader("Authorization", "Basic cWFwbXRlc3Q6VG9wcGFuQDI=").build();  

				okhttp3.Response response = client.newCall(request).execute(); 
				
				String data = response.toString();
				System.out.println("Data is : " +data);
	int statusCode = response.code();
	System.out.println("The status code recieved: " + statusCode);
	System.out.println("Response body: " + response.body().string());     
	System.out.println("Response Msg: " + response.message()); 
	System.out.println("Response Header: " + response.header("Token"));  
	
	Assert.assertEquals(statusCode, 200);
	 
	
}
	
}
