package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;



public class iframes extends base1 {

	
	@Test (priority = 1)
	
	public void testframe() {
	
		 	driver.switchTo().frame(2);
		  
		 	WebElement e = driver.findElement(By.xpath("/html/body/h2"));  
	              
	        Assert.assertEquals("Title bar (top.html)", (e.getText()));
	        
	        driver.switchTo().defaultContent();
	        
	}
	        
	        @Test (expectedExceptions = { InvalidSelectorException.class }) 
	        
	        public  void set1 () {

	        	System.out.println("test01 " );
	        	
	        	driver.findElement(By.xpath("//*[@id='testmathan'")).click();
	        	
	        }
	        
	        
	        @Test (dependsOnMethods={"set1"})
	        
	        public  void set2 () {

	        	System.out.println("test02" );
	        	
	        }
	        
	        @Test (enabled = false)
	        public  void skiptest () {

	        	System.out.println("test03 " );
	        /*	 String a ="Skip Ignore Test";
	        	 if(a.equals("Skip Ignore Test")){
	        	 throw new SkipException("Skipping / Ignoring - Script not Ready for Execution ");
	        	 }else{
	        	 System.out.println("In else condition"); 
	        	 }
	        	 System.out.println("Out of the if else condition");
	        	 
	        	*/
	        	
	        }
	        
	}

	
	

