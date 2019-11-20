package test02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class testngpgm {

	public static WebDriver driver;
	
	@Test
	public void actionsClass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
                //navigate to the required url where we could do drag and drop action
		driver.get("http://jqueryui.com/droppable/");
                //WebdriverWait is used to wait for a frame to be available. Once it is availble we switch to the frame to achieve our task 
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
                //To get source locator
		WebElement sourceLocator = driver.findElement(By.cssSelector("#draggable"));
                //To get target locator
		WebElement targetLocator = driver.findElement(By.cssSelector("#droppable"));
                //dragAndDrop(source, target) method accepts two parameters source and locator. 
                //used dragAndDrop method to drag and drop the source locator to target locator
		
		//action.clickAndHold(); //  String var = "cb";
		//  String strXpath = JMS_Utility.readJSONRepository(strBcFnFieldname, strSheet); 
		//	var = var.concat(strXpath.replaceAll("\\D+" ,"")); 
		// || checkbox.getAttribute("class").contains("ng-not-empty")
		
		action.dragAndDrop(sourceLocator, targetLocator).build().perform();
	}



}

/*  						       			
try {

	   Thread.sleep(1000);
    
} 

catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }

 }

*/




/*	List <WebElement> reportFields = dr.findElements(By.xpath("//span[starts-with(@class,'item-name ng-star-inserted')]"));
	WebElement target = dr.findElement(By.xpath("//a[contains(text(),'upload wizard - edit titles')]"));
																
for (int j = 0 ; j < reportFields.size(); j++) {  
    if (reportFields.get(j).getText().equals(columnvalue1)) {
       WebElement draggedFrom = reportFields.get(j);
       			Actions act = new Actions(dr);
                
       			act.dragAndDrop(draggedFrom, target).build().perform();
       			
       			
       			
       		List <WebElement> cb = dr.findElements(By.xpath("//span[contains(@class,'ui-chkbox-icon ui-clickable')]"));
       		
       		boolean checkstatus;
       		checkstatus=cb.get(j).isSelected();
       		if (checkstatus==true) {
       		
       			
       		System.out.println("Checkbox is unchecked");
       		}
       		else
       		{
       		System.out.println("Checkbox is already unchecked"); 
       		}
       		
       		////span[contains(@class,'ui-chkbox-icon ui-clickable')]
       //	 boolean bValue = false;
       	
        "//span[contains(@class,'ui-cell-data-icon ng-star-inserted fa fa-folder pointer')]"
       		
 

*/


/*	wa.webdrwait(dr, 20, search);

dr.findElement(search).sendKeys(columnvalue);

dr.findElement(srchbut).click();

Thread.sleep(5000); */ 


//	List <WebElement> list = dr.findElements(By.xpath("//ul[contains(@class,'ui-treenode-children ng-star-inserted')]//p-treenode[contains(@class,'ng-star-inserted')]")); 
//				 System.out.println("Number of links: "+list.size());
//	for(int i = 0; i < list.size(); i++){
// System.out.println(list.get(i).getText());



/*   
else if (reportFields.get(k).getText().startsWith(columnvalue)) {
 	
       WebElement folder = reportFields.get(k); 
       			Actions a1 = new Actions(dr);
       		Thread.sleep(4000); 
                
       			a1.moveToElement(folder).click().perform(); 
       			Thread.sleep(5000); 
       			
       								    
    }
    
*/    
   

//WebElement folder = list.get(k);  

// 			Actions a1 = new Actions(dr);
 					                



