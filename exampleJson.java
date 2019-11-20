package test02;

import org.testng.Assert;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class exampleJson {
	
	@Test
	public void exampleJsonPathTest() {
	  Response res = get("https://tccuatwebapiduplicate.azurewebsites.net/api/users/GetConfiguredHKPMTeams");
	  Assert.assertEquals(200, res.getStatusCode());
	  String json = res.asString();
	  JsonPath jp = new JsonPath(json);
	  Assert.assertEquals("TeamID", jp.get("189")); 
	 
	}
}
