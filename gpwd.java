package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class gpwd {
	
	public static WebDriver dr;
	

	public static void main(String[] args) throws InterruptedException {
		
				
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
		
		dr = new ChromeDriver();
		
		dr.manage().window().maximize();
		
		dr.navigate().to("https://tccuatwebapp.azurewebsites.net/Home/Dashboard"); 
		
		wdw wa = new wdw();
		
		Action a = new Action();
		
		By email = By.name("username");
		By pwd = By.name("password");
		By Logon = By.xpath("/html/body/div/div[1]/div/div[2]/div/form/div[3]/div[2]/button");
		
		wa.webdrwait(dr, 20, email);
		
		dr.findElement(email).sendKeys("test01");
		
		wa.webdrwait(dr, 20, pwd);
		
		dr.findElement(pwd).sendKeys("MerrillTCC_126"); 
		
		wa.webdrwait(dr, 20, Logon);
		
		a.clkelemt(dr, Logon);
		
		System.out.println("Login was successful");
		
		Thread.sleep(14000); 
		
		dr.findElement(By.xpath("//div[@class='top-menu']/ul/li[4]")).click();
		
		Thread.sleep(2000); 
		
		dr.findElement(By.xpath("//span[text()='User Management']")).click();
		
		Thread.sleep(2000); 
		
		dr.findElement(By.xpath("//span[contains(@class,'ng-scope')][contains(text(),'Generate Password')]")).click();
		
		Thread.sleep(2000); 
		
		dr.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys("test01");
		Thread.sleep(2000); 
		
		dr.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys(Keys.TAB); 
		Thread.sleep(2000); 
		
		
		By clk = By.xpath("//button[contains(@translate,'GeneratePasswordLabel')][contains(text(),'Generate Password')]");
		
		//a.sendKeys(Keys.TAB).build().perform(); 
		
	/*	WebElement myelement = dr.findElement(clk);
		JavascriptExecutor jse2 = (JavascriptExecutor)dr;
		
		jse2.executeScript("arguments[0].scrollIntoView()", myelement);  */
		
		staleclk.retryingFindClick(clk, dr); 
		Thread.sleep(5000); 
		
		 
		WebElement txt = dr.findElement(By.xpath("//input[contains(@data-ng-model,'randomPassword')]"));
		Thread.sleep(2000); 
		
		
		if(!txt.isDisplayed()) {   
			 txt.click(); }
			 Thread.sleep(3000); 
		String str = txt.getAttribute("value"); 
		System.out.println(str); 
		
	}

}
