package test02;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Listener {
	
	
	
	By	cust   =   By.xpath("//*[@id=\"__panel1-header\"]");  
	By	ic  =   By.xpath("//*[@id=\"__link5\"]");  
	By	button =   By.xpath("//*[@id=\"button6HRpLES0uK2kq5BjyIBruG_76-inner\"]"); 
	By sit = 	By.xpath("//input[contains(@id,'dropdownlistbox9096b21b4b484ab0b72169dedc6a63af_107-inner')]");
	By save = 	By.xpath ("//*[@id=\"buttontAYD5nbDAasuFS8lNSo59W_227-button-content\"]/bdi");
	
	
/*	private int retryCount = 0;
    private int maxRetryCount = 2;

    public boolean retry1 (ITestResult result) { 

       if (retryCount < maxRetryCount) {
              retryCount++;
              return true;
       }
              return false;
    }  */
		 
	
	@Test 
	public  void test1() throws InterruptedException   {
		 

	System.setProperty("webdriver.chrome.driver", "C:\\Marimuthu\\PC Data\\Downloadsss\\chromedriver_win32\\chromedriver.exe");
	WebDriver d = new ChromeDriver();
	d.manage().window().maximize();
	long start = System.currentTimeMillis();
	d.get("https://my332876.crm.ondemand.com/");
	long finish = System.currentTimeMillis();
	long total = finish - start; 
	System.out.println("Total time for loading URL is: " +total);
	d.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	d.findElement(By.id("USERNAME_FIELD-inner")).sendKeys("marimuthu.chelliah@idp.com");
	d.findElement(By.id("PASSWORD_FIELD-inner")).sendKeys("Robot@1234");
	d.findElement(By.xpath("//*[@id=\"LOGIN_LINK_CONTENT\"]")).submit();
	
	Action a = new Action();
	wdw wa = new wdw(); 
	wa.webdrwait(d, 20,cust);
	d.findElement(cust).click();
	wa.webdrwait(d, 20,ic);
	d.findElement(ic); 
	a.act(d,ic);  
	Thread.sleep(5000);
	d.findElement(button); 
	a.act(d, button);
	Thread.sleep(5000);
	
	
	
	/*
	
	System.out.println("Name of the button is:- " +text.getAttribute("name"));
	  
	  System.out.println("Id of the button is:- "+text.getAttribute("id"));
	  
	  System.out.println("Class of the button is:- " +text.getAttribute("class"));
	  
	  System.out.println("Invalid Attribute status of the button is:- "+text.getAttribute("status"));
	  
	  System.out.println("Label of the button is:- "+ text.getAttribute("aria-label"));
	  
	  */
	
	  
	//  WebElement ele = d.findElement(sit);
	//	ele.getText();  
	  
	// WebElement ele = d.findElement(By.xpath("//*[@id=\"dropdownlistboxkrZIJY5K9q6ICpVMmvcBOW_103-inner\"]"));  
	
	 
	  
	 //d.findElement(By.xpath("//div[@id='inputfieldM_sFkKNsTA4UoZrWN67OzM0_95']/div/input")).sendKeys("TT-Dev");//*[@id="inputfieldM_sFkKNsTA4UoZrWN67OzM0_95-inner"]
	 // d.findElement(By.xpath("//*[@id=\"inputfieldLWyfSsnU0q2KvNMYj1i3Xm_99-inner\"]")).sendKeys("Mari104");
	  //d.findElement(By.xpath("//*[@id=\"inputfielda95695b77f134092809d2eaede6b39ed_111-inner\"]")).sendKeys("Mari104reret@gmail.com"); 
		 
	 JavascriptExecutor js = (JavascriptExecutor)d;
	 js.executeScript("document.getElementById('inputfieldM_sFkKNsTA4UoZrWN67OzM0_95-inner').value='TT-Dev';");
	 Thread.sleep(2000);
	 js.executeScript("document.getElementById('inputfieldLWyfSsnU0q2KvNMYj1i3Xm_99-inner').value='Mari104';");
	 Thread.sleep(2000);
	 js.executeScript("document.getElementById('dropdownlistbox9096b21b4b484ab0b72169dedc6a63af_107-inner').value='India';");
	 Thread.sleep(2000);
	 js.executeScript("document.getElementById('inputfielda95695b77f134092809d2eaede6b39ed_111-inner').value='Mari104reret@gmail.com';");
	 Thread.sleep(2000); 
	 js.executeScript("document.getElementById('dropdownlistbox25430f7d1113203916133c41a6533ee6_153-inner').value='IELTS';");
	 Thread.sleep(2000); 
	 js.executeScript("document.getElementById('dropdownlistbox396ba05843629fdef382a911e712d9d1_157-inner').value='Hindi';");
	 Thread.sleep(2000); 
	 
	 d.findElement(save);
	 a.act(d, save); 
	 Thread.sleep(10000);
	 
	 
	 
	}
	
}
	 // WebElement SaveButton = d.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/section/div/div/div/div[3]/div/footer/div/div[2]/button[1]/span/span/bdi"));
	 // js.executeScript("arguments[0].click();", SaveButton); //*[@id="buttontAYD5nbDAasuFS8lNSo59W_227-button-inner"] 
	 // js.executeScript("document.getElementById('buttontAYD5nbDAasuFS8lNSo59W_227-button').click();"); 
	 
	 
		  
	/*  WebElement ele = d.findElement(sit); //*[@id="navigationitemz31_P8NjLqIyUQUYKpPBlm_231"] 
	 // ele.sendKeys("India");	  //*[@id="buttontAYD5nbDAasuFS8lNSo59W_227-button-content"]/bdi
	  Select site = new Select (ele); navigationitemz31_P8NjLqIyUQUYKpPBlm_231
	  site.isMultiple();
			  site.selectByIndex(6); 
	  */
	  
	/*  WebElement e1 = d.findElement(By.xpath("//*[@id=\"dropdownlistbox25430f7d1113203916133c41a6533ee6_153-inner\"]")); 
	  Select hdh = new Select(e1); 
	  hdh.selectByIndex(5); 
	  
	  WebElement e2 = d.findElement(By.xpath("//*[@id=\"dropdownlistbox396ba05843629fdef382a911e712d9d1_157-inner\"]")); 
	  Select lang = new Select(e2);
	  lang.selectByVisibleText("Hindi");  
	  
	  WebElement e3 = d.findElement(By.id("buttontAYD5nbDAasuFS8lNSo59W_227-menubutton-inner")); 
	  Select save = new Select(e3);
	  save.selectByVisibleText("Sava and Open");  
	  */
	  
	
	
	/*
	 @DataProvider(name = "dp")
	    
	    public Object[][] readDataFromExcel() throws IOException
	    {

	    	
	    	File file = new File("C:\\Users\\Marimuthu C\\Documents\\icdata.xlsx");
	         
	         FileInputStream fileIpStream = new FileInputStream(file);
	         
	         @SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fileIpStream);
	         
	         XSSFSheet sheet = workbook.getSheetAt(0); 
	         
	         DataFormatter df = new DataFormatter(); 
	         
	         int rowcount = sheet.getPhysicalNumberOfRows();
	         
	         int columncount = sheet.getRow(0).getLastCellNum();
	         
	         System.out.println("Row Count is " +rowcount);
	         
	         System.out.println("Column Count is " +columncount);
	         
	         Object[][] object = new Object [rowcount][columncount];
		           
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

*/

/*

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("Test is Started" +result.toString());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("Test is Successful " +result.toString());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("Test is Failed" +result.toString());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is Failed Within Success Percentage" +result.toString());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test is Started" +context.toString());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("Test is Finished" +context.toString());
	}

	
	
}
*/