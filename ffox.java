package test02;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ffox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    
	        //Setting webdriver.gecko.driver property
	        System.setProperty("webdriver.gecko.driver", " C:\\Users\\Marimuthu C\\Documents\\Marimuthu\\geckodriver.exe");
	      


	        File pathToBinary = new File("C:\\Users\\Marimuthu C\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
	        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	        FirefoxProfile firefoxProfile = new FirefoxProfile();       
	        @SuppressWarnings("deprecation")
			WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);


	        
	        driver.get("http://artoftesting.com");
	        
	        //Closing the browser
	        driver.quit();
		
		
	}

}
