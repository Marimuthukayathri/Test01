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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test; 
 
public class AddFR   {
  
	By email = By.id("username");
	By Pwd = By.id("password");
	By Logon = By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/div[4]/a");
	
	By search = By.xpath("/html/body/div[2]/manda-root/mrll-manda-app/manda-navigation-project/div/div[1]/manda-search-bar/div/div[3]/p-autocomplete/span/input");
	By Addph = By.xpath(
			"//button[starts-with(@class,'content-toolbar-button content-toolbar-button-add-tree-node')][contains(.,'ADD ')]"); 
	By test = By.xpath("//a[contains(@class,'item-name ng-star-inserted')][contains(.,'Project Lucy')]");
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
	
	By addfrbut = By.xpath("//button[contains(@class,'content-toolbar-button content-toolbar-button-fileroom')]");
	By addfrvalue = By.xpath("/html/body/div[2]/manda-root/mrll-manda-app/manda-navigation-project/div/div[2]/manda-content-v2-routing-wrapper/manda-content/div/div[2]/div/div/div/manda-content-toolbar/div/manda-addfileroom-button/manda-add-fileroom-dialog/manda-modal/p-dialog/div/div[2]/div/input");
	By addfr = By.xpath("//button[contains(@class,'btn btn-xl btn-primary')][contains(text(),'Add')]");
	
	
	
	
	public static WebDriver dr;
	
	
	@Test  
	public void PH_001( ) throws InterruptedException, IOException, AWTException { 
		
	try  { 
			
		
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");

		dr = new ChromeDriver();

		dr.manage().window().maximize();
	
		dr.navigate().to("https://global.datasiteone.merrillcorp.com/manda/project/5d56e901ddd7320019b7dc0b/content/index");  
		
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

		XSSFSheet sheet = workbook.getSheet("Sheet2"); 
		
		int rowcount = sheet.getPhysicalNumberOfRows();

		int columncount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row Count is " + rowcount);

		System.out.println("Column Count is " + columncount);
		
	//	Actions act = new Actions(dr);
		
		//Actions dd = new Actions(dr);

	  
	 
			Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_T);

		    Set<String> handles = dr.getWindowHandles();
		    List<String> handlesList = new ArrayList<String>(handles);
		    String newTab = handlesList.get(handlesList.size() - 1);

		    // switch to new tab
		    dr.switchTo().window(newTab); 
		    
		    dr.get("https://global.datasiteone.merrillcorp.com/manda/project/5d56e901ddd7320019b7dc0b/content/index"); 
		    
		    Thread.sleep(10000);  

		int i ; 
		 
		for(i=1;i<rowcount; i++) { 
			
		String columnvalue = sheet.getRow(i).getCell(0).getStringCellValue();
		
		wait.drwait(dr, 20, addfrbut);

		click.clkelemt(dr, addfrbut); 

			
		wait.drwait(dr, 20, addfrvalue);

		dr.findElement(addfrvalue).sendKeys(columnvalue);
		
		
		wait.drwait(dr, 20, addfr);

		click.clkelemt(dr, addfr); 
		
		Thread.sleep(5000);
				
		System.out.println(i);
			
		}
		   
		System.out.println("All the File Rooms are added!! ");
		

	} catch (NullPointerException e) {
			
			e.getMessage();
		}
	
	
	System.out.println("Test is Completed");
		
   }
	
}
