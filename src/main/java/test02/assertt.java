package test02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assertt {
	
	@Test
	 public void assertion(){
	 //Instantiation of driver object. To launch Firefox browser
		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	 //To open the URL
	 driver.get("https://www.softwaretestingmaterial.com");
	 //Actual title is "Software Testing Material - A site for Software Testers" 
	 //We took title as "Software Testing Material" to make the test fail
	 String Title = "Software Testing Material";
	 String GetTitle = driver.getTitle();
	 System.out.println("Assertion starts here...");
	 Assert.assertEquals(Title, GetTitle);
	 System.out.println("A blog for Software Testers");
	                driver.quit(); 
	 }

}
