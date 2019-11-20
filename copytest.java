package test02;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class copytest {
	
	By signin = By.xpath(".//*[@id='gb_70']");
	By uname = By.xpath(".//*[@id='identifierId']");
	By next = By.xpath(".//*[@id='identifierNext']/content/span");
	By pwd = By.xpath(".//*[@id='password']/div[1]/div/div[1]/input");
	By next1 = By.xpath(".//*[@id='passwordNext']/content/span");
	By gmail = By.linkText("Gmail");
	By text = By.xpath("//*[@id=\":jc\"]/div/div");
	
	
	@Test
	
	public void copy() throws InterruptedException, IOException { 
	
	System.setProperty("webdriver.chrome.driver", "C:\\Marimuthu\\PC Data\\Downloadsss\\chromedriver_win32\\chromedriver.exe");
	WebDriver d = new ChromeDriver();
//	WebDriver d = new FirefoxDriver();
	d.manage().window().maximize();
	d.get("https://www.google.co.in");
	
	
	wdw wa = new wdw();
	File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	Thread.sleep(3000);
	d.findElement(signin).click();
	Thread.sleep(3000);
	d.findElement(uname).sendKeys("marimuthurevathi@gmail.com");
	FileUtils.copyFile(src, new File ("C:\\Users\\Marimuthu C\\Documents\\Marimuthu\\SeleniumSS\\uname.png"));
	Thread.sleep(3000);
	d.findElement(next).click();
	Thread.sleep(3000);
	d.findElement(pwd).sendKeys("96206aishwarya");
	FileUtils.copyFile(src, new File ("C:\\Users\\Marimuthu C\\Documents\\Marimuthu\\SeleniumSS\\pwd.png"));
	Thread.sleep(3000);
	d.findElement(next1).click();
	wa.webdrwait(d, 20, gmail);
	d.findElement(gmail).click();
	wa.webdrwait(d, 20, text);
	
	String Actualtext = d.findElement(text).getText();
	FileUtils.copyFile(src, new File ("C:\\Users\\Marimuthu C\\Documents\\Marimuthu\\SeleniumSS\\mail.png"));
	Thread.sleep(3000);
	Assert.assertEquals(Actualtext, "Compose");
	
		
}

}