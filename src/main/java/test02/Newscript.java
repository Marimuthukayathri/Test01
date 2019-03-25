package test02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newscript {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://www.google.co.in");
		d.manage().window().maximize();
			
		
		
	}

}
