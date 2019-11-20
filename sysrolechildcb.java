package test02;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class sysrolechildcb {
	
	public static WebDriver dr;
	
	
	By email = By.name("username");
	By pwd = By.name("password");
	By Logon = By.xpath("//translate[contains(@class,'ng-scope')][contains(text(),'Login')]");
	By path = By.xpath("//label[contains(@class,'tgl-btn pull-left')]");   
	 
	@Test
	 
	public void Email_001 () throws InterruptedException, IOException { 
		
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
		
		Thread.sleep(4000); 
		
		dr.findElement(By.xpath("//a[contains(@class,'dropdown-toggle ng-isolate-scope')]")).click();
		
		Thread.sleep(4000); 
		
		dr.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/div/ul/li[9]/a/span")).click();
		
		Thread.sleep(4000); 
		
		dr.findElement(By.xpath("//span[contains(.,'System Role')]")).click();
		
		Thread.sleep(4000); 
		
		
		dr.findElement(By.xpath("(//input[contains(@type,'text')])[2]")).sendKeys("Stephensysrole"); 
		
		Thread.sleep(2000); 
		
		dr.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		Thread.sleep(2000); 
		
		dr.findElement(By.xpath("//a[contains(@class,'ng-binding ng-isolate-scope')]")).click();
		
		Thread.sleep(4000); 
		
		chimth sa = new chimth();
		
		JavascriptExecutor js = (JavascriptExecutor) dr;
	
		
		
		/*elements.forEach(e -> {
		    js.executeScript("arguments[0].click();", e);
		    wait.until(ExpectedConditions.attributeToBe(e,"xpath", "//label[contains(@class,'tgl-btn pull-left')]"));
		    //if element have not only dontNeedToClick class use attributeContains
		    //wait.until(ExpectedConditions.attributeContains(e,"class", "dontNeedToClick"));
		});
		
		*/
		List<WebElement> elements = dr.findElements(path); 
		
	
		for(WebElement w : elements) {
			
			if (w.isEnabled()) {
				
				elements = dr.findElements(path); 
				
				wa.webdrwait(dr, 15, path);
				
				a.clkelemt(dr, path); 
				
			//	Thread.sleep(4000); 
				
				}
				
				
			}
			
			
	        
		//	sa.child(dr);   
			
			Thread.sleep(4000);
			
			dr.findElement(By.xpath("//span[contains(.,'Update And Close')]")).click();
			
			Thread.sleep(4000); 
			
		//	dr.findElement(By.xpath("//a[contains(@class,'dropdown-toggle ng-isolate-scope')]")).click();
			
			dr.findElement(By.xpath("//a[contains(@class,'ng-binding ng-isolate-scope')]")).click();
			
			Thread.sleep(4000); 
			
	//		dr.findElement(By.xpath("(//span[contains(@class,'ng-scope')][contains(text(),'Dashboard')])[1]")).click();
			
			
	        
		 
	}

}