package test02;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class addroles {

	
	
	By email = By.id("username");
	By Pwd = By.id("password");
	By Logon = By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/div[4]/a");
	
	By test = By.xpath("//span[contains(@class,'permissions-role-button-text')][contains(text(),'ADD ROLE')]"); // add role button 
	By Createtm = By.xpath("(//input[contains(@type,'text')])[2]");// addrolename
	By teamname = By.xpath("(//div[contains(@class,'ui-radiobutton-box ui-widget ui-state-default')])[2]"); // watermark
	By emailclk = By.xpath("//button[contains(@class,'btn btn-lg btn-primary add-new-role-btn')][contains(text(),'ADD')]"); // ADD
	
	
	public static WebDriver dr;
	
	
	@Test  
	public void PH_001() throws InterruptedException, IOException, AWTException { 
		
	
			
		
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");

		dr = new ChromeDriver();

		dr.manage().window().maximize();
	
		dr.navigate().to("https://datasiteone.merrillcorp.com/manda/project/5dd2a601e1dfde501ce9c68c/permissions");  
		
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
		
	
	
	    int i=1 ; 
	    for (i=1; i<rowcount; i++) {
	    	
	    	System.out.println(i);
	    	
	   	String columnvalue = sheet.getRow(i).getCell(0).getStringCellValue();
	   
	    wait.drwait(dr, 20, test);
	    click.clkelemt(dr, test);  
	    
	    Thread.sleep(2000);
	   	
	    	wait.drwait(dr, 20, Createtm);
		   dr.findElement(Createtm).sendKeys(columnvalue);
		   
		   Thread.sleep(1000);
		   
		   wait.drwait(dr, 20, teamname);
		    click.clkelemt(dr, teamname); 
		   
		   
		   wait.drwait(dr, 20, emailclk);
		    click.clkelemt(dr, emailclk);  
		    
		    Thread.sleep(2000); 
	    } 	
	}
	
}
