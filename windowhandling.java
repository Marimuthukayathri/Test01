package test02;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class windowhandling {
	
	
	public static WebDriver dr;
	
	@Test
	
	public void wh() {
		
	
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
	dr = new ChromeDriver();
	dr.manage().window().maximize();
	
	dr.navigate().to("http://www.naukri.com/"); 
	dr.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS); 
	
	@SuppressWarnings("unused")
	String mainwindow = dr.getWindowHandle(); 
	
	Set<String> set = dr.getWindowHandles();
	
	Iterator<String> itr = set.iterator();
	
	while(itr.hasNext()) {
		String chw = itr.next();
		
		if(!mainwindow.equals(chw)) {
			
			dr.switchTo().window(chw);
			dr.close(); 
			}
	 else
			dr.switchTo().window(mainwindow);
		}
		}
}		
		
		
		
		
		
		
		
	
	
	
	
	


