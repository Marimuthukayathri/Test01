package test02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class calling {
	
	public static WebDriver dr;
	
	
	public void call() {
		
		
		
	By foldclk = By.xpath("//a[starts-with(@class,'ng-star-inserted')]");
	
	List <WebElement> list1 = dr.findElements(foldclk);
	
	wdw wa = new wdw();
	
	Action a = new Action();
	
	
	int s1 = list1.size();

	for (int l = 0 ; l <s1; l++) {
		
			if (list1.get(l).getText().equals(null)) {  
					
				
				wa.webdrwait(dr, 10, foldclk);
				
				a.clkelemt(dr, foldclk); 
	
		}
		
	}
	}
}

