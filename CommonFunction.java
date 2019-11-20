package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.google.common.base.Predicate;
import com.thoughtworks.selenium.Wait;

import frameworkCore.CustomReports;
import frameworkCore.DataConnections;
import frameworkCore.PerformAction;
import frameworkCore.Utility;

public class CommonFunction {

	private static final Object Null = null;
	public static RemoteWebDriver drivers;
	public static Alert alert;

	private static int i,orderCount=0;
	public static String strWkGrpdf, strLogin,strPwd,strDrpdnObjNm, strBcFnFieldValue1, filePath;
	public static File lastModifiedFile,lastModifiedFile1;

	// To get the page number from the JMS application
	public static void getpagenumber(List<WebElement> objActObj, RemoteWebDriver driver, String strBcFnFieldValueVf)

	{
		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");
		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];

		String strPageNm = objActObj.get(0).getText();
		strPageNm = strPageNm.trim();
		String[] strSptPNm = strPageNm.split("=");
		String strPageNm1 = strSptPNm[0];
		strPageNm = strSptPNm[1];
		System.out.println(strPageNm);
		System.out.println(strPageNm1);
		Utility.writeOutputData(strTestName, strFieldId, strPageNm);
		Utility.writeOutputData(strTestName, strFieldId+"ful", strPageNm1);
		
	}
	
   // To get the Job id from the JMS Application
	public static void getJobId(List<WebElement> objActObj, RemoteWebDriver driver, String strBcFnFieldValueVf) throws Throwable

	{

		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];

		List<String> jobnames = new ArrayList<String>();
		
		//int rowSize = objActObj.size();
		
		/*for (int i = 2; i < rowSize; i++)// 14
		{
			String jobName= objActObj.get(i).getText();
			System.out.println(jobName);
			jobnames.add(jobName);
		}*/

		int rowSize = objActObj.size();
		String jobName=null;
		for (int i = 2; i < rowSize; i++)// 14
		{
			List<WebElement> tds = objActObj.get(i).findElements(By.tagName("td"));
			try {
			 jobName = tds.get(1).getText();
			}catch(Exception e)
			{
				
			}
			System.out.println(jobName);
			jobnames.add(jobName);
		}
   
		int totalSize = jobnames.size();
		String strJobId = jobnames.get(totalSize - 1);
		System.out.println(strJobId);
		Utility.writeOutputData(strTestName, strFieldId, strJobId);
		Thread.sleep(5000);
	}

	// To get the Project id for the JMS Application
	public static void getprojectId(List<WebElement> objActObj, RemoteWebDriver driver, String strBcFnFieldValueVf)

	{
		drivers = driver;

		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];

		String strProjNm = objActObj.get(0).getText();

		String[] strTemp1 = strProjNm.split(" ");
		String strdummy = strTemp1[0];
		strProjNm = strTemp1[1];

		Utility.writeOutputData(strTestName, strFieldId, strProjNm);

	}
    
	// To get the Current Date
	public static void getCurrentDate(String strBcFnFieldValueVf)

	{
		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];
		String strCurDate = new SimpleDateFormat("MM/dd/yyy").format(new Date());
		System.out.println(strCurDate);
		Utility.writeOutputData(strTestName, strFieldId, strCurDate);
	}

	
	// For old JMS application - it is used for file upload[Sikuli]
	public static void actionOnuploadwd() throws FindFailed, InterruptedException, IOException {

		Screen sc = new Screen();
		Thread.sleep(8000);
		Pattern addButton = new Pattern("./src/test/resources/Add.PNG");
		sc.click(addButton);
		CustomReports.print_Report("INFO", "Perform Action", "Add button is clicked");

		Pattern lookIn1 = new Pattern("./src/test/resources/Lookin1.PNG");
		sc.click(lookIn1);
		sc.type("a", Key.CTRL);
		sc.type(Key.BACKSPACE);
		Pattern lookIn = new Pattern("./src/test/resources/Lookin.PNG");
		sc.type(lookIn, "C:\\Users\\111527\\git\\JMS_Automation_Suite\\src\\test\\resources");
		CustomReports.print_Report("INFO", "Perform Action", "File path is entered");

		Pattern setButton = new Pattern("./src/test/resources/Set.PNG");
		sc.click(setButton);
		CustomReports.print_Report("INFO", "Perform Action", "Set button is clicked");

		Pattern testDoc = new Pattern("./src/test/resources/Testdocument.PNG");
		sc.click(testDoc);
		CustomReports.print_Report("INFO", "Perform Action", "File is selected");

		Pattern okButton = new Pattern("./src/test/resources/Ok.PNG");
		sc.click(okButton);
		CustomReports.print_Report("INFO", "Perform Action", "Ok button is clicked");

		Thread.sleep(10000);
	}

	// To drive an unique workGroup name
	public static void getWorkGroupNm(String strBcFnFieldValueVf) throws FilloException {
		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];
		String strCurDate = new SimpleDateFormat("ddMMyymmss").format(new Date());
		System.out.println(strCurDate);
		String strWkGrp = "JmsSmoke_";
		String strWkGrpNm = strWkGrp.concat(strCurDate);
		Utility.writeOutputData(strTestName, strFieldId, strWkGrpNm);
	}

	//To drive an unique JMS Company Name
	public static void getCompanyNm(String strBcFnFieldValueVf) throws FilloException, InterruptedException {
		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];
		String strCurDate = new SimpleDateFormat("ddMMmmss").format(new Date());
		System.out.println(strCurDate);
		String strProject = "JmsSmoke_";
		String strProjectNm = strProject.concat(strCurDate);
		Utility.writeOutputData(strTestName, strFieldId, strProjectNm);
		Thread.sleep(2000);
	}

	
	//To Scroll Down the JMS Application
	public static void actiononscrldn(RemoteWebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	
	// To Refresh the JMS Page during Stamping process
	public static void actiononrefresh(RemoteWebDriver driver) throws IOException, InterruptedException

	{
		WebElement refrshBtn = driver.findElementByXPath("//*[text()='Refresh']");
		CustomReports.print_Report("INFO", "Perform Action", "Refresh button is clicked");
		for (int i = 1; i <= 500; i++) {
			refrshBtn.click();
			try {
				refrshBtn = driver.findElementByXPath("//button[text()='Refresh']");
				if (i == 500) {
					CustomReports.print_Report("FAIL", "Perform Action", "Stamping is not performed");
					break;
					//driver.close();
				}
			} catch (Throwable e) {
				try {
				driver.findElementByXPath("//button[text()='Next']").click();
				CustomReports.print_Report("INFO", "Perform Action", "Next button is clicked");
				break;
				}
				catch(Exception r)
				{
					PerformAction.strreexeFlg=false;
					CustomReports.print_Report("FAIL", "Perform Action", "Stamping is not performed");
				}
			}
		}
	}
 
	
	// For static Wait
	public static void actiononwait(RemoteWebDriver driver) throws Throwable

	{

		Thread.sleep(12000);
		System.out.println("waiting");

	}
	
	

   // To close the Window
	public static void actiononclose(RemoteWebDriver driver) {
		driver.close();
	}

	// To Handle the Alert pop up
	public static void actiononalert(RemoteWebDriver driver) {
		if (isAlertPresents(driver)) {
			alert.dismiss();
		}

	}
	
	// To Handle the Alert pop up
	public static void actionwithinalert(RemoteWebDriver driver) throws Throwable {
		if (isAlertPresents(driver)) {
			alert.accept();
			Thread.sleep(3000);
		}

	}

	public static boolean isAlertPresents(RemoteWebDriver driver) {
		try {
			alert = driver.switchTo().alert();
			return true;
		} // try
		catch (Exception e) {
			return false;
		} // catch

	}
	
    // To Go back to the Previous window
	public static void actiononwindback(RemoteWebDriver driver)

	{
		driver.navigate().back();
	}
	
	// To Go back to the Previous window
	public static void actiononwindback1(RemoteWebDriver driver)

	{
		driver.navigate().back();
	}

	// To Refresh the JMS Page for Approval Process
	public static void actiononpagerrf(RemoteWebDriver driver) throws IOException

	{
		String StrLnkNm = driver.findElementByXPath("//th[contains(text(),'State:')]//following::a").getText();
		int i = 1;
		while (!StrLnkNm.equals("Needs Approval")) {
			i++;
			driver.navigate().refresh();
			StrLnkNm = driver.findElementByXPath("//th[contains(text(),'State:')]//following::a").getText();
			if (i == 500) {
				CustomReports.print_Report("FAIL", "Perform Action", "Approval is not performed");
				driver.close();
			}

		}
		if (StrLnkNm.equals("Needs Approval"))
			CustomReports.print_Report("INFO", "Perform Action", "Status is changed to Needs Approval");
	}

	public static void actiononenter(RemoteWebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();

	}

	// To create a random CIK Number
	public static void getcik(String strBcFnFieldValueVf) {
		
		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];
		
		Random rand = new Random();
		long n = rand.nextInt(1000000000) + rand.nextInt(2000000000);
		String strCikNo = Integer.toString((int) n);
		strCikNo = strCikNo.replace('-', ' ').trim();
		if (strCikNo.length() == 9)
			strCikNo += '0';
		else if (strCikNo.length() == 8)
			strCikNo += "00";
		//return s;
		Utility.writeOutputData(strTestName, strFieldId, strCikNo);
	}
	
	// This is to handle login page when it is populated during the switch window
	public static void 	windswtjob(RemoteWebDriver driver) throws FilloException
	{
		try
		{
		   WebElement webelelgn = driver.findElementByXPath("//input[@name='login']");
		   WebElement webelePwd = driver.findElementByXPath("//input[@name='password']");
		   WebElement webelebtn = driver.findElementByXPath("//input[@value='Login']");
		 if(webelelgn.isDisplayed())
			 
		 {
			 String strDriverQry = " Select * from JMSlogin where BusinessFuntion = 'Login' AND TestCaseName = 'JMS_Smokesuite_ProjectCreation'";
				Recordset rs =DataConnections.qry_DataFile(strDriverQry);
				while(rs.next())
				{
					ArrayList<String> exlFieldNames = rs.getFieldNames();
					for (String i : exlFieldNames)
					{
						if(i.contains("txt_Login"))
							strLogin = rs.getField(i);
						if(i.contains("txt_Password"))
							strPwd = rs.getField(i);
					}
		 }
				
				webelelgn.sendKeys(strLogin);
			    webelePwd.sendKeys(strPwd);
			    webelebtn.click();		
	}
		}
		catch(Exception e)
		{
			System.out.println("Login page not found");
		}
		
	
	}

	// To get random Accnm Number
