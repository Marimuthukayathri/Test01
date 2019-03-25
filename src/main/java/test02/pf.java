package test02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class pf {


@Test
public void checkValidUser()
{

	System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
	WebDriver d = new ChromeDriver();
	d.manage().window().maximize();
	d.get("http://demosite.center/wordpress/wp-login.php");
    //d= BrowserFactory.startBrowser("Chrome", "http://demosite.center/wordpress/wp-login.php");

// Created Page Object using Page Factory
	pagefact login = PageFactory.initElements(d, pagefact.class);

// Call the method

	login.login_wordpress("admin", "demo123");



}



	
}
