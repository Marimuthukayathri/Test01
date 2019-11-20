package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class paralchrome {


  @Test
  public void loginnn() throws InterruptedException {
	  
	  
	  
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
		
		WebDriver	driver = new ChromeDriver();
			
			driver.manage().window().maximize();
	  
	  
	  driver.navigate().to("https://global.datasiteone.merrillcorp.com/manda/project/582a00efb3065d39e4d3d6f2/content/index");
 
	  By email = By.xpath("//*[@id=\"username\"]");
		By pwd = By.xpath("//*[@id=\"password\"]"); //*[@id="password"]
		By Logon = By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/div[4]/a");
	  
	  Action a = new Action(); 
	  
	  wdw wa = new wdw();
		
		wa.webdrwait(driver, 20, email);
		
		driver.findElement(email).sendKeys("c906128");
		
		wa.webdrwait(driver, 20, pwd);
		
		driver.findElement(pwd).sendKeys("Mari@1234");
		
		wa.webdrwait(driver, 20, Logon);
		
		a.clkelemt(driver, Logon);
		
		System.out.println("Login was successful");
 }  
  
  
  @Test
  public void login( ) throws InterruptedException {
	  
	  
	  
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
		
	  WebDriver	driver = new ChromeDriver();
			
			driver.manage().window().maximize();
	  
	  
	  driver.navigate().to("https://global.datasiteone.merrillcorp.com/manda/project/582a00efb3065d39e4d3d6f2/content/index");
 
	  By email = By.xpath("//*[@id=\"username\"]");
		By pwd = By.xpath("//*[@id=\"password\"]"); //*[@id="password"]
		By Logon = By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/div[4]/a");
	  
	  Action a = new Action(); 
	  
	  wdw wa = new wdw();
		
		wa.webdrwait(driver, 20, email);
		
		driver.findElement(email).sendKeys("c906128");
		
		wa.webdrwait(driver, 20, pwd);
		
		driver.findElement(pwd).sendKeys("Mari@1234");
		
		wa.webdrwait(driver, 20, Logon);
		
		a.clkelemt(driver, Logon);
		
		System.out.println("Login was successful");
 }  
  
  
 
  
 
  
}
