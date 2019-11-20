package frameworkCore;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
import com.codoid.products.fillo.Recordset;

import application.CommonFunction;

public class InitiateExecution {
	
	public static RemoteWebDriver driver;
	public static String fieldvalue,strSheet,strBusFn,strField,strBcFnClmFstNm,strBcFnClmLstNm,strBcFnFieldValue,strTCName,strTmpClmLst,strTemp,strstrBcFnClmLstNmV1,strstrBcFnClmLstNmV2;
	static List<WebElement> objActObj;
	public static WebElement lnkobj;
	public static int incremt=0,incwait=0;

        
	@Test // To execute the testcases which are all marked as YES
	public void executeBusinessFlow() throws Throwable {
		try {
			incremt = 0;
			CustomReports.startReport();
			String strDriverQry, strQuery;
			String strDrvJekins = System.getProperty("executiontype");
			if (strDrvJekins == null)
				strDriverQry = "Select * from Business_Driven_Flow where Exec_Flag='YES'";
			else
				strDriverQry = "Select * from Business_Driven_Flow where Exec_Flag='YES' and Exec_Type = '"
						+ strDrvJekins + "'";
			System.out.println(strDriverQry);
			Recordset rs = DataConnections.qry_DataFile(strDriverQry);

			while (rs.next()) {
				CustomReports.strtTest(rs.getField("TestCaseName"));
				CustomReports.print_Report("INFO", "<font size =3.3><b>Initiating Execution</b></font>",
						"<font size =3.3><b>Executing " + rs.getField("TestCaseName") + " test case .</b></font>");
				CustomReports.print_Report("INFO", "Test Case Description", rs.getField("MainFunction"));
				driver = LoadDriver.invokeBrowser();
				ArrayList<String> exlFieldNames = rs.getFieldNames();

				for (int incBC = 0; incBC < exlFieldNames.size(); incBC++)

				{
					if ((exlFieldNames.get(incBC)).contains("TestCaseName")) {
						strTCName = rs.getField(exlFieldNames.get(incBC));
					}
					if ((exlFieldNames.get(incBC)).contains("Business_Component")) {
						int intBusCmp = 1;
						strField = rs.getField(exlFieldNames.get(incBC));
						if (strField.equals("")) {
							break;
						} else {
							/*strSheet = strField.substring(strField.indexOf('_') + 1, strField.length());
							strBusFn = strField.substring(0, strField.indexOf('_'));
							CustomReports.print_Report("INFO", "<b>" + strSheet + " Screen</b>",
									"<b>Executing " + strBusFn + " functionality in the" + strSheet + " screen<b>");*/
							executeBusinessComponent(strField, strTCName,intBusCmp);
							intBusCmp = intBusCmp +1;

						}
					}

				}

				LoadDriver.closeBrowser();
				CustomReports.endReport();

			}

			CustomReports.copy_LatestReport();
		} catch (Exception e) {
			CustomReports.print_Report("FAIL", "Perform Action", "Unknown exception occured " + e);
			LoadDriver.closeBrowser();
			CustomReports.endReport();
		}

	}
			