/*

List oCheckBox = driver.findElements(By.name("tool"));

// This will tell you the number of checkboxes are present

int iSize = oCheckBox.size();

// Start the loop from first checkbox to last checkboxe

for(int i=0; i < iSize ; i++ ){

// Store the checkbox name to the string variable, using 'Value' attribute

String sValue = oCheckBox.get(i).getAttribute("value");

// Select the checkbox it the value of the checkbox is same what you are looking for

if (sValue.equalsIgnoreCase("toolsqa")){

oCheckBox.get(i).click();

// This will take the execution out of for loop

break;
 //		a1.moveToElement(folder).click().perform();
  * 
  *   int iSize = els.size();
				    
				    for(int l=0; l < iSize ; l++ ){
				    		
				        String sValue = els.get(l).getAttribute("value"); 
				        
				        if (sValue.equalsIgnoreCase("Titles")){

							
				    }
				    
				    String sValue = els.get(l).getAttribute("value");
				    
				}
				
					List <WebElement> fr = dr.findElements(By.xpath("//p-checkbox[contains(@name,'fileroomGroup')]")); 
				
				int s = fr.size();

				// Start the loop from first checkbox to last checkboxe

				for(int l=0; l< s ; l++ ){
					
					System.out.println("loop2");
					System.out.println(fr.get(l).getText());
					
				}
				
				
				List <WebElement> els1 = dr.findElements(By.xpath("//span[contains(@class,'ui-chkbox-icon ui-clickable fa fa-check')]"));
				
				
				List<String> strings = new ArrayList<String>();
				
				for(WebElement e : els1){
				    strings.add(e.getText());
				    
				}
				
						for(WebElement el : els1) {
					
					if(el.isSelected()){ 
					    el.click();
					}
					}
					
			
				
				
				
				
				List <WebElement> els = dr.findElements(By.xpath("//p-checkbox[contains(@class,'ng-untouched ng-pristine ng-valid')]"));
				
				for(WebElement cb:els) {
					
				
					//Boolean checkedStatus = false;
			
				if (cb.isSelected())
				{
				cb.click();
				}
				}
				
				int size = els.size();

				for(int v=0; v< size ; v++ ){
					
					System.out.println("loop1");
				System.out.println(els.get(v).getText());

				}
				
				
					List<String> strings = new ArrayList<String>();
				
				for(WebElement e : els){
				    strings.add(e.getAttribute("label")); 
				    
				    
				System.out.println(strings); 
				}
				// Store the checkbox name to the string variable, using 'Value' attribute

			//	for(int v=0; v< size ; v++ ){
			/*	String sValue = els.get(v).getAttribute("label");
				
				System.out.println("loop3");
				System.out.println(sValue); 
				
				// Select the checkbox it the value of the checkbox is same what you are looking for

				if (sValue=="Titles"){

				els.get(v).click();

				
				}
				}

			List<WebElement> els = dr.findElements(By.xpath("//p-checkbox[contains(@class,'ng-untouched ng-pristine ng-valid')]"));
			//	List<WebElement> els = dr.findElements(By.xpath("//p-checkbox[contains(@name,'fileroomGroup')]"));
				
				
				int size = els.size();
				
				System.out.println(size); 
				
				  for(int v=0; v<size ; v++ ) {
					  
					els.get(1).click();
					//  System.out.println("loop1");
						System.out.println(els.get(v).getText());
						
				  }
				
	
				*
				*
				*	   
					
				  
				   String actual = "Titles"; 
				      
				   if (actual.equals(option.getText())) {
				            option.click();
				            break;
				        }
				        
				         List<String> text=new ArrayList<>();
 
				    for(int c=0; i<fcb.size(); i++){

				        //loading text of each element in to array all_elements_text
				        text.add(fcb.get(c).getText());

				        //to print directly
				        System.out.println(fcb.get(c).getText());
		 			int size = els.size();

					for(int v=1; v< size ; v++ ) {
						
						System.out.println(els.get(v).getText());
						
						Thread.sleep(3000);
											
					
				    }
			}
					List<WebElement> els1 = dr.findElements(path1);
					
					int s = els1.size();
					
					System.out.println(s); 
					
					for(int t=0; t< s-1 ; t++ ){
						
						String sValue = els1.get(t).getText();
						
					//	System.out.println(sValue); 
						
						String act = "Test01";
					
						 if (act.equals(sValue)) {  
							 
							 wa.webdrwait(dr, 15, path1); 
							 
							 a.act(dr, path1); 
							    
						            break;
						        }
						 }
					
 String MainWindow=dr.getWindowHandle();		
 		
	        // To handle all new opened window.				
	            Set<String> s1=dr.getWindowHandles();	
	            
	        Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                    dr.switchTo().window(ChildWindow);
	                    dr.close();		
	            }		
	        }		
	        // Switching to Parent window i.e Main Window.
	            dr.switchTo().window(MainWindow);					 
					
dr.findElement(By.xpath("(//input[contains(@class,'form-control ng-pristine ng-untouched search-icon ng-empty ng-valid ng-valid-required')])[2]")).sendKeys("Stephensysrole");
		
		Thread.sleep(2000); 
		
		
		dr.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		Thread.sleep(4000); 
		
		
		dr.findElement(By.xpath("//a[contains(@class,'ng-binding ng-isolate-scope')]")).click();
		
		Thread.sleep(4000); 
		
		dr.findElement(By.xpath("//label[contains(@for,'cb1171')][contains(@class,'tgl-btn pull-left')]")).click();
		
		Thread.sleep(4000); 
		
		dr.findElement(By.xpath("//span[contains(.,'Update And Close')]")).click();
		
		Thread.sleep(4000); 
		
		dr.findElement(By.xpath("//a[contains(@class,'ng-binding ng-isolate-scope')]")).click();
		
		Thread.sleep(4000); 
						
/*	
		 Alert simpleAlert = dr.switchTo().alert();
		 String alertText = simpleAlert.getText();
		 System.out.println("Alert text is " + alertText);

		 int size = els.size();

		System.out.println(size); 
		
		/* List<String> text=new ArrayList<>();
		 
		    for(int c=0; c<size; c++){

		        //loading text of each element in to array all_elements_text
		        text.add(els.get(c).getText());
		
		Thread.sleep(2000);
		
		    }
		 //   String text1  =  "arguments[0].style.visibility='visible';";
		    
		    
		    /*
		for(WebElement ee:els) {
			
			if(!ee.isSelected()) {
				
			
				els = dr.findElements(path); 
			
			js.executeScript("arguments[0].click();", els);
		
	/*	
		 Alert simpleAlert = dr.switchTo().alert();
		 String alertText = simpleAlert.getText();
		 System.out.println("Alert text is " + alertText);
		 simpleAlert.accept();
		 
		 
		
		// Alert alert = dr.switchTo().alert();
		 
		//	 alert.accept();			

			
			}
					
			}
		 simpleAlert.accept();
		 
		 String [] Headers = new String [columncount];
				
		            for (int j=0;j<columncount;j++) {
		                Headers[j] = sheet.getRow(i).getCell(0).getStringCellValue();
		                
		                
		       	try {

				if (columnvalue.isEmpty()) {
					System.out.println("No more column values");
				}
			} catch (NullPointerException e) {
				e.getMessage();
			}
               				
			String cv[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

			for (String element : cv) {
				if (columnvalue.equals(element)) {

					String s1 = "000";
					columnvalue = s1.concat(columnvalue).concat(" ").concat(columnvalue);
				}
			}
			String a="A";
    for (int i = 0; i < xssfSheet.getPhysicalNumberOfRows(); i++)
{
  CellReference cellReference = new CellReference(a+i);
    Row row = xssfSheet.getRow(cellReference.getRow());

        //your Logic
}for(var i = 0; i < data.length; i++) {
            if(arr[i] == data.category) {
              remove item here;
            }
          }
			
String [] distinctArray = new String[rowcount];
			 int count = 0;
			
			 for (int z = 0; z < Headers.length; z++) {
				  String temp = Headers[z];
				  String tempTwo = Headers[z + 1];

				  if (tempTwo == temp) {
				   count++;
				   distinctArray[i] = temp;
				  }
				 }
				 List<String> x = new ArrayList<String>(); 
				
	            for (i=1;i<rowcount-1;i++) {
	                x.add(sheet.getRow(i).getCell(0).getStringCellValue());
	                
	                Set<String> s = new LinkedHashSet<String>(x);  
	              //  System.out.println(s);  			
		 
		 */
		
		// Alert alert = dr.switchTo().alert();
		 
		//	 alert.accept();				
				
//*[@id="tree-root"]/ol/li[1]/div/div[3]

//*[@id="tree-root"]/ol/li[1]/div/div[3]/label
				
				
//System.out.println(list1.get(l).getText().substring(5));  
 

