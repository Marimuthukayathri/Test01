package test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ch1 {
	
	By ph = By.xpath("//button[contains(@class,'content-toolbar-button content-toolbar-button-add-tree-node')][contains(.,'ADD ')]");
	By test  = By.xpath("//a[contains(@class,'item-name ng-star-inserted')][contains(.,'Placeholders Fileroom')]");
	By phname = By.xpath("//*[@id=\"placeholderNames\"]");
	By pnameadd = By.xpath("(//button[contains(text(),'Add')])[2]"); 
	
	
	
	public void cc(WebDriver dr) throws InterruptedException, IOException { 
		
		File file = new File("C:\\Users\\c906128\\Desktop\\Mari\\Book1.xlsx");
		
		FileInputStream fis = new FileInputStream(file);

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(4);

		int rowcount = sheet.getPhysicalNumberOfRows();

		int columncount = sheet.getRow(0).getLastCellNum();
		
		Actions act = new Actions(dr);
		
		Webdrwait wait = new Webdrwait();
		
		Action click = new Action();
		
		int i = 1; 
		
		String columnvalue = sheet.getRow(i).getCell(0).getStringCellValue();
		
		for( i=2; i<rowcount; i++) { 
			
			if(columnvalue.equals(sheet.getRow(i).getCell(0).getStringCellValue()))  {
				
				String columnvalue2 = sheet.getRow(i).getCell(1).getStringCellValue();
				
				 wait.drwait(dr, 20, ph);
					
					click.clkelemt(dr, ph);
					
					Thread.sleep(2000); 
					
					dr.findElement(By.xpath("(//button[starts-with(@class,'mat-menu-item ng-star-inserted')])[2]")).click();
					
					wait.drwait(dr, 20, phname);
					 
					dr.findElement(phname).sendKeys(columnvalue2);
					
					wait.drwait(dr, 20, pnameadd);
					
					click.clkelemt(dr, pnameadd);
					
					Thread.sleep(2000);
			}
		}
		
	}
	}


