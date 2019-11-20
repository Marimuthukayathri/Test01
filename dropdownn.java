package test02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownn {

	public static WebDriver dr;  //html/body/div[4]/div[1]/div/div[2]/div[1]/div/div[6]/div/form/table/tbody/tr[9]/td[2]
	
	public static void main(String[] args) {
		 
		    System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			
			dr.navigate().to("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
			
			WebElement ele = dr.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div/div[6]/div/form/table/tbody/tr[9]/td[2]/select"));
		    Select dd = new Select (ele);		   
		    
		    List <WebElement> eCount = dd.getOptions();
		    int iSize = eCount.size();
		    
		    for(int i =0; i<iSize ; i++){
		    String sValue = eCount.get(i).getText();
		    System.out.println(sValue);
		    
		    
		  }   
	 }
}
