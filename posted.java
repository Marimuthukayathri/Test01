package test02;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
	
public class posted {


		@Test
		public void Postmethod() throws IOException  {
		 
			OkHttpClient client = new OkHttpClient();
			
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "");   
						Request request = new Request.Builder()
			  .url("https://tccuatwebapiduplicate.azurewebsites.net/api/masterdata/types")
			  .post(body) 
			  .addHeader("Token", "Token:e67d81c2-76c9-43ec-96b8-3750018adb8c").build();  

					okhttp3.Response response = client.newCall(request).execute(); 
					
					String data = response.toString();
					System.out.println("Data is : " +data);
		int statusCode = response.code();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().string());     
		System.out.println("Response Msg: " + response.message()); 
		
		Assert.assertEquals(statusCode, 200);
		 
		 
	
	
}
}
