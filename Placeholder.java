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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test; 

public class Placeholder  extends dataprov  {

	By email = By.id("username");
	By Pwd = By.id("password");
	By Logon = By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/div[4]/a");
	
	By search = By.xpath("/html/body/div[2]/manda-root/mrll-manda-app/manda-navigation-project/div/div[1]/manda-search-bar/div/div[3]/p-autocomplete/span/input");
	// /html/body/div[2]/manda-root/mrll-manda-app/manda-navigation-project/div/div[1]/manda-search-bar/div/div[3]/p-autocomplete/span/input 
	//		"//input[contains(@class,'nav-searchbar-searchbox-input ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted')]");
	By Addph = By.xpath(
			"//button[starts-with(@class,'content-toolbar-button content-toolbar-button-add-tree-node')][contains(.,'ADD ')]"); 
	By test = By.xpath("//a[contains(@class,'item-name ng-star-inserted')][contains(text(),'HOZ Medi Werk')]");
	By phname = By.xpath("//*[@id=\"placeholderNames\"]");
	By pnameadd = By.xpath("(//button[contains(text(),'Add')])[2]");
	By srchclr = By.xpath("/html/body/div[2]/manda-root/mrll-manda-app/manda-navigation-project/div/div[1]/manda-search-bar/div/div[3]/p-autocomplete/span/input");
	By path = By.xpath("//label[contains(@class,'ui-chkbox-label ui-label-active ng-star-inserted')]"); 
	By fclk = By.xpath("//a[starts-with(@class,'ng-star-inserted')]");
	By path1 = By.xpath(
			"//span[@class='ui-cell-data-icon ng-star-inserted fa fa-folder pointer']/following::a[starts-with(@class,'ng-star-inserted')]");
	By cont = By.xpath("//label[contains(.,'Titles')]");
	By foldclk = By.xpath(
			"/html/body/div[2]/manda-root/manda-navigation-project/div/div[2]/manda-content-search/div/div[2]/div/div/manda-content-search-data-table/div/p-datatable/div/div[1]/div/div[2]/div/table/tbody/tr/td[3]/span/div/a");
	By cap = By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[2]");
	//private String tgt1; 
	
	public static WebDriver dr;
	
	//html/body/div[1]/div/div/div/div[2]/form/div[3]/ul/li[12]/span[1]/span[1]/i
	@Test  (dataProvider="dp")
	public void PH_001( String SheetName, String FileRoom   ) throws InterruptedException, IOException, AWTException { 
		
	try  { 
			
		
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");

		dr = new ChromeDriver();

		dr.manage().window().maximize();
	
		dr.navigate().to("https://global.datasiteone.merrillcorp.com/manda/project/5cdd60ebf4ac110011407c79/content/index");  
		
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

		XSSFSheet sheet = workbook.getSheet(SheetName); 
		
		int rowcount = sheet.getPhysicalNumberOfRows();

		int columncount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row Count is " + rowcount);

		System.out.println("Column Count is " + columncount);
		
		Actions act = new Actions(dr);
		
		//Actions dd = new Actions(dr);

	/*
	
			Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_T);

		    Set<String> handles = dr.getWindowHandles();
		    List<String> handlesList = new ArrayList<String>(handles);
		    String newTab = handlesList.get(handlesList.size() - 1);

		    // switch to new tab
		    dr.switchTo().window(newTab); 
		    
		    dr.get("https://global.datasiteone.merrillcorp.com/manda/project/5cdd60ebf4ac110011407c79/content/index");  
		    
		    */

		    wait.drwait(dr, 20, test);

		click.clkelemt(dr, test); 

		
		int i=1 ; 
		
		while(i<rowcount) {
			
		
			String columnvalue = sheet.getRow(i).getCell(0).getStringCellValue();
						
			String cv[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

			for (String element : cv) {
				if (columnvalue.equals(element)) {

					String s1 = "000";
					columnvalue = s1.concat(columnvalue).concat(" ").concat(columnvalue);
				}
			}
			
			wait.drwait(dr, 20, search);
			
			Thread.sleep(1000);

			dr.findElement(search).sendKeys(columnvalue);

			act.sendKeys(Keys.ENTER).build().perform();

			Thread.sleep(1000);

			List<WebElement> els = dr.findElements(path);

			int size = els.size();

			for (int v=0; v<size; v++) {
				
				wait.drwait(dr, 10, path);
				click.clkelemt(dr, path);
			}

			wait.drwait(dr, 10, cont);

			click.clkelemt(dr, cont);

			Thread.sleep(1000);
			
			WebElement Fileroom1 = dr.findElement(By.xpath("//label[contains(.,'"+FileRoom+"')]"));
		
			Fileroom1.click();

			Thread.sleep(2000);

			List<WebElement> list1 = dr.findElements(fclk);

			for (int l = 0; l < list1.size(); l++) {

				if (list1.get(l).getText().endsWith(columnvalue))

				{
					wait.drwait(dr, 10, fclk);

					click.clkelemt(dr, fclk);

					break;
				}

			}

			wait.drwait(dr, 20, Addph);

			click.clkelemt(dr, Addph);

			Thread.sleep(2000); 

			dr.findElement(By.xpath("(//button[starts-with(@class,'mat-menu-item ng-star-inserted')])[2]")).click();
			
			String columnvalue1 = sheet.getRow(i).getCell(1).getStringCellValue();

			wait.drwait(dr, 20, phname);

			dr.findElement(phname).sendKeys(columnvalue1);

			act.sendKeys(Keys.ENTER).build().perform();
			
			int count = i;
			
			for (int k=i+1; k<rowcount; k++) {
				 
						String cv1[] = { "0001 1", "0002 2", "0003 3", "0004 4", "0005 5", "0006 6", "0007 7", "0008 8", "0009 9" };

						for (String element : cv1) {
							if (columnvalue.equals(element)) {
								columnvalue = columnvalue.substring(5);
								
							} 
							
						}    
				         	if (columnvalue.equals(sheet.getRow(k).getCell(0).getStringCellValue())) { 
						
					String columnvalue2 = sheet.getRow(k).getCell(1).getStringCellValue();
					
					wait.drwait(dr, 20, phname);
					
					dr.findElement(phname).sendKeys(columnvalue2);
					
					act.sendKeys(Keys.ENTER).build().perform();
					
					count++;
										
					}	
				} 
			
			wait.drwait(dr, 20, pnameadd);

			click.clkelemt(dr, pnameadd);

			Thread.sleep(1000);
					
	//		WebElement source = dr.findElement(By.xpath("//a[contains(@class,'item-name ng-star-inserted')][contains(.,'0004 6.4')]"));	 
				  
	//		WebElement target1 = dr.findElement(By.xpath("(//span[contains(.,'0000 6.5')])[2]"));
			
	//		 dd.dragAndDrop(source,target1).release().build().perform();
		
			 wait.drwait(dr, 10, search);

					dr.findElement(search).clear();
					
					i =count+1;
				
		System.out.println(i);
			
		}
		
		System.out.println("All the Place Holders are added in the File Room!! ");
		
}
		catch (NullPointerException e) {
			
			e.getMessage();
		}
	
//	dr.quit();
	
	System.out.println("Test is Completed");
		
   }
	
}