package test02;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	
  @Test
  public void f() throws IOException, InterruptedException { 
	  
	    System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://www.google.co.in");
		d.manage().window().maximize();
		d.findElement(By.xpath(".//*[@id='gb_70']")).click();
	    File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src, new File ("D:/Marimuthu/der.jpg"));
	    d.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("marimuthurevathi@gmail.com");
		FileUtils.copyFile(src, new File ("D:/Marimuthu/un.jpg"));
		d.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("96206aishwarya");
		FileUtils.copyFile(src, new File ("D:/Marimuthu/pwd.jpg"));
		
	    
	    
	    
  }
}
