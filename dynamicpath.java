package test02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class dynamicpath {
	
	
	@Test
	
	public void testtt12() throws InterruptedException 	{ 
		
			
		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.navigate().to("https://www.toolsqa.com/automation-practice-form/"); 
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions act = new Actions (d);
		WebElement e =	d.findElement(By.xpath("//a[@title='Automation Practice Table']/strong"));
		
		act.moveToElement(e).click().build().perform(); 
		Thread.sleep(10000);
 
		//(//div[@class='control-group'])[position()=1]
		//d.findElement(By.xpath("//*[@id='FirstName']/following::input[@type='text']\r\n"));
		//d.findElement(By.xpath("(//input[@type='text'])[last()-1]")).sendKeys("1987");
		//d.findElement(By.xpath("(//input[@type='text'])[position()=1]")).sendKeys("1987");
		//d.findElement(By.xpath("//div[@class='control-group']/strong[0]")); 
		
	}
}
