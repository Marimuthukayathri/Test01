package test02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class attrib {
	
	public static WebDriver dr;
	
		public static void main(String[] args) throws InterruptedException { 
		
		
			System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
			
			dr = new ChromeDriver();
			
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			dr.manage().window().maximize();
			
			dr.navigate().to("https://tccuatwebapp.azurewebsites.net/Home/Dashboard"); 
			
			wdw wa = new wdw();
			
			Action a = new Action();
			
		//	By bySearchButton = By.xpath("//input[contains(@class,'form-control ng-pristine ng-valid ng-empty ng-touched')]");
			By email = By.name("username");
			By pwd = By.name("password");
			By Logon = By.xpath("/html/body/div/div[1]/div/div[2]/div/form/div[3]/div[2]/button");
				
			
			wa.webdrwait(dr, 20, email);
			
			dr.findElement(email).sendKeys("qapmtest");
			
			wa.webdrwait(dr, 20, pwd);
			
			dr.findElement(pwd).sendKeys("Toppan@2");
			
			wa.webdrwait(dr, 20, Logon);
			
			a.clkelemt(dr, Logon);
			
			System.out.println("Login was successful");
			
			Thread.sleep(5000); 
			
			WebElement SearchBtn = dr.findElement(By.xpath("//*[@id=\"bucket\"]/div/div[2]/div[2]/span[1]/input"));
			
			System.out.println("Name of the button is:- " +SearchBtn.getAttribute("name"));
			System.out.println("Id of the button is:- "+ SearchBtn.getAttribute("id"));
			System.out.println("Class of the button is:- "+ SearchBtn.getAttribute("type"));
			System.out.println("Invalid Attribute status of the button is:- "+ SearchBtn.getAttribute("ngmodel"));
			System.out.println("Invalid Attribute status of the button is:- "+ SearchBtn.getAttribute("data-ng-class"));
			System.out.println("Invalid Attribute status of the button is:- "+ SearchBtn.getAttribute("checked")); 
			
			
	}

}