public static void getaccnm(String strBcFnFieldValueVf) {
	
	
	String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

	String strTestName = strTemp[0];
	String strFieldId = strTemp[1];

	Random rand = new Random();
	long lTendtg = rand.nextInt(1000000000) + rand.nextInt(2000000000);
	String strCikNo = Integer.toString((int) lTendtg);
	strCikNo = strCikNo.replace('-', ' ').trim();
	if (strCikNo.length() == 9)
		strCikNo += '0';
	else if (strCikNo.length() == 8)
		strCikNo += "00";
	
	
	String strCurYear = new SimpleDateFormat("yy").format(new Date());
	
	long lsixdgt = rand.nextInt(100000) + rand.nextInt(200000);//+ rand.nextInt(2000000000);
	String strSixdgt = Integer.toString((int) lsixdgt);
	strSixdgt = strSixdgt.replace('-', ' ').trim();
	if (strSixdgt.length() == 5)
		strSixdgt += '0';
	else if (strSixdgt.length() == 4)
		strSixdgt += "00";
	
	StringBuilder strAccNm = new StringBuilder(strCikNo);
	strAccNm.append("-").append(strCurYear).append("-").append(strSixdgt);
	
		
		
		Utility.writeOutputData(strTestName, strFieldId, strAccNm.toString());
	}
	
	
	
	
