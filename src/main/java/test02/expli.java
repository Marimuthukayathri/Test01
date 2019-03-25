package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class expli {

		public void ex(WebDriver d, int time, By path) {
	
	WebDriverWait wait = new WebDriverWait (d, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(path));
	
	
		
}

}