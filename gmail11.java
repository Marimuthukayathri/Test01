package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class gmail11 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
	//	WebDriver d = new FirefoxDriver();
				
		d.get("https://www.google.co.in");
		d.manage().window().maximize();
		
		d.findElement(By.xpath(".//*[@id='gb_70']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("c902581@gmail.com");
		Thread.sleep(3000);
		d.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("2019@Toppan");
		Thread.sleep(3000);

		d.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(3000);

		d.findElement(By.linkText("Gmail")).click();
		Thread.sleep(6000);


		
		
	}

}
