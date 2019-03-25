package test02;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Readexceldi {
	
	@SuppressWarnings("static-access")
	@Test
	
	public void er() {
	
	try {
        // Specify the path of file
        File src=new File("C:\\Users\\Marimuthu C\\Documents\\Dynamic Xpath.xlsx");
      
         // load file
         FileInputStream fis=new FileInputStream(src);
      
         // Load workbook
         XSSFWorkbook wb=new XSSFWorkbook(fis);
         
         // Load sheet- Here we are loading first sheetonly
            XSSFSheet sh1= wb.getSheetAt(0);
      
        // getRow() specify which row we want to read.
      
        // and getCell() specify which column to read.
        // getStringCellValue() specify that we are reading String data.
      
        //    int a=20; 
    	//	String s1=String.valueOf(a);
            
           double Value1 = sh1.getRow(1).getCell(0).getNumericCellValue();
      
            String Value2 = sh1.getRow(1).getCell(1).getStringCellValue();
      
    //       String a = String.valueOf(Value1);
      //      String b = String.valueOf(Value2);
            
            
            System.out.println(+Value1); 
            
            System.out.println(Value2); 
            
            
       
        } catch (Exception e) {
      
         System.out.println(e.getMessage());
      
        }
        
	}

}
