package test02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class handleframes {
	
	@Test
	
	public void frames () {
		
			 
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
			//d.get("https://www.softwaretestingclass.com/");
						
			d.get("https://fengyuanchen.github.io/datepicker/");
					 
		/*	List<WebElement> dropdown = d.findElements(By.tagName("select")); 
			System.out.println(dropdown.size());
			List<WebElement> elements = d.findElements(By.tagName("iFrame"));
			System.out.println(elements.size());
			*/
			
			List<WebElement> row = d.findElements(By.tagName("tr"));
			System.out.println(row.size());
			
			List<WebElement> date12 = d.findElements(By.tagName("td"));
			System.out.println(date12.size());
			/*
			List<WebElement> elements1 = d.findElements(By.tagName("a"));
			System.out.println(elements1.size());
			List<WebElement> checkboxes = d.findElements(By.xpath("//input[@type='checkbox']")); 
			System.out.println(checkboxes.size());
			List<WebElement>		textboxes = d.findElements(By.xpath("//input[@type='text']"));		 
			System.out.println(textboxes.size());
			//	int numberOfTags = elements.size();
			
			*/
	}

}
