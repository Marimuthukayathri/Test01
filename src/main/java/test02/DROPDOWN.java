package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


// Hai code is merged
// second commit

// third commit

public class DROPDOWN {
	
	
	By tex = By.xpath("//input[@type='text']");

	@Test
	
	public void main1 () {  
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("http://toolsqa.com/automation-practice-form");
		 
		WebElement ele = driver.findElement(By.id("continents"));
		
		Select sel = new Select(ele);
		
		//sel.selectByVisibleText("Europe"); 
	//	sel.selectByValue("Asia"); //*[@id="content"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[8]/input
			sel.selectByIndex(2); 
			
		System.out.println( ele.getText()); 
					
	}

}
