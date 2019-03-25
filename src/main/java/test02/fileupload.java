package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fileupload {

	public static WebDriver d;
	
			
		@Test 
		public  void test11()  {
			 

		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.navigate().to("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		d.findElement(By.name("photo")).sendKeys("C:\\Users\\Marimuthu C\\Documents\\Dynamic Xpath.xlsx");
		String color = d.findElement(By.cssSelector("#dynamicColor")).getCssValue("color");
		System.out.println(color); 
		
		  WebElement text = d.findElement(By.xpath("//h1[contains(.,'Webdriver Commands Example')]"));
		  
		  
		  System.out.println("Name of the button is:- " +text.getAttribute("name"));
		  
		  System.out.println("Id of the button is:- "+text.getAttribute("id"));
		  
		  System.out.println("Class of the button is:- " +text.getAttribute("class"));
		  
		  System.out.println("Invalid Attribute status of the button is:- "+text.getAttribute("status"));
		  
		  System.out.println("Label of the button is:- "+ text.getAttribute("aria-label"));
		  
		  String fontSize = text.getCssValue("font-size");
		  System.out.println("Font Size -> "+fontSize);
		  
		  //Read color property and print It In console.
		  
		  String fontColor = text.getCssValue("color");
		  System.out.println("Font Color -> "+fontColor);
		  
		  //Read font-family property and print It In console.
		  
		  String fontFamily = text.getCssValue("font-family");
		  System.out.println("Font Family -> "+fontFamily);
		  
		  //Read text-align property and print It In console.
		  
		  String fonttxtAlign = text.getCssValue("text-align");
		  System.out.println("Font Text Alignment -> "+fonttxtAlign);
		  
		
		
	/*
		
		driver.get("https://chercher.tech/selenium-webdriver-sample");
		String bgColor = driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]")).getCssValue("background-color");
		String color = driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]")).getCssValue("border-bottom-color");
		String borderBottomWidth = driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]")).getCssValue("border-bottom-width");
		System.out.println("Css Value for background color is : "+ bgColor);
		System.out.println("Css Value for color is : "+ color);
		System.out.println("Css Value for border bottom color is : "+ borderBottomWidth);
		
		
 		*/
		
		
	}
	
	
}
