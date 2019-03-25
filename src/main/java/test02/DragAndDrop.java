package test02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
 
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

 
 public class DragAndDrop {
 
	 @Test
 
 public void DD() throws InterruptedException {
 
	System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	
   String URL = "https://www.google.co.in";
   
   driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
   
   driver.get(URL);
 
   driver.findElement(By.xpath(".//*[@id='gb_70']")).click();
	
   driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("marimuthurevathi@gmail.com");
	
	driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
	
	driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("96206aishwarya");
	
	driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
	
	driver.findElement(By.linkText("Gmail")).click();
	
   WebElement From = driver.findElement(By.xpath("//*[@id=\":2k\"]/span/span"));  //*[@id=":2k"]/span/span
 
   WebElement To = driver.findElement(By.xpath("//*[@id=\":ja\"]/div/div[2]/span/a")); //*[@id=":ja"]/div/div[2]/span/a
 
   Actions builder = new Actions(driver);
   
   builder.dragAndDrop(From, To).perform();
 
       /*Action dragAndDrop = builder.clickAndHold(From)
    	    	
      .moveToElement(To) 
 
     .release(To)
 
    .build();
 
   dragAndDrop.perform();
 		
		*/

	}

}
