package test02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class Excelreader {
	
	
  @Test
  public void ER() throws IOException {

	  @SuppressWarnings("unused") 
	File src = new File();
	  
	  
	  FileInputStream fis=new FileInputStream("C:\\Marimuthu\\PC Data\\Dektop\\Automation\\login.xlsx");
	  
	  @SuppressWarnings("resource")
	XSSFWorkbook workbook=new XSSFWorkbook(fis);

      // Retrieving the number of sheets in the Workbook
      System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

      /*
         =============================================================
         Iterating over all the sheets in the workbook (Multiple ways)
         =============================================================
      */

      // 1. You can obtain a sheetIterator and iterate over it
      Iterator<Sheet> sheetIterator = workbook.sheetIterator();
      System.out.println("Retrieving Sheets using Iterator");
      while (sheetIterator.hasNext()) {
          Sheet sheet = sheetIterator.next();
          System.out.println("=> " + sheet.getSheetName());
      }
      
      DataFormatter dataFormatter = new DataFormatter();
     
      

     Sheet sheet1 = workbook.getSheetAt(0);

      // Create a DataFormatter to format and get each cell's value as String
      
      // 1. You can obtain a rowIterator and columnIterator and iterate over them
      System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
      Iterator<Row> rowIterator = sheet1.rowIterator();
      while (rowIterator.hasNext()) {
          Row row = rowIterator.next();

          // Now let's iterate over the columns of the current row
          Iterator<Cell> cellIterator = row.cellIterator();

          while (cellIterator.hasNext()) {
              Cell cell = cellIterator.next();
              String cellValue = dataFormatter.formatCellValue(cell);
              System.out.print(cellValue + "\t");
          }
          System.out.println();
      }
      
      
      Sheet sheet2 = workbook.getSheetAt(1);

      // Create a DataFormatter to format and get each cell's value as String
  
      // 1. You can obtain a rowIterator and columnIterator and iterate over them
      System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
      Iterator<Row> rowIterator1 = sheet2.rowIterator();
      while (rowIterator1.hasNext()) {
          Row row = rowIterator1.next();

          // Now let's iterate over the columns of the current row
          Iterator<Cell> cellIterator = row.cellIterator();

          while (cellIterator.hasNext()) {
              Cell cell = cellIterator.next();
              String cellValue = dataFormatter.formatCellValue(cell);
              System.out.print(cellValue + "\t");
          }
          System.out.println();
      }
      
            
      Sheet sheet3 = workbook.getSheetAt(2);

      
      // 1. You can obtain a rowIterator and columnIterator and iterate over them
      System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
      @SuppressWarnings("unused")
	Iterator<Row> rowIterator3 = sheet3.rowIterator();
      while (rowIterator3.hasNext()) {
          Row row1 = rowIterator3.next();

          // Now let's iterate over the columns of the current row
          Iterator<Cell> cellIterator1 = row1.cellIterator();

          while (cellIterator1.hasNext()) {
              Cell cell = cellIterator1.next();
              String cellValue = dataFormatter.formatCellValue(cell);
              System.out.print(cellValue + "\t");
          }
          System.out.println("\n");
      }
      
      
      
  }
  
}



      


