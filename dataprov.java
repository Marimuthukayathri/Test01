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
import org.testng.annotations.DataProvider;

public class dataprov {
	
	 @DataProvider(name = "dp")
	 public Object[][] readDataFromExcel() throws IOException {
	    	
		 File file = new File("C:\\Users\\c605094\\Documents\\Mathan_Desktop\\Mari\\Book1.xlsx");
		 
	         FileInputStream fileIpStream = new FileInputStream(file);
	         
	         @SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fileIpStream);
	         
	         XSSFSheet sheet = workbook.getSheet("Sheet1"); 
	         
	         DataFormatter df = new DataFormatter(); 
	         
	         int rowcount = sheet.getPhysicalNumberOfRows();
	         
	         int columncount = sheet.getRow(0).getLastCellNum();
	         
	         System.out.println("Row Count is " +rowcount);
	         
	         System.out.println("Column Count is " +columncount);
	         
	         Object[][] object = new Object [rowcount-1][columncount];
		           
	         int rowCounter = 0;
	         Iterator<Row>rowIterator = sheet.iterator();
	         
	      //  rowIterator.next();
			boolean firstRow = true;
	         
	         while(rowIterator.hasNext())
	         {
	               Row currentRow = rowIterator.next();
	              


	        if(firstRow)
	               {
	                    
	                   firstRow = false;
	                    continue;
	               }
	         
	        
	               
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