//To refresh the page during Submission Ready to Transmit
	public static void refreshonEdgar(RemoteWebDriver driver)
	{
		try
		{
		String statusNm = driver.findElementByXPath("//td[text()='Accession #']//following::td[6]").getText();
		int count=0;
		while((!statusNm.contains("Submission Ready to Transmit")) && (count<30))
		{
			driver.navigate().refresh();
			statusNm = driver.findElementByXPath("//td[text()='Accession #']//following::td[6]").getText();
			count++;
		}
		
	}catch(Exception e)
		{
		
		}
	}
	
	// To refresh the page during Edgar Submission
	public static void refreshonEdgarRt(RemoteWebDriver driver)
	{
		try
		{
		String statusNm = driver.findElementByXPath("//td[text()='Accession #']//following::td[7]").getText();
		int count=0;
		while((!statusNm.contains("Unknown")) && (count<50))
		{
			driver.navigate().refresh();
			statusNm = driver.findElementByXPath("//td[text()='Accession #']//following::td[7]").getText();
			count++;
		}
		
		if(count==50)
		{
			CustomReports.print_Report("FAIL", "Perform Action", "	Test w/EDGARLink Online via SEC* Funtionality is Failed");
		}
		else
		{
			CustomReports.print_Report("INFO", "Perform Action", "	Test w/EDGARLink Online via SEC* Funtionality validated succesfully");
		}
		
	}catch(Exception e)
		{
		
		}
	}
		
		
	// To refresh page during Sent Email process
public static void refreshonstate(RemoteWebDriver driver) throws IOException
{
	try
	{
	String strState = driver.findElementByXPath("//td[text()='State']//following::a").getText();
	
	while(!strState.contains("Sent"))
	{
		driver.navigate().refresh();
		strState = driver.findElementByXPath("//td[text()='State']//following::a").getText();
	}
	CustomReports.print_Report("INFO", "Perform Action", "Email Sent");
}catch(Exception e)
	{
	CustomReports.print_Report("FAIL", "Perform Action", "Email not sent");
	}
}
	
	
	
	
public static void actiononclick(RemoteWebDriver driver) throws IOException

{
	try
	{
	 driver.findElementByXPath("//a").click();
		} catch (WebDriverException e) {
			driver.findElementByXPath("//a").click();
			CustomReports.print_Report("INFO", "Perform Action", "Project linked is clicked");
		}
	}

// To Refresh the page
public static void actiononrefpage(RemoteWebDriver driver) throws IOException

{
	
driver.navigate().refresh();
	
	

}

public static void wait(RemoteWebDriver driver,List<WebElement> objActObj,String strBcFnClmFstNm) throws IOException

{
	
	WebDriverWait waitForElement = new WebDriverWait(driver, 10);
	if(strBcFnClmFstNm.equals("drpdn"))
	waitForElement.until(ExpectedConditions.visibilityOfAllElements(objActObj));
	else
	{
		//System.out.println("wait method");
	/*	if(strBcFnClmLstNm.equals("companyName"))
			System.out.println("test");*/
		waitForElement.until(ExpectedConditions.visibilityOf(objActObj.get(0)));

     }

}



// To check the Window ready state
public static boolean drvreadystate(RemoteWebDriver driver) throws Throwable
{
	
	try
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		while(!(js.executeScript("return document.readyState").toString().equals("complete"))) 
		{
			
			Thread.sleep(2000);
		}
		
		return true;
	}
	catch(Exception e)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int incwait=0;
		while(!(js.executeScript("return document.readyState").toString().equals("complete")) && (incwait<2)) 
		{
			
			Thread.sleep(5000);
			incwait++;
		}
		if((js.executeScript("return document.readyState").toString().equals("complete")))
				{
			return true;
				}
		else
		{
		System.out.println("Window is not in ready state" + e);
		return false;
		}
	}
	
	
	/*public static datepicker(RemoteWebDriver driver)
	{
		String strToday = new SimpleDateFormat("dd").format(new Date());

        //find the calendar
        WebElement dateWidget = driver.findElementsByXPath("(//table)[2]");
        List<WebElement> row=dateWidget.findElements(By.tagName("tr"));  
        for(int row=0;row<row.size;row++)
        {
       List<WebElement> columns=row.findElements(By.tagName("td")); 
       int columnsize=columns.size();
       for(int column=0;colum<columns.size;column++)
        {
       columns.get(column).getText().equal(
       
       }
        //comparing the text of cell with today's date and clicking it.
        for (WebElement cell : columns)
        {
           if (cell.getText().equals(strToday))
           {
              cell.click();
              break;
           }
        }
		
	}
	*/
	
	
}

