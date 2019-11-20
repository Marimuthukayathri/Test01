package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class getcolor {

	public static WebDriver driver;
	
		 @Test
		 
		 public void readFontProperty(){
			 
			 
			 System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				
				 driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
				
			  //Locate text string element to read It's font properties. //*[@id="post-body-4024384759750876807"]/div[1]/h1
				 
			  WebElement text = driver.findElement(By.xpath("//h1[contains(.,'Example Login Page')]"));
			  
			  //Read font-size property and print It In console. /html/body/div[4]/div[1]/div/div[2]/div[1]/div/h1[2]
			  
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
		
		 
	}

}