	// To read values from the Business components
	public static void executeBusinessComponent(String strField,String strFieldTC, int intBusCmp) throws Throwable {
		try {
			int temp;
			boolean strreexeFlg = false;
			strSheet = strField.substring(strField.indexOf('_') + 1, strField.length());
			strBusFn = strField.substring(0, strField.indexOf('_'));
			CustomReports.print_Report("INFO", "<b>" + strSheet + " Screen</b>","<b>Executing " + strBusFn + " functionality in the" + strSheet + " screen<b>");
			String strDriverQry = " Select * from " + strSheet + " where BusinessFuntion = '" + strBusFn
					+ "' AND TestCaseName = '" + strFieldTC + "'AND Iteration = '" + intBusCmp + "'";
			Recordset rs = DataConnections.qry_DataFile(strDriverQry);
			while (rs.next()) {
				ArrayList<String> astrBcFnFieldNames = rs.getFieldNames();
				for (String strBcFnFieldname : astrBcFnFieldNames) {
					if (strBcFnFieldname.contains("_") && !strBcFnFieldname.equals("")) {
						strBcFnClmFstNm = strBcFnFieldname.substring(0, strBcFnFieldname.indexOf('_'));
						strBcFnClmLstNm = strBcFnFieldname.substring(strBcFnFieldname.indexOf('_') + 1,strBcFnFieldname.length());
						strBcFnFieldValue = rs.getField(strBcFnFieldname);
						if (!strBcFnFieldValue.equals("")) {
							strreexeFlg = PerformAction.Performaction(driver, strBcFnFieldname, strBcFnFieldValue,strBusFn, strSheet);
							// Thread.sleep(3000);
							if ((!strreexeFlg)) {
								CustomReports.print_Report("FAIL", "Verification",strBusFn + " funtionality is failed. <a href='" + CustomReports.takeSnap()
												+ "'> Click here </a> to view the screen shot");
								break;

							}
						}
					}

				}
				if ((!strreexeFlg)) {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		// To get the object from the screen using Xpath
         public static List<WebElement> getObject(String strBcFnFieldname, String strBcFnFieldValue, String strSheet) throws Throwable  
         {
        	 
        	 String strXpath;
        	 strBcFnClmFstNm = strBcFnFieldname.substring(0,strBcFnFieldname.indexOf('_'));
        	 strTmpClmLst = strBcFnFieldname.substring(strBcFnFieldname.indexOf('_')+1,strBcFnFieldname.length());

        	 
   			if(strTmpClmLst.contains("_")) 
   				strBcFnClmLstNm = strTmpClmLst.substring(0,strTmpClmLst.indexOf('_')); 
   			else 
   				strBcFnClmLstNm = strBcFnFieldname.substring(strBcFnFieldname.indexOf('_')+1,strBcFnFieldname.length());

   			
   			if(CommonFunction.drvreadystate(driver))
   			{
   				try
   		   		{		
   		   			strXpath = Utility.readJSONRepository(strBcFnFieldname, strSheet);
   		   		strXpath = CommonFunction.dynamicData(strXpath);
   		   			
   		     switch(strBcFnClmFstNm.toUpperCase())
   		     
   		     {

   				case "BTN":
   				case "TXT":
   				case "RDBT":
   				case "GET":
   					objActObj = driver.findElementsByXPath(strXpath);
   					break;

   				case "LNK":
   					objActObj = driver.findElementsByXPath(strXpath);
   					if (objActObj.isEmpty())
   						objActObj = driver.findElementsByXPath("//a[text()='" + strBcFnFieldValue + "']");
   					break;

   				case "CHK":
   					objActObj = driver.findElementsByXPath(strXpath);
   					if (objActObj.isEmpty())
   						objActObj = driver	
   								.findElementsByXPath("//a[text()='" + strBcFnFieldValue + "']//preceding::*[1][self::input]");
   					break;

   				case "DRPDN":
   					
   					strXpath = Utility.readJSONRepository(strBcFnFieldname, strSheet);
   							objActObj = driver.findElementsByXPath(strXpath);
   							
   							Select objDrpSlt = new Select(objActObj.get(0));
   							List <WebElement> objSltOpt = objDrpSlt.getOptions();
   		    				int size = objSltOpt.size();
   		    				if(size==1 || size==0)
   		    				{
   		    					Thread.sleep(3000);
   		    					objActObj = driver.findElementsByXPath(strXpath);
   		    				} 							
   							break;

   				}
   		   		
   		   		}
   		   		catch(Throwable e)
   		 		{
   		   		CustomReports.print_Report("FAIL", "Perform Action", strBcFnClmFstNm+"Element could not be found in getobject "+strBcFnClmLstNm);
   		   		}
   			}
   			
		return objActObj;
		
		
	}
}