// Sikuli
public static void  windclose() throws Throwable {

	Screen sc = new Screen();
	Thread.sleep(5000);
	Pattern closeBtn = new Pattern("./src/test/resources/winclose1.PNG");
	sc.click(closeBtn);
	CustomReports.print_Report("INFO", "Perform Action", "Window is closed");
    Thread.sleep(10000);
}

// For Print Site validation
public static void printsite(RemoteWebDriver driver) throws Throwable
{
	
	 WebElement objSite = driver.findElementByXPath("//strong[text()='Print Service Site:']//following::a");
	 String strSite =objSite.getText();
	 try
		{
	if(strSite.contains("Not Set"))
	{
		objSite.click();
		 Select objDrpSite = new Select(driver.findElementByXPath("//select[@name='newSite']"));
		 List<WebElement> objoptsite = objDrpSite.getOptions();
		 for (WebElement obj : objoptsite) {
			if( (obj.getText()).equals("CLGPS (Calgary Print Service)"))
			{
				obj.click();
				break;
			}
		}
		 driver.findElementByXPath("//input[@value='Change Site']").click();
	}
	else
	{
		System.out.println("Print Service Site already set");
	}
	
}catch(Exception e)
	{
	CustomReports.print_Report("FAIL", "Perform Action", "Print Service Site not set");
	}
	
}	



// For Comp Team validation
public static void compteam(RemoteWebDriver driver) throws Throwable
{

	String strTeamNm = driver.findElementByXPath("(//td[text()='Comp Team']//following::td)[12]").getText();
	
	if(strTeamNm.equals("NONE"))
	{
		
		driver.findElementByXPath("//a[text()='C1.1']").click();
		driver.findElementByXPath("//th[text()='Service Due:']//following::a").click();
		Select objCmpTm = new Select(driver.findElementByXPath("//select[@name='compTeam']"));
		 List<WebElement> objOpt = objCmpTm.getOptions();
		 for (WebElement obj : objOpt) {
			 if( (obj.getText()).equals("CHE"))
				{
					obj.click();
					break;
				}
			
		}
		 Select objFnCmpTm = new Select(driver.findElementByXPath("//select[@name='deliveryCompTeam']"));
		 List<WebElement> objopt = objFnCmpTm.getOptions();
		 for (WebElement obj : objopt) {
			 if( (obj.getText()).equals("CHE"))
				{
					obj.click();
					break;
				}
			
		}
		 
		 driver.findElementByXPath("//input[@name='saveButton']").click();
		 driver.findElementByXPath("//a[@id='breadCrumbLink2']").click();
		 
	}
	else
	{
		System.out.println("Comp Already Selected");
	}
	
	
	
}

// To get last modified File
public static void getLstFleFrmDir(String strBcFnFieldValue) throws Throwable
{
	Thread.sleep(8000);
	strBcFnFieldValue = strBcFnFieldValue.substring(strBcFnFieldValue.indexOf('-')+1,strBcFnFieldValue.length());
	
	strBcFnFieldValue1 = strBcFnFieldValue + "-jms";

    System.out.println(strBcFnFieldValue1);
    
    String dirPath = "C:\\jms";
    File dir = new File(dirPath);
    File[] files = dir.listFiles();
    if (files == null || files.length == 0) {
        System.out.println("Null"); 
    }

    lastModifiedFile = files[0];
   
    for (int i = 1; i < files.length; i++) {
       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
           lastModifiedFile = files[i];
    }}
    System.out.println(lastModifiedFile);

       File[] files1 = lastModifiedFile.listFiles();
              lastModifiedFile1 = files1[0];
       for (int j = 1; j < files1.length; j++) {
	       if (lastModifiedFile1.lastModified() < files1[j].lastModified()) {
	           lastModifiedFile1 = files1[j];
	       }
   }
    
       System.out.println(lastModifiedFile1);
       
       File[] files2 = lastModifiedFile1.listFiles();
       lastModifiedFile = files2[0];
for (int k = 1; k < files2.length; k++) {
    if (lastModifiedFile.lastModified() < files2[k].lastModified()) {
        lastModifiedFile = files2[k];
    }
}

System.out.println(lastModifiedFile);
       
   //File(or directory with old name)
  File file = new File(lastModifiedFile +"\\aJMSTestdoc.docx");

 // File (or directory) with new name
  File file2 = new File(lastModifiedFile +"\\" + strBcFnFieldValue1 + ".docx");

 // Rename file (or directory)
 boolean success = file.renameTo(file2);
 
 if (success) {
	   System.out.println(success);
	}
 
 CommonFunction.windclose();
}


