package test02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class chimth {

	By pat = By.xpath("//div[contains(@id,'tree-root')]/ol/li/div/div[3]/label");
	
	public void child (WebDriver dr) throws InterruptedException { 
		
		
List<WebElement> child = dr.findElements(pat); 

		System.out.println("Method is calling"); 

		
		int size = child.size();

		System.out.println(size); 
		
		for(WebElement c: child ) {
				
			if(!c.isSelected()) {
				
				
				c.click();
				
				child = dr.findElements(pat);
				
			}
					
			}
	
}

}