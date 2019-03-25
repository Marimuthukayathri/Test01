package test02;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test; 

	public class testc4ctrain extends base1  {
	
	By	cust   =   By.xpath("//*[@id=\"__panel1-header\"]");  
	By	path1  =   By.xpath("//a[@id='__link5' and @class='sapClientMShellLeftPaneLinkItem sapClientMShellLeftPaneSingleSubItem sapMLnk sapMLnkMaxWidth']"); 
	By	button =   By.xpath("//*[@id=\"button6HRpLES0uK2kq5BjyIBruG_76-inner\"]");
		 
		
	
	@Test 
	public  void test1()  {
		 

	System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
	WebDriver d = new ChromeDriver();
	d.manage().window().maximize();
	long start = System.currentTimeMillis();
	d.get("https://my332876.crm.ondemand.com/");
	long finish = System.currentTimeMillis();
	long total = finish - start; 
	System.out.println("Total time for loading URL is: " +total);
	d.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	d.findElement(By.id("USERNAME_FIELD-inner")).sendKeys("marimuthu.chelliah@idp.com");
	d.findElement(By.id("PASSWORD_FIELD-inner")).sendKeys("Robot@1234");
	d.findElement(By.xpath("//*[@id=\"LOGIN_LINK_CONTENT\"]")).submit();
	
	wdw wa = new wdw(); 
	Action a = new Action();
	
	wa.webdrwait(d, 40,cust);
	d.findElement(cust).click();
	
	@SuppressWarnings("unused")
	WebElement element = d.findElement(path1); 
	a.act(d, path1);  	
		
	WebElement text = d.findElement(button); //*[@id="button6HRpLES0uK2kq5BjyIBruG_76-img"] //*[@id="__button13-img"]
	
	System.out.println("Name of the button is:- " +text.getAttribute("name"));
	  
	  System.out.println("Id of the button is:- "+text.getAttribute("id"));
	  
	  System.out.println("Class of the button is:- " +text.getAttribute("class"));
	  
	  System.out.println("Invalid Attribute status of the button is:- "+text.getAttribute("status"));
	  
	  System.out.println("Label of the button is:- "+ text.getAttribute("aria-label"));
	
	  a.act(d, button);
	
	
	
}

}