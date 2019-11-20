package test02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossbrow {
	
	
	@Test
	 
	// Here this parameters we will take from testng.xml
	@Parameters("Browser")
	public  void test1(String browser) {
	 
	if(browser.equalsIgnoreCase("Chrome")){
	 
		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.google.co.in");
		
		//d.quit();
	 
	}
	else if(browser.equalsIgnoreCase("IE")){
	 
	System.setProperty("webdriver.ie.driver", "C:\\Marimuthu\\PC Data\\D Drive\\Marimuthu\\Downloads\\IEDriverServer.exe");
	 
	WebDriver driver=new InternetExplorerDriver();
	 
	driver.manage().window().maximize();
	 
	driver.get("https://www.facebook.com");
	 
	//driver.quit();
	}
	}
	 
	}


