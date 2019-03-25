package test02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class browse12 { 

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Marimuthu\\\\PC Data\\\\Downloadsss\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.co.in");  
	//	((JavascriptExecutor)driver).executeScript("window.resizeTo(424, 368);");
		
		System.out.println(driver.manage().window().getSize());
		Dimension d = new Dimension(720,600);
		driver.manage().window().setSize(d);
		
	/*	JavascriptExecutor js = (JavascriptExecutor) d;  
		//js.executeScript(Script,Arguments);
		js.executeScript ("window.scrollBy (0, 450)", ""); //scroll down, value 4500 you can change as per your req

				
		WebElement ele = d.findElement(By.name("q"));
		ele.isDisplayed();
		
		Actions act = new Actions (d); // where driver is WebDriver type

		act.moveToElement(ele).perform();

		act.contextClick ().perform ();
			*/
		

	

		
	}

}
