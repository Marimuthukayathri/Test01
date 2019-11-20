package frameworkCore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codoid.products.fillo.Recordset;

public class LoadDriver {

	public static RemoteWebDriver driver;

	
	// To load the driver based upon input provided in the excel as well as jenkins
	public static RemoteWebDriver invokeBrowser() {
		String strDriverQry;
		try {
			
			String strDrvJekins = System.getProperty("browser");
	
	if(strDrvJekins==null) 
		{
			strDriverQry = "Select * from Configuration";
			Recordset rs = DataConnections.qry_DataFile(strDriverQry);
			while (rs.next()) {
				ArrayList<String> arrFiledNames = rs.getFieldNames();
				for (String i : arrFiledNames) {
					if (i.contains("browser")) {
						if(rs.getField(i).equalsIgnoreCase("Chrome"))
								{
							System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
							ChromeOptions options = disable();
							driver = new ChromeDriver(options);
							break;
								}
						else
						{
							System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
							driver = new InternetExplorerDriver();
							break;
						}
					}
				}
			}
			
		}
	 else if(strDrvJekins.equals("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions options = disable();
			driver = new ChromeDriver(options);
		}
		else if(strDrvJekins.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	
		} catch (Exception e) {
			System.out.println(e +"Load Driver");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		try {
			strDriverQry = "Select * from Configuration";
			Recordset rs = DataConnections.qry_DataFile(strDriverQry);
			while (rs.next()) {
				ArrayList<String> arrFiledNames = rs.getFieldNames();
				for (String i : arrFiledNames) {
					if (i.contains("URL")) {
						driver.get(rs.getField(i));
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return driver;
	}

	public static void closeBrowser() {
		driver.quit();
	}
	
	// To disable the ChromeOptions
		public static ChromeOptions disable()
		{
			
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("safebrowsing.enabled", "true"); //this is the needed configuration
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			return options;
			
		}
		
		
	

}
