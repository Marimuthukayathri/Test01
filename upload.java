package test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class upload {
	
	By email = By.id("username");
	By Pwd = By.name("passwd"); 
	By Logon = By.xpath("//span[contains(@class,'css-t5emrf')]//span[contains(text(),'Continue')]");
	By fclk = By.xpath("//p//a[contains(@class,'issue-link')]"); 
	
	By email1 = By.xpath("//input[contains(@name,'loginfmt')]");
	By next = By.xpath("//input[contains(@value,'Next')]");
	By Pwd1 = By.name("passwd");
	By signin = By.xpath("//input[contains(@value,'Sign in')]");
		
	By Teststep = By.xpath("//textarea[contains(@id,'newstep')]"); 
	By Testres = By.xpath("//textarea[contains(@id,'newresult')]");
 	By addstep = By.xpath("//img[contains(@title,'Add Steps')]"); 
 	
 //	By verify = By.xpath("//input[contains(@value,'Verify')]");
			
 	By project = By.xpath("//div[contains(text(),'Projects')]");
 	By tcc    = By.xpath("//p[contains(text(),'TCC')]");
 	By nocomp =  By.xpath("//a[contains(@class,'test-summary-grids-labels')][contains(@title,'No Component')]");  
 	
 	By srchtest = By.xpath("//div[contains(@class,'css-1nh7qlk')][contains(text(),'Search Tests')]"); 
 	
 	By clktestdet = By.xpath("//img[contains(@class,'sc-gqjmRU hczzIz')])[5]");
 	
	By delete = By.xpath("(//img[contains(@alt,'Delete')])[6]");
 	By confdel    = By.xpath("//button[contains(@class,'aui-button ap-aui-button ap-aui-dialog-button aui-button-primary')][contains(text(),'Delete')]"); 
 
	By cycsum = By.xpath("//a[contains(text(),'Cycle Summary')]"); 
	 
 	
 	public static WebDriver dr;

	
	@Test
	public void TCC_01 () throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();

		cap.setCapability("applicationCacheEnabled", "true");

		dr = new ChromeDriver(cap);

		dr.manage().window().maximize();
	
		dr.navigate().to("https://id.atlassian.com/login?continue=https%3A%2F%2Ftoppanmerrill.atlassian.net%2Flogin%3FredirectCount%3D1%26application%3Djira&application=jira");
		
		File file = new File("C:\\Users\\c906128\\Desktop\\Sprint.xlsx");

		FileInputStream fis = new FileInputStream(file);
			
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet2");  
		
		int rowcount = sheet.getPhysicalNumberOfRows();

		int columncount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row Count is " + rowcount);

		System.out.println("Column Count is " + columncount);
		
		Actions act = new Actions(dr);
		
		Webdrwait wait = new Webdrwait();

		Action click = new Action();
		
		wait.drwait(dr, 20, email);

		dr.findElement(email).sendKeys("marimuthuchelliah@ToppanMerrillllc.com");
	
		wait.drwait(dr, 20, Logon);

		click.clkelemt(dr, Logon);
		
		wait.drwait(dr, 20, email1);

		dr.findElement(email1).sendKeys("marimuthuchelliah@ToppanMerrillllc.com");
		
		wait.drwait(dr, 20, next);

		click.clkelemt(dr, next); 
		
		wait.drwait(dr, 20, Pwd1);

		dr.findElement(Pwd1).sendKeys("Mathan@111");

		wait.drwait(dr, 20, signin);

		click.clkelemt(dr, signin);  
		
		Thread.sleep(2000); 
		
		act.sendKeys(Keys.ENTER).build().perform();

	//	dr.findElement(By.xpath("//small[contains(text(),'VasanthSironmani@ToppanMerrillLLC.com')]")); 
		
	//	Thread.sleep(8000); 

		System.out.println("Login was successful"); 
				
		wait.drwait(dr, 20, project);

		click.clkelemt(dr, project);  

		wait.drwait(dr, 20, tcc);

		click.clkelemt(dr, tcc); 
		
		
		
		
		wait.drwait(dr, 20, srchtest);

		click.clkelemt(dr, srchtest);   

		Thread.sleep(10000); 
		
		int i =1;
		
		String columnvalue = sheet.getRow(i).getCell(1).getStringCellValue();
		String columnvalue1 = sheet.getRow(i).getCell(2).getStringCellValue();
		String columnvalue2 = sheet.getRow(i).getCell(4).getStringCellValue();
		
		while(i<rowcount) {
			
			columnvalue = sheet.getRow(i).getCell(1).getStringCellValue();
			
				List<WebElement> list1 = dr.findElements(fclk);
				
		
				for (int l = 0; l < list1.size(); l++) {

			if (list1.get(l).getText().endsWith(columnvalue))  
 
			{
				
				list1.get(l).click();
		
				break;
			}
		}
				
		Thread.sleep(8000); 	
		WebElement title = dr.findElement(By.xpath("//h1[contains(@data-test-id,'issue.views.issue-base.foundation.summary.heading')]"));  
		
		String Title = title.getText();
		System.out.println(title.getText()); 

			int count = i;
			
			dr.switchTo().frame(0);
			
			for(int k=i; k<rowcount; k++) {
				
				columnvalue = sheet.getRow(k).getCell(1).getStringCellValue();	
			
			if(columnvalue.equals(Title)) {  	
			
			System.out.println(k); 
			Thread.sleep(5000);
			columnvalue1 = sheet.getRow(k).getCell(2).getStringCellValue();
			columnvalue2 = sheet.getRow(k).getCell(4).getStringCellValue();
			wait.drwait(dr, 10, Teststep); 
			dr.findElement(Teststep).sendKeys(columnvalue1); 
			wait.drwait(dr, 10, Testres);
			dr.findElement(Testres).sendKeys(columnvalue2);
			wait.drwait(dr, 10, addstep);
			click.clkelemt(dr, addstep);
		//	Thread.sleep(5000);
			count++; 
			
			} 	else if (!columnvalue.equals(Title) ) {
				
				break;     
			} 	
			
			}
			 	
			Thread.sleep(5000); 
			dr.navigate().back();
			i = count;
		
		} 	
		System.out.println("Test is Completed");  
}	

}
	
