package test02;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login1 {
	
	public static WebDriver dr;
	
	By Login = By.xpath("//*[@id=\"signup\"]/div[3]/a"); 
	By email = By.id("txtLUNm");
	By pwd   = By.id("txtLPass");// txtLPass
	By Logon = By.id("btnlogon");
	
	
	
	 public void log () throws InterruptedException, IOException
	    
	    {
		 
		 	
		   System.setProperty("webdriver.chrome.driver","C:\\Marimuthu\\PC Data\\Downloadsss\\chromedriver_win32\\chromedriver.exe");
           dr = new ChromeDriver();
	        dr.get("https://www.firstcry.com"); 
	         wdw wa = new wdw();
	         Action a = new Action();
	        	         	       
	         wa.webdrwait(dr, 20, Login);
	         a.act(dr, Login);
	         wa.webdrwait(dr, 20, email);
	         Readexcel re = new Readexcel();
	         re.testt();
	         dr.findElement(email).sendKeys(re.value1);
	         wa.webdrwait(dr, 20, pwd);
	         //d.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
	         //Thread.sleep(3000);
	         dr.findElement(pwd).sendKeys(re.value2);
	         wa.webdrwait(dr, 20, Logon);
	         dr.findElement(Logon).click();
	         
	         
	         
}
}