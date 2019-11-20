package test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class manojdp {
	
	public static WebDriver dr;
	
	By Login = By.xpath("//*[@id=\"signup\"]/div[3]/a"); 
	By email = By.id("txtLUNm");
	By pwd   = By.id("txtLPass");
	By Logon = By.id("btnlogon");
	
    @Test(dataProvider="dp")
    
    public void Tc001(String url, String userName, String PAssword) throws InterruptedException, IOException
    
    {
         
   
    		System.setProperty("webdriver.chrome.driver","C:\\Marimuthu\\PC Data\\Downloadsss\\chromedriver_win32\\chromedriver.exe");
    		dr = new ChromeDriver();
    		dr.manage().window().maximize();
    		dr.get(url); 
	        
	         wdw wa = new wdw();
	         Action a = new Action();
	        	         	       
	         wa.webdrwait(dr, 20, Login);
	         a.clkelemt(dr, Login);
	         wa.webdrwait(dr, 20, email);
	        
	         dr.findElement(email).sendKeys(userName);
	         wa.webdrwait(dr, 20, pwd);
	         //d.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
	         //Thread.sleep(3000);
	         dr.findElement(pwd).sendKeys(PAssword);
	         wa.webdrwait(dr, 20, Logon);
	         dr.findElement(Logon).click();
	         System.out.println("Login was successful"); 
    	
    }
    
    @DataProvider(name = "dp")
    
    public Object[][] readDataFromExcel() throws IOException
    {

    	
    	File file = new File("C:\\Users\\Marimuthu C\\Documents\\icdata.xlsx");
         
         FileInputStream fileIpStream = new FileInputStream(file);
         
         @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fileIpStream);
         
         XSSFSheet sheet = workbook.getSheetAt(1);
         
         DataFormatter df = new DataFormatter(); 
         
         int rowcount = sheet.getPhysicalNumberOfRows();
         
         int columncount = sheet.getRow(0).getLastCellNum();
         
         System.out.println("Row Count is " +rowcount);
         
         System.out.println("Column Count is " +columncount);
         
         Object[][] object = new Object [rowcount-1][columncount];
	           
         int rowCounter = 0;
         Iterator<Row>rowIterator = sheet.iterator();
         
      //  rowIterator.next();
		//boolean firstRow = true;
         
         while(rowIterator.hasNext())
         {
               Row currentRow = rowIterator.next();
              


        /*if(firstRow)
               {
                    
                   firstRow = false;
                    continue;
               }
         */
        
               
         Iterator<Cell>cellIterator = currentRow.iterator();
         
         int colCounter = 0;
      while (cellIterator.hasNext()) {
         
          Cell cell = cellIterator.next();
      
                   
	          String cellValue =df.formatCellValue(cell);
	          System.out.print(cellValue + "\t");
	          System.out.println();
	       
	      
      
        
         
         switch (cell.getCellType()) {
         
              case 1:
                  object[rowCounter][colCounter] = cell.getStringCellValue();
                  
                  break;

              case 0:
                  object[rowCounter][colCounter] =  new Double(cell.getNumericCellValue()).intValue();
                  break;
      
                  
         
         }
          colCounter++;
      }
      rowCounter++;
  
 }
         
         
  return object;

    }

    
}


