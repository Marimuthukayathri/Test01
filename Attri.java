package test02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Attri {

	
	public static WebDriver dr;
	
	By bySearchButton = By.className("form-search-icon");
	By email = By.name("username");
	By pwd = By.name("password");
	By Logon = By.xpath("/html/body/div/div[1]/div/div[2]/div/form/div[3]/div[2]/button");
		
	@Test
	public void mari() {
		
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
		
		WebElement SearchBtn = dr.findElement(bySearchButton);
		
		System.out.println("Invalid Name of the button is:- " +SearchBtn.getAttribute("name"));
		System.out.println("Invalid Id of the button is:- "+ SearchBtn.getAttribute("id"));
		System.out.println("Type of the button is:- "+ SearchBtn.getAttribute("type"));
		System.out.println("Attribute status of the button is:- "+ SearchBtn.getAttribute("ng-show"));
		System.out.println("Attribute status of the button is:- "+ SearchBtn.getAttribute("data-toggle"));
		System.out.println("Attribute status of the button is:- "+ SearchBtn.getAttribute("data-ng-click")); 
		
		
		
	}
	
	
}
