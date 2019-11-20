
package test02;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test; 

public class addemails {

	By email = By.id("username");
	By Pwd = By.id("password");
	By Logon = By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/div[4]/a");
	
	By test = By.xpath("//a[contains(text(),'Team Management')]");
	By Createtm = By.xpath("//button[contains(@class,'users-toolbar-button users-toolbar-button-create-team')]");
	By teamname = By.xpath("(//input[contains(@type,'text')])[2]");
	By emailclk = By.xpath("//div[contains(@class,'ui-multiselect-label-container')]");
	By emailtxt = By.xpath("(//input[contains(@class,'ui-inputtext ui-widget ui-state-default ui-corner-all')])[2]");
	By createuser = By.xpath("(//span[contains(text(),'Create Team')])[1]");
	By crtbut = By.xpath("//button[contains(text(),'CREATE')]"); 
	By cbclk = By.xpath("//ul[contains(@class,'ui-multiselect-items ui-multiselect-list ui-widget-content ui-widget ui-corner-all ui-helper-reset')]");
	
	
	public static WebDriver dr;
	
	
	@Test  
	public void PH_001() throws InterruptedException, IOException, AWTException { 
		
	
			
		
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");

		dr = new ChromeDriver();

		dr.manage().window().maximize();
	
		dr.navigate().to("https://datasiteone.merrillcorp.com/manda/project/5d6928f7cdbf8900186998f8/users/groups");  
		
	//	selenium.waitForPageToLoad("5000");
		
		Webdrwait wait = new Webdrwait();

		Action click = new Action();
		
		wait.drwait(dr, 20, email);

		dr.findElement(email).sendKeys("c906128"); 

		wait.drwait(dr, 20, Pwd);

		dr.findElement(Pwd).sendKeys("Mari@1234"); 

		wait.drwait(dr, 20, Logon);

		click.clkelemt(dr, Logon);

		System.out.println("Login was successful");
		
		
		File file = new File("C:\\Users\\c605094\\Documents\\Mathan_Desktop\\Mari\\Book1.xlsx");

		FileInputStream fis = new FileInputStream(file);
		//dataProviderClass=Dataprov.class
		
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet8"); 
		
		int rowcount = sheet.getPhysicalNumberOfRows();

		int columncount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row Count is " + rowcount);

		System.out.println("Column Count is " + columncount);
		
		Actions act = new Actions(dr);
	
		    wait.drwait(dr, 20, test);
		    click.clkelemt(dr, test); 
		    
		   
		    int i=1 ; 
		    while(i<rowcount) {
		    	
		    	System.out.println(i);
		    	
		   	String columnvalue = sheet.getRow(i).getCell(0).getStringCellValue();
		   	String columnvalue1 = sheet.getRow(i).getCell(1).getStringCellValue();
		  
		    wait.drwait(dr, 20, Createtm);
		    click.clkelemt(dr, Createtm);  
		    
		    Thread.sleep(2000);
		   	
		    wait.drwait(dr, 20, teamname);
			   dr.findElement(teamname).sendKeys(columnvalue);
			   
			   Thread.sleep(2000);
			   
			   wait.drwait(dr, 20, emailclk);
			    click.clkelemt(dr, emailclk);  
			    
			    Thread.sleep(2000); 
			    
						
			    wait.drwait(dr, 20, emailtxt);
			    dr.findElement(emailtxt).sendKeys(columnvalue1);
			    
			    Thread.sleep(2000); 
			    
			    wait.drwait(dr, 20, cbclk);
			    click.clkelemt(dr, cbclk);  
			    
			    Thread.sleep(1000); 
			    
			    wait.drwait(dr, 20, createuser);
			    click.clkelemt(dr, createuser);  
			  
			    
			    int k=i+1,count = i;
			    
			   
			   
			    
			 	for (k=i+1; k<rowcount; k++) {
			 		 
			 //		System.out.println("K = " +k);
			 		
			 		 if (columnvalue.equals(sheet.getRow(k).getCell(0).getStringCellValue())) { 
			 
	      		String columnvalue2 = sheet.getRow(k).getCell(1).getStringCellValue();
					
					 wait.drwait(dr, 20, emailclk);
					    click.clkelemt(dr, emailclk);  
					    
					    Thread.sleep(2000); 
					    
								
					    wait.drwait(dr, 20, emailtxt);
					    dr.findElement(emailtxt).sendKeys(columnvalue2);
					    
					    Thread.sleep(1000); 
					    
					    wait.drwait(dr, 20, cbclk);
					    click.clkelemt(dr, cbclk);  
					    
					    Thread.sleep(1000); 
					    
					    wait.drwait(dr, 20, createuser);
					    click.clkelemt(dr, createuser);  
					
					count++;
					
					} else {
						
						break; }
				} 
		    
			    Thread.sleep(1000); 
				
		   
		    wait.drwait(dr, 20, crtbut);
		    click.clkelemt(dr, crtbut);  
		    
			 i =count;
			 
			 i++;
		
		System.out.println(i);
		
	    }
		
		    System.out.println("Test is Completed");
   }
	
}
