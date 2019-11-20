package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {

	
		
		
		public void clkelemt (WebDriver dr, By path )  { 
			
			
			 Actions ac = new Actions(dr);
			 WebElement ele = dr.findElement(path);
			ac.moveToElement(ele).click().perform();


}
}