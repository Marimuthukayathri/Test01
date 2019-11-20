package test02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class gmail {

	@FindBy(xpath=".//*[@id='gb_70']")  
	@CacheLookup
	WebElement signin; 

	@FindBy(xpath=".//*[@id='identifierId']") 
	@CacheLookup
	WebElement username; 
	
	@FindBy(how=How.XPATH,using=".//*[@id='identifierNext']/content/span")
	@CacheLookup
	WebElement next;
	
	@FindBy(xpath="//*[@id=\"password\"]/div[1]/div/div[1]/input") 
	@CacheLookup
	WebElement pwd; 
	
	@FindBy(how=How.XPATH,using="//*[@id='passwordNext']/content/span") 
	@CacheLookup
	WebElement next1;
	

	@FindBy(how=How.LINK_TEXT,using="Gmail")
	@CacheLookup
	WebElement gmail_link; 
	
	public static WebDriver d;
	
	
	public void login (String uid, String pass) throws InterruptedException 
	{
		
		
	signin.click(); 
	username.sendKeys(uid);
	next.click();
	Thread.sleep(3000);
	pwd.sendKeys(pass);
	next1.click();
	Thread.sleep(3000);
	gmail_link.click(); 
	}
}
	
	/*
	//	public void login() throws InterruptedException {
	
	public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Marimuthu C\\\\Documents\\\\chromedriver.exe");
			d = new ChromeDriver();
		//	WebDriver d = new FirefoxDriver();
			
			//expli e = new expli();
			
			d.get("https://www.google.co.in");
			d.manage().window().maximize();
			Thread.sleep(3000); 
			signin.click(); 
			Thread.sleep(3000);
			username.sendKeys("marimuthurevathi@gmail.com");
			Thread.sleep(3000);
			next.click(); 
			Thread.sleep(3000);
			pwd.sendKeys("96206aishwarya");
			Thread.sleep(3000);
			next1.click();
			Thread.sleep(3000);
			gmail_link.click(); 
			Assert.assertEquals("Gmail", "gmail"); 
}
}
*/		



