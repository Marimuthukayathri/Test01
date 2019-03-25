package test02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class gmail_pf {

	
	@Test
	public void checkValidUser() throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		//d.get("https://www.google.co.in");
		d.navigate().to("https://www.google.co.in"); 
	    //d= BrowserFactory.startBrowser("Chrome", "http://demosite.center/wordpress/wp-login.php");

	// Created Page Object using Page Factory
		gmail login1 = PageFactory.initElements(d, gmail.class);

	// Call the method

	login1.login("marimuthurevathi@gmail.com", "96206aishwarya");



	}

	
}
