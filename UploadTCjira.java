package test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadTCjira {
	
	By email = By.id("username");
//	By Pwd = By.id("password");
	By Logon = By.xpath("//span[contains(@class,'css-t5emrf')]//span[contains(text(),'Continue')]");
	By fclk = By.xpath("//td[contains(@class,'summary')]//a[contains(@class,'issue-link')]"); 
	
	
	public static WebDriver dr;

	
	@Test
	public void TCC_01 (String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");

		dr = new ChromeDriver();

		dr.manage().window().maximize();
	
		dr.navigate().to("https://id.atlassian.com/login?continue=https%3A%2F%2Ftoppanmerrill.atlassian.net%2Flogin%3FredirectCount%3D1%26application%3Djira&application=jira");  
		
		File file = new File("C:\\Users\\c906128\\Desktop\\Sprint.xlsx");

		FileInputStream fis = new FileInputStream(file);
		//dataProviderClass=Dataprov.class
		
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("P1_Cases");  
		
		int rowcount = sheet.getPhysicalNumberOfRows();

		int columncount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row Count is " + rowcount);

		System.out.println("Column Count is " + columncount);
		
	//	Actions act = new Actions(dr);
		
		Webdrwait wait = new Webdrwait();

		Action click = new Action();
		
		wait.drwait(dr, 20, email);

		dr.findElement(email).sendKeys("vasanthsironmani@ToppanMerrillllc.com");

	//	wait.drwait(dr, 20, Pwd);

	//	dr.findElement(Pwd).sendKeys("Mathan@123");

		wait.drwait(dr, 20, Logon);

		click.clkelemt(dr, Logon);
		
		dr.findElement(By.xpath("//small[contains(text(),'VasanthSironmani@ToppanMerrillLLC.com')]")); 
		
		Thread.sleep(8000); 

		System.out.println("Login was successful");
		
		dr.findElement(By.xpath("//div[contains(text(),'Projects')]")); 
		
		Thread.sleep(2000); 
		
		dr.findElement(By.xpath("//p[contains(text(),'TCC')]")); 

		Thread.sleep(4000); 
		
		dr.findElement(By.xpath("//a[contains(@class,'test-summary-grids-labels')][contains(@title,'No Component')]")); 

		Thread.sleep(4000); 
		int i =1;
		
		String columnvalue = sheet.getRow(i).getCell(1).getStringCellValue();
		
		String columnvalue1 = sheet.getRow(i).getCell(2).getStringCellValue();
		
		String columnvalue2 = sheet.getRow(i).getCell(4).getStringCellValue();
		
		
		
		while(i<rowcount) {
			
			
		
		List<WebElement> list1 = dr.findElements(fclk);

		for (int l = 0; l < list1.size(); l++) {

			if (list1.get(l).getText().equals(columnvalue)) 
 
			{
				wait.drwait(dr, 10, fclk);

				click.clkelemt(dr, fclk);

				break;
			}

			Thread.sleep(8000); 	
		WebElement title = dr.findElement(By.xpath("//*[@id=\"summary-val\"]"));
		System.out.println(title.getText()); 
		
		int count = i;
		
		if (title.getText().equals(columnvalue)) { 
			System.out.println(title.getText());
			
			if(columnvalue==null) {
			
			dr.findElement(By.xpath("//textarea[contains(@id,'newstep')]")).sendKeys(columnvalue1); 
						Thread.sleep(4000);
			
			dr.findElement(By.xpath("//textarea[contains(@id,'newresult')]")).sendKeys(columnvalue2);  
						Thread.sleep(4000);
			dr.findElement(By.xpath("//img[contains(@title,'Add Steps')]")).click();
			Thread.sleep(5000);
			
			count++;
			
		} else if(columnvalue!=null) { 
			
		
			dr.navigate().back();
			
		}
			   
		
		}
		
		i = count+1;
	}

}

}
	
}
		