//To Copy the file
public static void copyFile() throws IOException {
	System.out.println("I am here");
	String filePath = "./Output_Files/";
	FileInputStream is = null;
	FileOutputStream os = null;
	
	System.out.println(lastModifiedFile1);  
    File[] files2 = lastModifiedFile1.listFiles();
    lastModifiedFile = files2[0];
for (int k = 1; k < files2.length; k++) {
 if (lastModifiedFile.lastModified() < files2[k].lastModified()) {
     lastModifiedFile = files2[k];
 }
}

	File[] files = new File(filePath).listFiles();
		for (File file : files) {
			try {
				System.out.println(file);
					is = new FileInputStream(file);
					String test1 = lastModifiedFile + "\\" + strBcFnFieldValue1 + "."
							+ file.getName().substring(file.getName().lastIndexOf('.') + 1);
					System.out.println(test1);
					os = new FileOutputStream(new File(lastModifiedFile + "\\" + strBcFnFieldValue1 + "."
							+ file.getName().substring(file.getName().lastIndexOf('.') + 1)));
					
					byte[] buf = new byte[1024];
					int bytesRead;
					while ((bytesRead = is.read(buf)) > 0) {
						os.write(buf, 0, bytesRead);
					}
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					is.close();
					os.close();
				}
			}
		try {
			CommonFunction.windclose();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to close the window");
		}
		}	

//Sikuli
public static void enableCheckBox() throws IOException, Throwable {

	Screen sc = new Screen();
	Thread.sleep(8000);
	Pattern chkBox = new Pattern("./src/test/resources/checkbox.PNG");
	sc.click(chkBox);
	CustomReports.print_Report("INFO", "Perform Action", "job checkbox is clicked");
	
	Pattern applyButton = new Pattern("./src/test/resources/Apply&Download.PNG");
	sc.click(applyButton);
	CustomReports.print_Report("INFO", "Perform Action", "Apply Button is clicked");
	Thread.sleep(5000);


}	

// To refresh the page for Generating Proof
public static void refreshForProof(RemoteWebDriver driver) throws IOException, Throwable

{
	Thread.sleep(15000);
	String StrbtnNm = driver.findElementByXPath("//button[text()='Refresh']").getText();
	int i = 1;
	try {
	while (StrbtnNm.equals("Refresh")) {
		i++;
		driver.navigate().refresh();
		Thread.sleep(500);
		StrbtnNm = driver.findElementByXPath("//button[text()='Refresh']").getText();
		if (i == 500) {
			CustomReports.print_Report("FAIL", "Perform Action", "Proof is not generated");
			driver.close();
		}

	}
	}catch(Exception e) {

Thread.sleep(5000);
	}
}




public static void valDeleteTem(RemoteWebDriver driver) throws IOException, Throwable
{
        String text = driver.findElementByXPath("//a[text()='logout']//preceding::*[6]").getText();
		if(!text.equalsIgnoreCase("LongBow"))
		{
		CustomReports.print_Report("PASS", "Verification",
				 " Template is deleted successfully & validated.<a href='" + CustomReports.takeSnap()
						+ "'> Click here </a> to view the screen shot");
	}
}
		
		public static void valsortorder(RemoteWebDriver driver) throws IOException, Throwable
		{
			if(orderCount==1)
			{
		        String text = driver.findElementByXPath("(//td[text()='Content']//following::a)[2]").getText();
				if(text.equalsIgnoreCase("Reader's Spread PDF"))
				{
				CustomReports.print_Report("PASS", "Verification",
						 " UP order is successfully validated.<a href='" + CustomReports.takeSnap()
								+ "'> Click here </a> to view the screen shot");
			}
			}
			
			if(orderCount==0)
			{
		        String text = driver.findElementByXPath("(//td[text()='Content']//following::a)[2]").getText();
				if(text.equalsIgnoreCase("Desktop PDF"))
				{
				CustomReports.print_Report("PASS", "Verification",
						 " Down Order is successfully validated.<a href='" + CustomReports.takeSnap()
								+ "'> Click here </a> to view the screen shot");
				orderCount=1;
			}
			}
			

}
		
		
	// For Old JMS pls ignore
		
		public static void getCalenderNextPrevious(String strBcFnFieldValue, RemoteWebDriver driver)
				throws InterruptedException {
			String strToday = new SimpleDateFormat("dd").format(new Date());
			if(strToday.startsWith("0"))
					strToday.charAt(0);	
			System.out.println(strToday);
			if (strBcFnFieldValue.equalsIgnoreCase("next")) {
				driver.findElement(By.xpath("//a//img[@alt='next month']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//font[text()='" + strToday + "']//parent::a)")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='Okay']")).click();
			} 
			else if (strBcFnFieldValue.equalsIgnoreCase("previous")) {
				driver.findElement(By.xpath("//a//img[@alt='previous month']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//font[text()='" + strToday + "']//parent::a)")).click();
				System.out.println("(//font[text()='" + strToday + "']//parent::a)");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()='Okay']")).click();
			} else if (strBcFnFieldValue.equalsIgnoreCase("today")) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='Okay']")).click();
			}

		}

		public static void getFindJobWithXpath(RemoteWebDriver driver) throws FilloException {
			String jobnumber = Utility.readOutputData("JMS_RegressionSuite_E,T&P(ED)-Job,Cycle&dropCreation$$lnk_JobIdEdJob");
			driver.findElement(By.xpath("//td[text()='" + jobnumber + "']/ancestor::tr//td//a[text()='Create Cycle']"))
					.click();
		}
		
		
		
		// To genearate random Text
		public static void getRandomText(RemoteWebDriver driver,String strBcFnFieldValueVf) throws FilloException {	
			System.out.println(strBcFnFieldValueVf);
			String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < 5; i++) {
				sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
			}
			
			String value = "Test_" + sb.toString();
			String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");
			String strTestName = strTemp[0];
			String strFieldId = strTemp[1];
			Utility.writeOutputData(strTestName, strFieldId, value);
			strFieldId = strFieldId + "edit";
			value = value + "_edit";
			Utility.writeOutputData(strTestName, strFieldId, value);
			/*System.out.println(strFieldId);
			if (strFieldId.equalsIgnoreCase("txt_randomedit")) {
				value = value + "_edit";
				JMS_Utility.writeOutputData(strTestName, strFieldId, value);
			}*/
		}		

		
