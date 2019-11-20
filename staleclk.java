package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class staleclk {
 
public static void retryingFindClick (By path, WebDriver dr )  {
	wdw wa = new wdw();
	Action a = new Action();
	
		boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            
	       // 	WebDriverWait wait = new WebDriverWait (dr, 10);   
	       // 	 wait.until(ExpectedConditions.elementToBeClickable(path)); 
	       // 	dr.findElement(path).click();
	        	
	        	wa.webdrwait(dr, 20, path);
	    		a.clkelemt(dr, path);
	        	result = true;
	            break;
	            
	        } catch(StaleElementReferenceException e) {

	        	System.out.println(e.getMessage()); 
	        	
	        }
	        
	        attempts++;
	    }
	   
	}
	
}
