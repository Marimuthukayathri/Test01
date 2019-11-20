package test02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class valid1 {
	
	public static WebDriver dr;

	public class GetAttributes {

		
		By by = By.xpath("//label[contains(@for,'cb1164')]");
		
		By email = By.name("username");
		By pwd = By.name("password");
		By Logon = By.xpath("/html/body/div/div[1]/div/div[2]/div/form/div[3]/div[2]/button");
	
		@Test
		public void getAttribute_ButtonName() throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
			
			dr = new ChromeDriver();
			
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			dr.manage().window().maximize();
			
			dr.navigate().to("https://tccuatwebapp.azurewebsites.net/Home/Dashboard"); 
			
			wdw wa = new wdw();
			
			Action a = new Action();
			
			wa.webdrwait(dr, 20, email);
			
			dr.findElement(email).sendKeys("stepheni");
			
			wa.webdrwait(dr, 20, pwd);
			
			dr.findElement(pwd).sendKeys("Jasmininn2002!");
			
			wa.webdrwait(dr, 20, Logon);
			
			a.clkelemt(dr, Logon);
			
			System.out.println("Login was successful");
			
			String str = dr.findElement(email).getText();
			
			System.out.println(str); 
			
			Thread.sleep(2000); 
			
			dr.findElement(By.xpath("//a[contains(@class,'dropdown-toggle ng-isolate-scope')]")).click();
			
			Thread.sleep(2000); 
			
			dr.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/div/ul/li[9]/a/span")).click();
			
			Thread.sleep(2000); 
			
			dr.findElement(By.xpath("//span[contains(.,'System Role')]")).click();
			
			Thread.sleep(2000); 
			
			dr.findElement(By.xpath("(//input[contains(@type,'text')])[2]")).sendKeys("Stephensysrole"); 
			
			Thread.sleep(2000); 
			
			dr.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
			
			Thread.sleep(2000); 
			
			dr.findElement(By.xpath("//a[contains(@class,'ng-binding ng-isolate-scope')]")).click();
			
			Thread.sleep(2000); 
			
			WebElement Btn = dr.findElement(by);
			
			String var = Btn.getAttribute("for");
			System.out.println("Name of the button is:- " +var);
		}

	}

}
