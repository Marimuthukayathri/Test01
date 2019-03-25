package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mousehover {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.co.in");  
		
		WebElement sear= driver.findElement(By.name("q")); 
		Actions a = new Actions(driver);
		//a.moveToElement(sear).build().perform();
		a.contextClick(sear).build().perform();
		
		
		
	}

}
