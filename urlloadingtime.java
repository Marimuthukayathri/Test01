package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class urlloadingtime {

@Test
	
public void Testtt() { 
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	long start = System.currentTimeMillis();
	driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
	long finish = System.currentTimeMillis();
	long total = finish - start; 
	System.out.println("Total time for loading URL is: " +total);
	
	Actions act = new Actions(driver);
	
	WebElement e =	driver.findElement(By.xpath("//a[@title='Automation Practice Table']/strong"));
	String att = driver.findElement(By.xpath("//a[@title='Automation Practice Table']/strong")).getText();
	System.out.println(att); 
	act.moveToElement(e).doubleClick().build().perform();
		
}
	
}
