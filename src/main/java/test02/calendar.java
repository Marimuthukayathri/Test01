package test02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class calendar {  
	
	@Test
	public void datepicker () {
	
	System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://jqueryui.com/datepicker/");
	
 	 driver.switchTo().frame(0);
	
	  driver.findElement(By.id("datepicker")).click();
	 
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 
	  WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
	 
	  List <WebElement> rows=dateWidget.findElements(By.tagName("tr"));
	 
	  List <WebElement> columns=dateWidget.findElements(By.tagName("td"));
	 
	  for (WebElement cell: columns){
	 
	   //Select 10th Date
	 
	   if (cell.getText().equals("32")){
	 
	   cell.findElement(By.linkText("10")).click();
	 
	   break;
	       }
	   
	     }
	
	   }
	}
