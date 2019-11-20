package test02;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class verify {
	
	@Test
		
	public void test012 () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.navigate().to("http://learn-automation.com/how-to-write-dynamic-xpath-in-selenium"); 
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);
		d.findElement(By.xpath("//*[@id=\"sendx-close-dNnOns5gBj56SFGkOimE4p\"]")).click();
	//	Thread.sleep(10000);
		
	//	d.findElement(By.xpath("//*span[@class=\"menu-text\"]")).click();
	//	d.findElement(By.xpath("//*[@id=\"menu-item-4270\"]/a/span")).click();
		
		Actions act = new Actions (d);
		WebElement e =	d.findElement(By.xpath("//img[@class='aligncenter wp-image-897 size-full']"));
		
		//*[@id="post-895"]/div[1]/h2[3]/a/img
		act.moveToElement(e).click().build().perform(); 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//d.findElement(By.xpath("//div[@id=\"crayon-5c6e35909638c925412589-7\"]/span")).click();
		
	//	d.findElement(By.cssSelector("#crayon-5c6e35909638c925412589-7 > span")).click();  
		
		
		
}

}