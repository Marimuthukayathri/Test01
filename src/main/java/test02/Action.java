package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {

	public void act (WebDriver d, By path )  { 
		
		
		 Actions ac = new Actions(d);
		 
		 WebElement ele = d.findElement(path);
		 
		 ac.moveToElement(ele).click().build().perform(); 
}

}
