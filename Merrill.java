package test02;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


		public class Merrill {
		
		By email = By.id("username");
		By pwd = By.id("password");
		By Logon = By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/div[4]/a");
		By search = By.xpath("//input[contains(@class,'nav-searchbar-searchbox-input ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted')]");
		By ph = By.xpath("//button[contains(@class,'content-toolbar-button content-toolbar-button-add-tree-node')][contains(.,'ADD ')]");
		By test  = By.xpath("//a[contains(@class,'item-name ng-star-inserted')][contains(.,'Test01')]");
		By phname = By.xpath("//*[@id=\"placeholderNames\"]");
		By pnameadd = By.xpath("(//button[contains(text(),'Add')])[2]"); 
		By srchclr = By.xpath("/html/body/div[2]/manda-root/manda-navigation-project/div/div[1]/manda-search-bar/div/div[3]/p-autocomplete/span/input");
		By path = By.xpath("//p-checkbox[contains(@name,'fileroomGroup')]//span[starts-with(@class,'ui-chkbox-icon ui-clickable fa fa-check')]"); 
		By foldclk = By.xpath("//a[starts-with(@class,'ng-star-inserted')]");
		By path1 = By.xpath("//span[@class='ui-cell-data-icon ng-star-inserted fa fa-folder pointer']/following::a[starts-with(@class,'ng-star-inserted')]"); 
		
		public static WebDriver dr;
		
		
		
		@BeforeTest
		
		public void Beforetest () throws InterruptedException, IOException { 
			
			
			System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
			
			dr = new ChromeDriver();
			
			dr.manage().window().maximize();
			
			dr.navigate().to("https://dev-web.core.merrillcorp.com/manda/project/5ce64988ba886300144ab3f5/content/index"); 
		}
		
	
		@Test
		 
		public void PH_001 () throws InterruptedException, IOException { 
			
			
			
			File file = new File("C:\\Users\\c906128\\Desktop\\Mari\\Book1.xlsx");
			
			FileInputStream fis = new FileInputStream(file);

			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = workbook.getSheetAt(2);

			int rowcount = sheet.getPhysicalNumberOfRows();

			int columncount = sheet.getRow(0).getLastCellNum();

			System.out.println("Row Count is " + rowcount);

			System.out.println("Column Count is " + columncount);

			Actions act = new Actions(dr);
			
			wdw wa = new wdw();
			
			Action a = new Action();
			
			wa.webdrwait(dr, 20, email);
			
			dr.findElement(email).sendKeys("newdev@mailinator.com");
			
			wa.webdrwait(dr, 20, pwd);
			
			dr.findElement(pwd).sendKeys("Password1!");
			
			wa.webdrwait(dr, 20, Logon);
			
			a.clkelemt(dr, Logon);
			
			System.out.println("Login was successful");

			wa.webdrwait(dr, 20, test);
			
			a.clkelemt(dr, test);
			
			for (int i = 1; i <= rowcount-1; i++) {
				
				String columnvalue = sheet.getRow(i).getCell(0).getStringCellValue();
				
				wa.webdrwait(dr, 20, search);
				
				dr.findElement(search).sendKeys(columnvalue);	
				
				act.sendKeys(Keys.ENTER).build().perform();
				
				Thread.sleep(2000);
				
				List<WebElement> els = dr.findElements(path); 
				
				int size = els.size();

					for(int v=0; v<size ; v++ ) {
						
					
								   wa.webdrwait(dr, 10, path);
									a.clkelemt(dr, path); 
							   }
								   
					dr.findElement(By.xpath("//label[contains(.,'Content')]")).click();  
					
					Thread.sleep(1000); 
					
					dr.findElement(By.xpath("//label[contains(.,'FR 01')]")).click();  
					
					Thread.sleep(1000); 
			
					
					List <WebElement> list1 = dr.findElements(foldclk);
			 			
						 for (int l = 0 ; l < list1.size(); l++) {  
						
						if(list1.get(l).getText().equals(columnvalue))	 {
							
						wa.webdrwait(dr, 10, foldclk);
								
								a.clkelemt(dr, foldclk); 
					
								break;
						}
							else
						
						System.out.println("element not found"); 
					 
				 }	
							
				wa.webdrwait(dr, 20, ph);
				
				a.clkelemt(dr, ph);
				
				Thread.sleep(4000); 
				
				dr.findElement(By.xpath("(//button[starts-with(@class,'mat-menu-item ng-star-inserted')])[2]")).click();
				
				String columnvalue1 = sheet.getRow(i).getCell(1).getStringCellValue();
				
				wa.webdrwait(dr, 20, phname);

				dr.findElement(phname).sendKeys(columnvalue1);
				
				wa.webdrwait(dr, 20, pnameadd);
				
				a.clkelemt(dr, pnameadd);
				
				Thread.sleep(4000);
				
				wa.webdrwait(dr, 10, search); 
				
				dr.findElement(search).clear();
 				
				System.out.println(i);
			
			}
			
			System.out.println("All the Place Holders are added in the File Room!! ");
			
		}

		
		@Test
		 
		public void PH_002 () throws InterruptedException, IOException { 
			
			
			
			File file = new File("C:\\Users\\c906128\\Desktop\\Mari\\Book1.xlsx");
			
			FileInputStream fis = new FileInputStream(file);

			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = workbook.getSheetAt(1);

			int rowcount = sheet.getPhysicalNumberOfRows();

			int columncount = sheet.getRow(0).getLastCellNum();

			System.out.println("Row Count is " + rowcount);

			System.out.println("Column Count is " + columncount);

			System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
			
			dr = new ChromeDriver();
			
			dr.manage().window().maximize();
			
			dr.navigate().to("https://dev-web.core.merrillcorp.com/manda/project/5ce64988ba886300144ab3f5/content/index"); 
			
			Actions act = new Actions(dr);
			
			wdw wa = new wdw();
			
			Action a = new Action();
			
			wa.webdrwait(dr, 20, email);
			
			dr.findElement(email).sendKeys("newdev@mailinator.com");
			
			wa.webdrwait(dr, 20, pwd);
			
			dr.findElement(pwd).sendKeys("Password1!");
			
			wa.webdrwait(dr, 20, Logon);
			
			a.clkelemt(dr, Logon);
			
			System.out.println("Login was successful");

			wa.webdrwait(dr, 20, test);
			
			a.clkelemt(dr, test);
			
			for (int i = 1; i <= rowcount-1; i++) {
				
				String columnvalue = sheet.getRow(i).getCell(0).getStringCellValue();
				
				wa.webdrwait(dr, 20, search);
				
				dr.findElement(search).sendKeys(columnvalue);	
				
				act.sendKeys(Keys.ENTER).build().perform();
				
				Thread.sleep(3000);
				
				List<WebElement> els = dr.findElements(path); 
				
				int size = els.size();

					for(int v=0; v<size ; v++ ) {
						
					
								   wa.webdrwait(dr, 10, path);
									a.clkelemt(dr, path); 
							   }
								   
					dr.findElement(By.xpath("//label[contains(.,'Content')]")).click();  
					
					Thread.sleep(1000); 
					
					dr.findElement(By.xpath("//label[contains(.,'Test01')]")).click();  
					
					Thread.sleep(3000); 
			
					
					List <WebElement> list1 = dr.findElements(foldclk);
			 			
						 for (int l = 0 ; l < list1.size(); l++) {  
						
						if(list1.get(l).getText().endsWith(columnvalue))	  {
							
						wa.webdrwait(dr, 10, foldclk);
								
								a.clkelemt(dr, foldclk); 
					
								break;
						}
							else
						
						System.out.println("element not found"); 
					 
				 }	
							
				wa.webdrwait(dr, 20, ph);
				
				a.clkelemt(dr, ph);
				
				Thread.sleep(4000); 
				
				dr.findElement(By.xpath("(//button[starts-with(@class,'mat-menu-item ng-star-inserted')])[2]")).click();
				
				String columnvalue1 = sheet.getRow(i).getCell(1).getStringCellValue();
				
				wa.webdrwait(dr, 20, phname);

				dr.findElement(phname).sendKeys(columnvalue1);
				
				wa.webdrwait(dr, 20, pnameadd);
				
				a.clkelemt(dr, pnameadd);
				
				Thread.sleep(4000);
				
				wa.webdrwait(dr, 10, search); 
				
				dr.findElement(search).clear();
 				
				System.out.println(i);
			
			}
			
			System.out.println("All the Place Holders are added in the File Room!! ");
			
		}
		
		
		@AfterTest
		
		
		public void teardown()  {
			
			dr.close();
			
			
		}
		
		
}
		
		
		
