package test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class valuecall {
	
	By email = By.id("username");
	By pwd = By.id("password");
	By Logon = By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/div[4]/a");
	By search = By.xpath(
			"//input[contains(@class,'nav-searchbar-searchbox-input ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted')]");
	By ph = By.xpath(
			"//button[starts-with(@class,'content-toolbar-button content-toolbar-button-add-tree-node')][contains(.,'ADD ')]"); 
	By test = By.xpath("//a[contains(@class,'item-name ng-star-inserted')][contains(.,'Placeholders Fileroom')]");
	By phname = By.xpath("//*[@id=\"placeholderNames\"]");
	By pnameadd = By.xpath("(//button[contains(text(),'Add')])[2]");
	By srchclr = By.xpath(
			"/html/body/div[2]/manda-root/manda-navigation-project/div/div[1]/manda-search-bar/div/div[3]/p-autocomplete/span/input");
	By path = By.xpath(
			"//p-checkbox[contains(@name,'fileroomGroup')]//span[starts-with(@class,'ui-chkbox-icon ui-clickable fa fa-check')]");
	By fclk = By.xpath("//a[starts-with(@class,'ng-star-inserted')]");
	By path1 = By.xpath(
			"//span[@class='ui-cell-data-icon ng-star-inserted fa fa-folder pointer']/following::a[starts-with(@class,'ng-star-inserted')]");
	By FileroomName = By.xpath("//label[contains(.,'Placeholders Fileroom')]");
	By cont = By.xpath("//label[contains(.,'Content')]");
	By foldclk = By.xpath(
			"/html/body/div[2]/manda-root/manda-navigation-project/div/div[2]/manda-content-search/div/div[2]/div/div/manda-content-search-data-table/div/p-datatable/div/div[1]/div/div[2]/div/table/tbody/tr/td[3]/span/div/a");

	By cap = By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[2]");
	
	//public static WebDriver dr;
	
	public void call(WebDriver dr) throws IOException, InterruptedException { 
		
		File file = new File("C:\\Users\\c906128\\Desktop\\Mari\\Book1.xlsx");

		FileInputStream fis = new FileInputStream(file);

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(4);

		int rowcount = sheet.getPhysicalNumberOfRows();

		int columncount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row Count is " + rowcount);

		System.out.println("Column Count is " + columncount);

		Actions act = new Actions(dr);

		Webdrwait wait = new Webdrwait();

		Action click = new Action();

		wait.drwait(dr, 20, email);

		dr.findElement(email).sendKeys("c906128");

		wait.drwait(dr, 20, pwd);

		dr.findElement(pwd).sendKeys("Mathan@123");

		wait.drwait(dr, 20, Logon);

		click.clkelemt(dr, Logon);

		System.out.println("Login was successful");

		wait.drwait(dr, 20, test);

		click.clkelemt(dr, test);

		int i=1;
		String columnvalue = sheet.getRow(i).getCell(0).getStringCellValue();
		
		String cv[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		for (String element : cv) {
			if (columnvalue.equals(element)) {

				String s1 = "000";
				columnvalue = s1.concat(columnvalue).concat(" ").concat(columnvalue);
			}
		}
		
		
		wait.drwait(dr, 20, search);

		dr.findElement(search).sendKeys(columnvalue);

		act.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);

		List<WebElement> els = dr.findElements(path);

		int size = els.size();

		for (int v = 0; v < size; v++) {
			wait.drwait(dr, 10, path);
			click.clkelemt(dr, path);
		}

		wait.drwait(dr, 10, cont);

		click.clkelemt(dr, cont);

		wait.drwait(dr, 10, FileroomName);

		click.clkelemt(dr, FileroomName);

		Thread.sleep(4000);

		List<WebElement> list1 = dr.findElements(fclk);

		for (int l = 0; l < list1.size(); l++) {

			if (list1.get(l).getText().endsWith(columnvalue))

			{
				wait.drwait(dr, 10, fclk);

				click.clkelemt(dr, fclk);

				break;
			}

		}

		wait.drwait(dr, 20, ph);

		click.clkelemt(dr, ph);

		Thread.sleep(2000); 

		dr.findElement(By.xpath("(//button[starts-with(@class,'mat-menu-item ng-star-inserted')])[2]")).click();
		
		String columnvalue1 = sheet.getRow(i).getCell(1).getStringCellValue();

		wait.drwait(dr, 20, phname);

		dr.findElement(phname).sendKeys(columnvalue1);

		act.sendKeys(Keys.ENTER).build().perform();
	}

}
