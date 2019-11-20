package test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcel {
	
	  
	String value1, value2,value3,value4,value5,value6;
	double value7,value8;
	
	
	
	public void  testt() throws IOException {
		
	
		
		  // Specify the file path which you want to create or write
		 
		  File src=new File("C:\\Users\\Marimuthu C\\Documents\\Dynamic Xpath.xlsx");
		 
		  // Load the file
		 
		  FileInputStream fis=new FileInputStream(src);
		 
		   // load the workbook
		 
		   @SuppressWarnings("resource")
		   
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		 
		  // get the sheet which you want to modify or create
		 
		   XSSFSheet sh1= wb.getSheetAt(0);
		   
		   XSSFSheet sh2= wb.getSheetAt(1);
		   
		   XSSFSheet sh3= wb.getSheetAt(2); 
		   
		//   DataFormatter df = new DataFormatter(); 
		   
		   value1 = sh1.getRow(1).getCell(0).getStringCellValue();
		   value2 = sh1.getRow(1).getCell(1).getStringCellValue();
		   value3 = sh3.getRow(0).getCell(0).getStringCellValue();
		   value4 = sh3.getRow(1).getCell(0).getStringCellValue();
		   value5 = sh3.getRow(2).getCell(0).getStringCellValue();
		   value6 = sh3.getRow(3).getCell(0).getStringCellValue();
		   value7 = sh3.getRow(4).getCell(0).getNumericCellValue();
		   value8 = sh3.getRow(5).getCell(0).getNumericCellValue();
		   
		/*  
           Iterator<Row> rowIterator = sh3.rowIterator();
           while (rowIterator.hasNext()) {
               Row row = rowIterator.next();

               // Now let's iterate over the columns of the current row
               Iterator<Cell> cellIterator = row.cellIterator();

               while (cellIterator.hasNext()) {
                   Cell cell = cellIterator.next();
                   String cellValue = df.formatCellValue(cell);
                   System.out.print(cellValue + "\t");
               }
               System.out.println();
           }
		  
		   
		 // getRow specify which row we want to read and getCell which column
		 
		 System.out.println(value1+ "\n" +value2 + "\n" +value3+ "\n" +value4+ "\n" +value5+ "\n" +value6+ "\n" +value7+ "\n" +value8);
		 
		 //System.out.println("value2 is " +value2);
		 
		 System.out.println(sh2.getRow(0).getCell(0).getStringCellValue());
		 
		 System.out.println(sh2.getRow(0).getCell(1).getStringCellValue());
		 
		 System.out.println(sh2.getRow(0).getCell(2).getStringCellValue());
		 
		// here createCell will create column
		 
		// and setCellvalue will set the value
		 
		 sh3.getRow(0).createCell(2).setCellValue("Mari");
		 
		 sh3.getRow(0).createCell(3).setCellValue("Muthu");
		 
		 sh3.getRow(0).createCell(4).setCellValue("Mummy");
		 
		 System.out.println(sh3.getRow(0).getCell(2).getStringCellValue());
		 
		 System.out.println(sh3.getRow(0).getCell(3).getStringCellValue());
		 
		 System.out.println(sh3.getRow(0).getCell(4).getStringCellValue());
		 
	*/	 
		 
	
/*
	catch (Exception e) {

  e.getMessage();

}  */

	}
}