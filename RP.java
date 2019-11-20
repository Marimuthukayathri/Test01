package test02;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RP {
	
	WebElement textvalue = null;

	By email = By.id("username");
	By Pwd = By.id("password");
	By Logon = By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/div[4]/a");

	By search = By.xpath(
			"/html/body/div[2]/manda-root/mrll-manda-app/manda-navigation-project/div/div[1]/manda-search-bar/div/div[3]/p-autocomplete/span/input");
	By Addph = By.xpath(
			"//button[starts-with(@class,'content-toolbar-button content-toolbar-button-add-tree-node')][contains(.,'ADD ')]");

	By phname = By.xpath("//*[@id=\"placeholderNames\"]");
	By pnameadd = By.xpath("(//button[contains(text(),'Add')])[2]");
	By srchclr = By.xpath(
			"/html/body/div[2]/manda-root/mrll-manda-app/manda-navigation-project/div/div[1]/manda-search-bar/div/div[3]/p-autocomplete/span/input");
	By path = By.xpath("//label[contains(@class,'ui-chkbox-label ui-label-active ng-star-inserted')]");
	By fclk = By.xpath("//a[starts-with(@class,'ng-star-inserted')]");
	By path1 = By.xpath(
			"//span[@class='ui-cell-data-icon ng-star-inserted fa fa-folder pointer']/following::a[starts-with(@class,'ng-star-inserted')]");
	By cont = By.xpath("//label[contains(.,'Titles')]");
	By foldclk = By.xpath(
			"/html/body/div[2]/manda-root/manda-navigation-project/div/div[2]/manda-content-search/div/div[2]/div/div/manda-content-search-data-table/div/p-datatable/div/div[1]/div/div[2]/div/table/tbody/tr/td[3]/span/div/a");
	By cap = By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[2]");
	By Editlive = By.xpath("//button[contains(@class,'btn btn-secondary btn-sm btn-edit-live-permissions')]");
	By test = By.xpath("(//p-checkbox[contains(@class,'ng-untouched ng-pristine ng-valid')])[11]");
	By fr = By.xpath("//span[contains(text(),' Trinity 2017 ')]");
	
	By save = By.xpath("//button[contains(@class,'btn btn-primary btn-sm btn-save-permissions')][contains(text(),'SAVE')]");
	

	public static WebDriver dr;

	@Test  
	public void PH_001() throws InterruptedException, IOException, AWTException { 
		
	try  { 
			
		
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

		XSSFSheet sheet = workbook.getSheet("Sheet2"); 
		
		int rowcount = sheet.getPhysicalNumberOfRows();

		int columncount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row Count is " + rowcount);

		System.out.println("Column Count is " + columncount);
		
		Actions act = new Actions(dr);
		
		Thread.sleep(10000); 
		
		WebDriverWait w = new WebDriverWait(dr,20); 
		
			wait.drwait(dr, 20, test);
		    click.clkelemt(dr, test); 
		    
		    wait.drwait(dr, 20, Editlive);
		    click.clkelemt(dr, Editlive);  
		    
		//  wait.drwait(dr, 20, fr);   click.clkelemt(dr, fr);  Thread.sleep(2000); 
		    
		 //   dr.navigate().back();
		
		  
		    
		String view = "View";
		String viewprint = "View/Print";
		String viewprintdown = "View/Print/Download";
		String viewprintdownedit = "View/Print/Download/Edit";
		String hid = "Hidden";
		String temp1 = null;
		String temp2 = null;
	
		int i =1; 
		String columnvalue11 = null,columnvalue21 = null;
		String[] returnValues = null; 
		String apo = "'";

		
		while(i<rowcount) {
			
			
			String	columnvalue1 = sheet.getRow(i).getCell(1).getStringCellValue();
			String	columnvalue2 = sheet.getRow(i).getCell(2).getStringCellValue();
			String columnvalue3 = sheet.getRow(i).getCell(3).getStringCellValue();
			String	precolumn1 = sheet.getRow(i-1).getCell(1).getStringCellValue();
			String	precolumn0 = sheet.getRow(i-1).getCell(0).getStringCellValue();		
			String columnvalue0= sheet.getRow(i).getCell(0).getStringCellValue(); 
			
			System.out.println(i);
			
		//	columnvalue1 = columnvalue0 + columnvalue1;
			
		//	System.out.println(columnvalue1);
			
		//	precolumn1 = precolumn0 + precolumn1;
			System.out.println(precolumn1);
			
			
			int att=0;
			boolean res = false;
			
			while(att<=1) {
				
	try {
		
		if(columnvalue1.equalsIgnoreCase("") || columnvalue1.equalsIgnoreCase(" ")) { 
			columnvalue1=null; }
		
		if(columnvalue1.contains("'")) {  
			
				returnValues = columnvalue1.split("'");  
				 temp1 = returnValues[0];
				temp2 = returnValues[1];
				System.out.println(temp1+ "\n"+ temp2);  
		
			
				if (columnvalue2.equalsIgnoreCase("Fileroom")) {
					textvalue  = dr.findElement(By.xpath("//span[contains(@class,'folder-nav-tree-fileroom ng-star-inserted')][contains(text(),'"+temp1+"')][contains(text(),'"+temp2+"')]"));
					}
				
				else 	if (columnvalue2.equalsIgnoreCase("Folder")) {
						
						if (precolumn1.contains("'")) {
							
						String[]	Values = precolumn1.split("'");  
							 String temp3 = Values[0];
							 String	temp4 = Values[1];
							textvalue = dr.findElement(By.xpath("//span[contains(text(),'"+temp3+"')][contains(text(),'"+temp4+"')]/./following::span[contains(text(),'"+temp1+"')][contains(text(),'"+temp2+"')]"));
							} 		
						textvalue = dr.findElement(By.xpath("//span[contains(text(),'"+precolumn1+"')]/./following::span[contains(text(),'"+temp1+"')][contains(text(),'"+temp2+"')]"));
					
					} else if (columnvalue2.equalsIgnoreCase("Document")) {
						textvalue = dr.findElement(By.xpath("//span[contains(@class,'folder-nav-tree-document ng-star-inserted')][contains(text(),'"+temp1+"')][contains(text(),'"+temp2+"')]"));
						}  else if (columnvalue2.equalsIgnoreCase("Placeholder")) {
							textvalue = dr.findElement(By.xpath("//span[contains(@class,'folder-nav-tree-placeholder ng-star-inserted')][contains(text(),'"+temp1+"')][contains(text(),'"+temp2+"')]"));
							}  }
			

		else 
			
			if (columnvalue2.equalsIgnoreCase("Fileroom")) {
				textvalue = dr.findElement(By.xpath("//span[contains(@class,'folder-nav-tree-fileroom ng-star-inserted')][contains(text(),'"+columnvalue1+"')]"));
				
			
			} else 	if (columnvalue2.equalsIgnoreCase("Folder")) {
				
				if(precolumn1.contains(apo)) {
				
				textvalue = dr.findElement(By.xpath("//span[contains(text(),'"+columnvalue1+"')]")); } 
				
				else 
					
				textvalue = dr.findElement(By.xpath("//span[contains(text(),'"+precolumn1+"')]/./following::span[contains(@class,'folder-nav-tree-folder ng-star-inserted')][contains(text(),'"+columnvalue1+"')]"));
				
		
			} else if (columnvalue2.equalsIgnoreCase("Document")) {
				
				textvalue = dr.findElement(By.xpath("//span[contains(@class,'folder-nav-tree-document ng-star-inserted')][contains(text(),'"+columnvalue1+"')]"));
				}
			else if (columnvalue2.equalsIgnoreCase("Placeholder")) {
			
				textvalue = dr.findElement(By.xpath("//span[contains(@class,'folder-nav-tree-placeholder ng-star-inserted')][contains(text(),'"+columnvalue1+"')]"));
			}  
	
			System.out.println(columnvalue1);
			
			WebDriverWait waitForElement = new WebDriverWait(dr, 20);
		
			waitForElement.until(ExpectedConditions.visibilityOf(textvalue));
			
			Thread.sleep(2000);
	//		for(int v =0;v<textvalue.size(); v++) { 
			
		//	waitForElement.until(ExpectedConditions.visibilityOf(textvalue.get(v)));
		//	if(columnvalue2.equals("Fileroom") && !columnvalue3.equals(hid)) {
				
		//	if(textvalue.get(v).getText().endsWith(columnvalue1) || textvalue.get(v).getText().contains(columnvalue1)|| textvalue.get(v).getText().equals(columnvalue1) )  { 
				
		//		if( columnvalue2.equals("Fileroom") && columnvalue3.equals(viewprintdownedit) || columnvalue3.equals(viewprintdown) || columnvalue3.equals(viewprint) || columnvalue3.equals(view)) {
				
		//		act.moveToElement(textvalue.get(v)).click().perform();
		//	WebElement Chkboxstate = dr.findElement(By.xpath("//input[contains(@type,'checkbox')]")); 
			
		    	textvalue.click();
			    res=true;
			 Thread.sleep(2000);
			 break; 
			
	
	}	 catch (Exception e) { } 
			
			att++; 
			System.out.println("attempt = " +columnvalue1);
			
			
			columnvalue1 = columnvalue0 + columnvalue1;
			
				
			
		 } 	Assert.assertTrue(res);   
		 
		 	
			columnvalue3 = sheet.getRow(i).getCell(3).getStringCellValue();
			
			
			boolean res1 = false;
			
			while(att<2) {
		
				
	try {
			
			
			if(columnvalue3.equalsIgnoreCase("") || columnvalue3.equalsIgnoreCase(" ")) { 
				
				columnvalue3=null;
			} 
				
			if(columnvalue3.equalsIgnoreCase(viewprintdownedit)) { 
				
				dr.findElement(By.xpath("(//div[contains(@class,'permissions-widget-pills')])["+i+"]/label[4]")).click();
				
				Thread.sleep(1000); 
				res1=true;
				break;
				
			}  	else if(columnvalue3.equalsIgnoreCase(viewprintdown)) { 
				
				dr.findElement(By.xpath("(//div[contains(@class,'permissions-widget-pills')])["+i+"]/label[3]")).click();
				res1=true;
				
				Thread.sleep(1000); break;
				
			}  else if(columnvalue3.equalsIgnoreCase(viewprint)) { 
				
				dr.findElement(By.xpath("(//div[contains(@class,'permissions-widget-pills')])["+i+"]/label[2]")).click();
				res1=true;
				
				Thread.sleep(1000); break;
				
			}  else if(columnvalue3.equalsIgnoreCase(view)|| columnvalue3.equals("!View!") ) { 
				
				dr.findElement(By.xpath("(//div[contains(@class,'permissions-widget-pills')])["+i+"]/label[1]")).click();
				res1=true;
				
				Thread.sleep(1000); break;
				
			} else if(columnvalue3.equalsIgnoreCase(hid)) { 
				
				dr.findElement(By.xpath("(//label[contains(@class,'permissions-widget-circle')])["+i+"]")).click();
				res1=true;
				
				Thread.sleep(1000); break;
			}	
			
	}  	 catch (Exception e) { } 
	
	att++;  
	}   
			
			Assert.assertTrue(res1);   
			
			int  k=i+1;
			
			if(!sheet.getRow(k).getCell(2).getStringCellValue().equals("Folder") && sheet.getRow(k).getCell(2).getStringCellValue().equals("Document") ||
						sheet.getRow(k).getCell(2).getStringCellValue().equals("Placeholder") || sheet.getRow(k).getCell(2).getStringCellValue().equals("Special Media")) { 
					int count =i;
			
	   		for (k=i+1;k<rowcount;k++) {
	   			
	   			System.out.println("K = " +k);
	   			
	   			if(sheet.getRow(k).getCell(2).getStringCellValue().equals("Folder") || sheet.getRow(k).getCell(2).getStringCellValue().equals("Fileroom")){
						k--;
						break; }
	   		
	   			
	   			String columnvalue8 = sheet.getRow(k).getCell(2).getStringCellValue();
	   			String columnvalue7 = sheet.getRow(k).getCell(3).getStringCellValue();
	   			String columnvalue9 = sheet.getRow(i).getCell(3).getStringCellValue();
	   					
	   					if(columnvalue7.equalsIgnoreCase("") || columnvalue7.equalsIgnoreCase(" ")) { 
	   						
	   						columnvalue7=null;
	   						
	   					} 
	   					
	   				
	   			 if(columnvalue7.equals(columnvalue9)) {
	   				 
	   				 do {
	   						
	   				 System.out.println(" columnvalue7 = " +columnvalue9 + "and  columnvalue9 = " +columnvalue7 );
	   						break;	
	   							
	  //	if(sheet.getRow(k+1).getCell(2).getStringCellValue().equals("Folder") || sheet.getRow(k+1).getCell(2).getStringCellValue().equals("Fileroom")){ 	break; }
	   				 } while (columnvalue8.equals("Folder") || columnvalue8.equals("Fileroom"));				 
	   						
	   				}   	 
	   			 
	   			 else  if(!columnvalue7.equals(columnvalue9))  { 
	   					
	   					
	   					if(columnvalue7.equalsIgnoreCase(viewprintdownedit)) { 
	   						
	   						
	   						dr.findElement(By.xpath("(//div[contains(@class,'permissions-widget-pills')])["+k+"]/label[4]")).click();
	   						
	   						Thread.sleep(1000); 
	   						
   					}  	else if(columnvalue7.equalsIgnoreCase(viewprintdown)) { 
	   						
	   						dr.findElement(By.xpath("(//div[contains(@class,'permissions-widget-pills')])["+k+"]/label[3]")).click();
	   						
	   						Thread.sleep(1000);
	   						
	   					}  else if(columnvalue7.equalsIgnoreCase(viewprint)) { 
	   						
	   						dr.findElement(By.xpath("(//div[contains(@class,'permissions-widget-pills')])["+k+"]/label[2]")).click();
	   				
	   						Thread.sleep(1000);
	   						
	   					}  else if(columnvalue7.equalsIgnoreCase(view)|| columnvalue7.equals("!View!") ) { 
	   						
	   						dr.findElement(By.xpath("(//div[contains(@class,'permissions-widget-pills')])["+k+"]/label[1]")).click();
	   						
	   						Thread.sleep(1000);
	   						
	   					} else if(columnvalue7.equalsIgnoreCase(hid)) { 
	   						
	   						dr.findElement(By.xpath("(//label[contains(@class,'permissions-widget-circle')])["+k+"]")).click();
	   						
	   						Thread.sleep(1000); } }
	   					count++;
	   					}	 i =k;
			} 
			
			i++; 
		
	}
		
			
	} catch (Exception e) {  	e.getMessage();  }
  
	System.out.println("Test is Completed");
	
}

}
