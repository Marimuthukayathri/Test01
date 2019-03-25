package test02;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class pomdev  {


	public static WebDriver dr;
	String value1, value2;
	
	
		
		By logon = By.xpath("//*[@id=\"signup\"]/div[3]/a");
		By uname= By.name("Email");
		By pwd= By.id("txtLPass");
		By login = By.xpath("//*[@id=\"btnlogon\"]");
		By diaper = By.xpath("/html/body/div[6]/div[3]/div/div/div[1]/div[3]/ul/li[5]/a"); 
	//	By img = By.xpath("//*[@id=\"maindiv\"]/div[5]/div/div[1]/div[1]/a/img"); 
				
	 	  
	 	 @BeforeMethod
			     
		 
	     public void openBrowser() 
	     
	     {
	               System.setProperty("webdriver.chrome.driver","C:\\Marimuthu\\PC Data\\Downloadsss\\chromedriver_win32\\chromedriver.exe");
	                dr = new ChromeDriver();
	     }
	     
	           public void hitUrl() throws InterruptedException
	                     {
	        	   dr.manage().window().maximize();
	        	   dr.get("http://www.firstcry.com/");
	              
	              
	              	 
	     }
	                 
		     public void Login() throws InterruptedException, IOException
		     
	     { 
		    	 
		    System.out.println("Login" ); 	 
		    wdw wa = new wdw();
	        Action a = new Action();
	             	       
	         wa.webdrwait(dr, 20, logon);
	         a.act(dr, logon);
	         
	         Readexcel re = new Readexcel();
	         re.testt();
	         
	         wa.webdrwait(dr, 5, uname);
	        
	         dr.findElement(uname).sendKeys(re.value1);
	         
	         dr.findElement(pwd).sendKeys(re.value2);
	         a.act(dr, login);
 	         
		 	 
	     } 
		    
	 		     
		    
		    @Test  
		    
		    public void Tc_001 () throws InterruptedException, IOException {  
		    	
		    pomdev p = new pomdev();
		    p.hitUrl();
		    p.Login();
		    System.out.println("Purchase by Cash on Delivery - Scenario 1"); 	 
		    
		    Action a = new Action();
			Thread.sleep(5000);
			wdw w =new wdw();
			w.webdrwait(dr, 20, diaper); 
			
			//	WebElement ele = d.findElement(diaper);
			a.act(dr, diaper); 
	    	
	       //  dr.findElement(diaper).click();
	     	Thread.sleep(6000);
	     	dr.findElement(By.xpath("(//span[@class='sprite_list sprt'])[position()=49]")).click();
	     	Thread.sleep(6000);
	     	dr.findElement(By.xpath("(//span[@class='sprite_list sprt'])[position()=54]")).click();
	    	Thread.sleep(6000);
	    	
	    //	a.act(dr, img); 
	    	Thread.sleep(3000);
	    	
	    	dr.findElement(By.xpath("//*[@id=\"p_top_section\"]/div[1]/div[1]/div[3]/div[3]/div")).click();
	    	Thread.sleep(4000);
	    	
	    	dr.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/div[3]/span")).click();
	    	Thread.sleep(4000);
	    	dr.navigate().back();   
	    	Thread.sleep(4000);//*[@id="1205978"]
	    	
	        dr.findElement(By.xpath("//*[@id=\"1205978\"]")).click();
	        Thread.sleep(4000);
	        dr.findElement(By.xpath("//*[@id=\"p_top_section\"]/div[1]/div[1]/div[3]/div[3]/div")).click();
	        Thread.sleep(4000);
	    	dr.findElement(By.xpath("//*[@id=\"Cart_PlaceOrder\"]/div")).click();
	    	Thread.sleep(4000);
	    	dr.findElement(By.xpath("//*[@id=\"divPerviousAddress\"]/div[4]/input")).click();
	    	Thread.sleep(4000);
	    	
	    	Readexcel re = new Readexcel();
	    	re.testt();
	    	
	    	dr.findElement(By.name("ShipFirstName")).sendKeys(re.value3);
	    	Thread.sleep(4000);
	    	
	    	dr.findElement(By.xpath("//*[@id=\"AddressLine1\"]")).sendKeys(re.value4);
	    	Thread.sleep(4000);
	    	
	    	dr.findElement(By.xpath("//*[@id=\"AddressLine2\"]")).sendKeys(re.value5);
	    	Thread.sleep(4000);
	    	
	    	dr.findElement(By.xpath("//*[@id=\"AddressLine3\"]")).sendKeys(re.value6);
	    	Thread.sleep(4000);
	    	
	    	dr.findElement(By.xpath("//*[@id=\"ShipPinCode\"]")).sendKeys(String.valueOf(re.value7)); 
	    	Thread.sleep(4000);
	    	
	    	dr.findElement(By.id("ShipMobileNo")).sendKeys(String.valueOf(re.value8)); 
	    	   	 	
	    	Thread.sleep(4000);
	    	    	
	    	dr.findElement(By.xpath("//*[@id=\"radAddressType_Office\"]")).click();
	    	Thread.sleep(4000);
	    	
	    	dr.findElement(By.xpath("//*[@id=\"btnSubmitAdd\"]")).click();
	    	Thread.sleep(4000);
	    	
	    	dr.findElement(By.xpath("//*[@id=\"fpay\"]")).click();
	    	Thread.sleep(4000);
	    	dr.findElement(By.xpath("//*[@id=\"Cod\"]/div[1]")).click();
	    	Thread.sleep(4000);
	    	//dr.findElement(By.xpath("//*[@id=\"BtnCodPayNow\"]")).click();
	    	//Thread.sleep(4000);
		     }
	    		
	 //    boolean cbbut=dr.findElement(By.xpath("//a[@href= '/ami/6/0/1002494?age=0,1,2,3,4,5']")).isDisplayed();
	 //	   System.out.println(cbbut);
	
		    
		    
		    @AfterMethod
		    
		    public void aft() {
		    	
		    	
		    	System.out.println("end ");
		    }
		    
		    
	} 
	
	

