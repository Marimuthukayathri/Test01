package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdrwait {
	
public void drwait (WebDriver dr, int time, By path) {
		
		WebDriverWait wait = new WebDriverWait (dr, 20); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(path));

}
}