//Sikuli - Pls ignore
	public static void actionOnuploadwdEdjob() throws FindFailed, InterruptedException, IOException {
		Screen sc = new Screen();
		Thread.sleep(8000);
		Pattern addButton = new Pattern("./src/test/resources/Add.PNG");
		sc.click(addButton);
		CustomReports.print_Report("INFO", "Perform Action", "Add button is clicked");

		// Pattern 
		// Pattern("C:\\Automation_workspace\\JMS_Automation_Suite\\src\\test\\resources\\Lookin1.PNG");
		Pattern lookIn1 = new Pattern("./src/test/resources/Lookin1.PNG");
		sc.click(lookIn1);
		sc.type("a", Key.CTRL);
		sc.type(Key.BACKSPACE);
		Pattern lookIn = new Pattern("./src/test/resources/Lookin.PNG");
		// sc.type(lookIn,
		// "C:\\Users\\111527\\git\\JMS_Automation_Suite\\src\\test\\resources");
		sc.type(lookIn, "C:\\Users\\111527\\git\\JMS_Automation_Suite\\src\\test\\resources\\Edjob");
		CustomReports.print_Report("INFO", "Perform Action", "File path is entered");

		Pattern setButton = new Pattern("./src/test/resources/Set.PNG");
		sc.click(setButton);
		CustomReports.print_Report("INFO", "Perform Action", "Set button is clicked");

		Pattern testDoc = new Pattern("./src/test/resources/Testpdf.PNG");
		sc.click(testDoc);
		CustomReports.print_Report("INFO", "Perform Action", "File is selected");

		Pattern okButton = new Pattern("./src/test/resources/Ok.PNG");
		sc.click(okButton);
		CustomReports.print_Report("INFO", "Perform Action", "Ok button is clicked");

		Thread.sleep(10000);
		
		System.out.println("1");
		System.out.println("2");
		
	}
	
	// To Check the alert Queue links
	public static void alertquelnk(RemoteWebDriver driver) throws Throwable

	{
		
		 List<WebElement> objActObj = driver.findElementsByXPath("//span[contains(text(),'ALERT QUEUES')]//following::table//tbody//tr");
		int rowSize = objActObj.size();
		int Alerts = 0;
		for (int i = 2; i < rowSize; i++)// 14
		{
			List<WebElement> tds = objActObj.get(i).findElements(By.tagName("td"));
			try {
			 String strAlerts = tds.get(3).getText();
			  Alerts = Integer.parseInt(strAlerts);
			}catch(Exception e)
			{
				
			}
			
			if(Alerts>0)
			{
				tds.get(1).click();
				break;
			}
		}
	
	
	}
	
	// this method is to create a unique Coreproperty name  for the test case
	public static void coreporNm(String strBcFnFieldValueVf)

	{
		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];
		String strCurDate = new SimpleDateFormat("_mm_ss").format(new Date());
		String strCoreporNm = "000_LongBow_Test" + strCurDate ;
		System.out.println(strCoreporNm);
		Utility.writeOutputData(strTestName, strFieldId, strCoreporNm);
		strFieldId = strFieldId + "_Edit";
		strCoreporNm = "001_LongBow_Test" + strCurDate ;
		Utility.writeOutputData(strTestName, strFieldId, strCoreporNm);
		
	}
	
	
	// Pls ignore - for old JMS
	public static String dynamicData(String strXpath) 
	{
		if(strXpath.contains("$$"))
		{
		String[] strTemp = strXpath.split("\\+");
    	String strTemp1 = strTemp[0];
		String strTcaseFnm = strTemp[1];
		String strTemp2 = strTemp[2];
	//	strTemp1 = strTemp1 + "\"";
	//	strTemp2 =  "\""+  strTemp2 ;
		//td[text()='+ AsyncProcessList_Add_Edit_Delete$$txt_Implement +']
		
		try {
			strTcaseFnm =	Utility.readOutputData(strTcaseFnm);
		} catch (FilloException e) {
			
			System.out.println("Unable to readData in dynamicData Method" + e );
		}
		System.out.println(strTemp1);
		System.out.println(strTcaseFnm);
		System.out.println(strTemp2);
		strXpath = strTemp1 + strTcaseFnm + strTemp2;
		
		
		}
		return strXpath;
	}
		
	
	public static void AsynNm(String strBcFnFieldValueVf)

	{
		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];
		String strCurDate = new SimpleDateFormat("_mm_ss").format(new Date());
		String strAsynNm = "001JMSTest" + strCurDate ;
		System.out.println(strAsynNm);
		Utility.writeOutputData(strTestName, strFieldId, strAsynNm);
		
	}
	
	
	public static void contactFirstNm(String strBcFnFieldValueVf) throws FilloException, InterruptedException {
		String[] strTemp = strBcFnFieldValueVf.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldId = strTemp[1];
		String strCurDate = new SimpleDateFormat("mmss").format(new Date());
		System.out.println(strCurDate);
		String strFirst = "Nadal_";
		strFirst = strFirst.concat(strCurDate);
		Utility.writeOutputData(strTestName, strFieldId, strFirst);
		strFieldId = strFieldId.replaceAll("txt_FirstName_CS","txt_LastName_CS");
		 strFirst = strCurDate;
		Utility.writeOutputData(strTestName, strFieldId, strFirst);
		Thread.sleep(2000);
	}

	
	//Date Picker
	public static void datePicker(String strBcFnFieldValue, RemoteWebDriver driver)
	{
		if(strBcFnFieldValue.equalsIgnoreCase("Today's Date"))
		{
			driver.findElementByXPath("//a//img[@src='images/calendar.gif']").click();
			
			String Currentwindow = driver.getWindowHandle();
			System.out.println(driver.getTitle());
			Set<String> windowHandles = driver.getWindowHandles();
			for (String eachWind : windowHandles) {
				if(!eachWind.equals(Currentwindow)) {
					driver.switchTo().window(eachWind);
				System.out.println(driver.getTitle());
				break;
			}}
			String date = new SimpleDateFormat("dd").format(new Date());
			 int presentDate= Integer.parseInt(date);
			driver.findElementByXPath("//a//font[text()='"+presentDate+"']").click();
			
			
			try
			   {
			   driver.findElementByXPath("//button[text()='Okay']").click();
			  
			   }catch(Exception e)
			   {
				   
			   }
			
			driver.switchTo().window(Currentwindow);
		}
		
		else
		{
		
		
		String[] dateVal =strBcFnFieldValue.split("/");
		
		int monthToSelect =Integer.parseInt(dateVal[0]);
		int date =Integer.parseInt(dateVal[1]);
		int yearToSelect =Integer.parseInt(dateVal[2]);
		
	   String  monthFormat = new SimpleDateFormat("MM").format(new Date());
	   int presentMonth = Integer.parseInt(monthFormat);
	   
	   
	   String yearFormat = new SimpleDateFormat("YYYY").format(new Date());
	   int presentYear = Integer.parseInt(yearFormat);
	 
	   driver.findElementByXPath("//a//img[@src='images/calendar.gif']").click();
	   
	   String Currentwindow = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		for (String eachWind : windowHandles) {
			if(!eachWind.equals(Currentwindow)) {
				driver.switchTo().window(eachWind);
			System.out.println(driver.getTitle());
			break;
		}}
	   
	   
	   if(yearToSelect>presentYear)
	   {
		   for(int i=0;i<yearToSelect-presentYear;i++) {
			   driver.findElementByXPath("//img[@alt='next year']").click();
		   }
	   }
	   
	   
	   else if(yearToSelect<presentYear)
	   {
		   for(int i=0;i<presentYear-yearToSelect;i++) {
			   driver.findElementByXPath("//img[@alt='previous year']").click();
		   }
	   }
	   
	   if(monthToSelect>presentMonth)
	   {
		   for(int i=0;i<monthToSelect-presentMonth;i++) {
			   driver.findElementByXPath("//img[@alt='next month']").click();
		   } 
	   }
	   
	   else if(monthToSelect<presentMonth)
	   {
		   for(int i=0;i<presentMonth-monthToSelect;i++) {
			   driver.findElementByXPath("//img[@alt='previous month']").click();
		   } 
	   }
	   
	   driver.findElementByXPath("//a//font[text()='"+date+"']").click();
	   try
	   {
	   driver.findElementByXPath("//button[text()='Okay']").click();
	  Thread.sleep(8000);
	   }catch(Exception e)
	   {
		   
	   }
	   
		driver.switchTo().window(Currentwindow);
		
	}
		
	}
	
	// for Date selection
	public static void dateMultiPicker(String strBcFnFieldValue, RemoteWebDriver driver)
	{
		if(strBcFnFieldValue.equalsIgnoreCase("Today's Date"))
		{
			
			
			String Currentwindow = driver.getWindowHandle();
			System.out.println(driver.getTitle());
			Set<String> windowHandles = driver.getWindowHandles();
			for (String eachWind : windowHandles) {
				if(!eachWind.equals(Currentwindow)) {
					driver.switchTo().window(eachWind);
				System.out.println(driver.getTitle());
				break;
			}}
			String date = new SimpleDateFormat("dd").format(new Date());
			 int presentDate= Integer.parseInt(date);
			driver.findElementByXPath("//a//font[text()='"+presentDate+"']").click();
			
			
			try
			   {
			   driver.findElementByXPath("//button[text()='Okay']").click();
			  
			   }catch(Exception e)
			   {
				   
			   }
		
			driver.switchTo().window(Currentwindow);
		}
		
		else
		{
		
		
		String[] dateVal =strBcFnFieldValue.split("/");
		
		int monthToSelect =Integer.parseInt(dateVal[0]);
		int date =Integer.parseInt(dateVal[1]);
		int yearToSelect =Integer.parseInt(dateVal[2]);
		
	   String  monthFormat = new SimpleDateFormat("MM").format(new Date());
	   int presentMonth = Integer.parseInt(monthFormat);
	   
	   
	   String yearFormat = new SimpleDateFormat("YYYY").format(new Date());
	   int presentYear = Integer.parseInt(yearFormat);
	 
	  // driver.findElementByXPath("//a//img[@src='images/calendar.gif']").click();
	   
	   String Currentwindow = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		for (String eachWind : windowHandles) {
			if(!eachWind.equals(Currentwindow)) {
				driver.switchTo().window(eachWind);
			System.out.println(driver.getTitle());
			break;
		}}
	   
	   
	   if(yearToSelect>presentYear)
	   {
		   for(int i=0;i<yearToSelect-presentYear;i++) {
			   driver.findElementByXPath("//img[@alt='next year']").click();
		   }
	   }
	   
	   
	   else if(yearToSelect<presentYear)
	   {
		   for(int i=0;i<presentYear-yearToSelect;i++) {
			   driver.findElementByXPath("//img[@alt='previous year']").click();
		   }
	   }
	   
	   if(monthToSelect>presentMonth)
	   {
		   for(int i=0;i<monthToSelect-presentMonth;i++) {
			   driver.findElementByXPath("//img[@alt='next month']").click();
		   } 
	   }
	   
	   else if(monthToSelect<presentMonth)
	   {
		   for(int i=0;i<presentMonth-monthToSelect;i++) {
			   driver.findElementByXPath("//img[@alt='previous month']").click();
		   } 
	   }
	   
	   driver.findElementByXPath("//a//font[text()='"+date+"']").click();
	   try
	   {
	   driver.findElementByXPath("//button[text()='Okay']").click();
	  Thread.sleep(8000);
	   }catch(Exception e)
	   {
		   
	   }
	  
		driver.switchTo().window(Currentwindow);
		
	}
		
	}
	
	// File uploaded
	public static void chromewindow(RemoteWebDriver driver, String strBcFnFieldValue) throws AWTException, FilloException, InterruptedException
	{
		
	    String Sharepath;
	    driver.findElementByXPath("//label[@for='fileUpload']").click();		
		Robot robot = new Robot();
        robot.setAutoDelay(2000);
        Sharepath = System.getProperty("user.dir") +"\\src\\test\\resources\\" + strBcFnFieldValue ; 
  System.out.println(Sharepath);
        StringSelection selection = new StringSelection(Sharepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
 
        robot.setAutoDelay(1000);
 
        robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
 
        robot.setAutoDelay(1000);

 
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        
        
	}
	

	
	
	//To Delete the file
	public static void fileDelete(String strBcFnFieldValue) throws AWTException, FilloException
	{
		
		String Sharepath = "C:\\Users\\" + System.getProperty("user.name") +"\\Downloads\\";	
		
		 File file = new File(Sharepath); 
		 
		 for(File f:file.listFiles())
		 {
       
	        if(f.getName().startsWith(strBcFnFieldValue))
	        {
	        	if(f.delete())
	        	System.out.println("Deleted");
	        	
	        }
	        //"Print_Distro_Summary"
}
	}
	
	// To check whether the File exist or not
	public static void fileExist(String strBcFnFieldValue) throws FilloException, WebDriverException, IOException, InterruptedException
	{
		
		Thread.sleep(5000);
		String Sharepath = "C:\\Users\\" + System.getProperty("user.name") +"\\Downloads\\";	
		
		 File file = new File(Sharepath); 
       
		 for(File f:file.listFiles())
		 {
	        if(f.getName().startsWith(strBcFnFieldValue))
	        {
	        	if(f.exists())
	        	{
	        		CustomReports.print_Report("PASS", "Verification",
		        			strBcFnFieldValue + " is downloaded.<a href='" + CustomReports.takeSnap()  
					+ "'> Click here </a> to view the screen shot");
	        		break;
	        	}
	        
	        	
	        }
}
	
	}	
	
	// This is for TCC application - Date Selection
	public static void TccdatePicker(String strBcFnFieldValue, RemoteWebDriver driver)
	{
		if(strBcFnFieldValue.equalsIgnoreCase("Today's Date"))
		{
			
			
			String Currentwindow = driver.getWindowHandle();
			System.out.println(driver.getTitle());
			Set<String> windowHandles = driver.getWindowHandles();
			for (String eachWind : windowHandles) {
				if(!eachWind.equals(Currentwindow)) {
					driver.switchTo().window(eachWind);
				System.out.println(driver.getTitle());
				break;
			}}
			String date = new SimpleDateFormat("dd").format(new Date());
			 int presentDate= Integer.parseInt(date);
			driver.findElementByXPath("//span[text()='" + presentDate + "']").click();
			try
			{
			driver.findElementByXPath("//a[@ng-click='decrementHours()']").click();
			driver.findElementByXPath("//button[text()='Close']").click();
			
			}
			catch(Exception e)
			{
				
			}
			driver.switchTo().window(Currentwindow);
		}
	}
	
	// To close the Browser
	public static void closeBrowser(RemoteWebDriver driver) {
		driver.quit();
	}
	
	
	public static void mouseOver(RemoteWebDriver driver,String strBcFnFieldValue) {
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText(strBcFnFieldValue));
		action.moveToElement(element).perform();
	}
	
	
public static void frames(RemoteWebDriver driver) {
	    
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@class='editorFrame']"));
		System.out.println("Frameswtiched");
	}
	

}


