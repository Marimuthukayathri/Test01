package frameworkCore;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import application.CommonFunction;

public class PerformAction {
	public static List<WebElement> objActObj;
	public static String strBcFnClmFstNm ,strFlag, strBcFnClmLstNm, strDrpdnObjNm, strChkObjValue,strTemp,strRdbtObjNm,strTmpClmLst,currentWindow,strTitle,strChkObjtxt, browserName,strBcFnFieldValueVf = null;
	public static boolean strreexeFlg=true;
	public static int incwaitstl;
	// To perform action on the particular object mentioned in the excel
	public static boolean Performaction(RemoteWebDriver driver, String strBcFnFieldname, String strBcFnFieldValue, String strBusFn, String strSheet) throws Throwable {
		// For splitting the Business function field value for verification method and
		// get object method
		if (strBcFnFieldValue.contains("##")) {
			String[] strTmpBcFnFieldValue = strBcFnFieldValue.split("##");
			strBcFnFieldValue = strTmpBcFnFieldValue[0];
			strBcFnFieldValueVf = strTmpBcFnFieldValue[1];
		}
		else {
			strBcFnFieldValueVf = "NO value";
		}
		if (strBcFnFieldValue.contains("$$") && !strBcFnFieldValue.contains("::")) {
			strBcFnFieldValue = Utility.readOutputData(strBcFnFieldValue);
		}
		strBcFnClmFstNm = strBcFnFieldname.substring(0, strBcFnFieldname.indexOf('_'));
		strTmpClmLst = strBcFnFieldname.substring(strBcFnFieldname.indexOf('_') + 1, strBcFnFieldname.length());
		if (strTmpClmLst.contains("_"))
			strBcFnClmLstNm = strTmpClmLst.substring(0, strTmpClmLst.indexOf('_'));
		else
			strBcFnClmLstNm = strBcFnFieldname.substring(strBcFnFieldname.indexOf('_') + 1, strBcFnFieldname.length());
		if (!strBcFnClmFstNm.equals("swtto") && !strBcFnClmFstNm.equals("swtbk") && !strBcFnClmFstNm.equals("cal") && !strBcFnClmFstNm.equals("Put")) {
			objActObj = InitiateExecution.getObject(strBcFnFieldname, strBcFnFieldValue, strSheet);
		}
		if (!strBcFnClmFstNm.equals("swtto") && !strBcFnClmFstNm.equals("swtbk") && !strBcFnClmFstNm.equals("cal") && !strBcFnClmFstNm.equals("Put")) {
			int incwait = 0;
			while ((objActObj.isEmpty()) && (incwait < 1) && (objActObj == null)) {
				Thread.sleep(5000);
				objActObj = InitiateExecution.getObject(strBcFnFieldname, strBcFnFieldValue, strSheet);
				incwait = incwait + 1;
			}
		}
		if (!objActObj.isEmpty() && (objActObj != null)) {

			if (!strBcFnFieldValue.contains("::")) { //Checking for verification step
				switch (strBcFnClmFstNm.toUpperCase()) {
				case "BTN":
					try {
						objActObj.get(0).click();
						CustomReports.print_Report("INFO", "Perform Action", strBcFnClmLstNm + " button is clicked ");
					} catch (Exception e) {
						CustomReports.print_Report("FAIL", "Perform Action", "Exception while clicking on " + strBcFnFieldname + " object. Exception Details: "+ e.getLocalizedMessage());
						strreexeFlg = false;
					}
					break;

				case "LNK":
					try {
						WebElement objlnkEle = objActObj.get(0);
						objlnkEle.click();
						String text = objlnkEle.getText();
						if (!text.equals(""))
							CustomReports.print_Report("INFO", "Perform Action", text + " Link is clicked");
						else
							CustomReports.print_Report("INFO", "Perform Action", strBcFnClmLstNm + " Link is clicked");
					} catch (Exception e) {
						// System.out.println(e);
						CustomReports.print_Report("FAIL", "Perform Action", "Unknown exception occured while clicking the :" + strBcFnClmLstNm + "link. Exception Details: " + e);
						strreexeFlg = false;
					}
					break;

				case "CHK":
					try {
						WebElement objChkEle = objActObj.get(0);
						objChkEle.click();
						CustomReports.print_Report("INFO", "Perform Action", strBcFnClmLstNm + " value is selected in the checkbox");
					} catch (Exception e) {
						CustomReports.print_Report("FAIL", "Perform Action", "Exception occured while selecting the :" + strBcFnClmLstNm + " value in the checkbox. Exception Details: " + e);
						strreexeFlg = false;
					}
					break;

				case "TXT":
					try {
						WebElement objTxtEle = objActObj.get(0);
						if (strBcFnFieldValue.equals("Click")) {
							objTxtEle.click();
						} else if (strBcFnFieldValue.equals("DoubleClick")) {
							Thread.sleep(8000);
							Actions action = new Actions(driver);
							action.doubleClick(objTxtEle).perform();
						} else {
							objTxtEle.clear();
							objTxtEle.sendKeys(strBcFnFieldValue);
						}
						CustomReports.print_Report("INFO", "Perform Action", strBcFnFieldValue + " value is enterted in " + strBcFnClmLstNm + " textbox");
					} catch (Exception e) {
						CustomReports.print_Report("FAIL", "Perform Action", "Exception while performing action in text box. object: " + strBcFnClmLstNm + "Exception Details: " + e);
						strreexeFlg = false;
					}
					break;

				case "DRPDN":
					Select objDrpSlt = new Select(objActObj.get(0));
					try {
						WebElement drpdnobj = null;
						int incDrpWait = 0;
						while ((drpdnobj == null) && (incDrpWait < 4)) {
							List<WebElement> objSltOpt = objDrpSlt.getOptions();
							drpdnobj = getdrpdowntoselect(objSltOpt, strBcFnFieldValue);
							if (!drpdnobj.equals(null)) {
								drpdnobj.click();
								break;
							} else {
								incDrpWait = incDrpWait + 1;
								Thread.sleep(3000);
							}
						}
						CustomReports.print_Report("INFO", "Perform Action", strBcFnFieldValue + " value is Selected in " + strBcFnClmLstNm + " Dropdown");
					} catch (Exception e) {
						CustomReports.print_Report("FAIL", "Perform Action", "Exception while performing action in drop down. object: " + strBcFnClmLstNm + "Exception Details: " + e);
						strreexeFlg = false;
					}
					break;

				case "SWTTO":
					try {
						Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
						browserName = cap.getBrowserName().toLowerCase();
						System.out.println(browserName);
						if ((browserName.equals("chrome")) && (strBcFnFieldValue.equalsIgnoreCase("Switch"))) {
							Thread.sleep(1000);
							driver.switchTo().frame(0);
							Thread.sleep(1000);
						} else {
							currentWindow = driver.getWindowHandle();
							System.out.println(currentWindow);
							strTitle = driver.getTitle();
							System.out.println(strTitle);
							Set<String> handles = driver.getWindowHandles();
							System.out.println(handles);
							int winWait = 0;
							while (handles.size() < 2 && winWait < 100) {
								handles = driver.getWindowHandles();
								System.out.println(handles);
								winWait++;
							}
							for (String windowsHandles : handles) {
								if (!windowsHandles.equals(currentWindow)) {
									driver.switchTo().window(windowsHandles);
									System.out.println(windowsHandles);
									strTitle = driver.getTitle();
									System.out.println(strTitle);
									if (strTitle.equalsIgnoreCase(strBcFnClmLstNm)) {
										driver.switchTo().frame(0);
										System.out.println("window switched");
										break;
									} else if (strTitle.equalsIgnoreCase("JMS")) {
										CommonFunction.windswtjob(driver);
										break;
									}

								}
							}
						}
					} catch (Exception e) {
						CustomReports.print_Report("FAIL", "Perform Action", "Exception while switching window. Window not found. Exception Details: " + e);
						strreexeFlg = false;
					}
					break;

				case "SWTBK":
					try {
						if (strBcFnFieldValue.equalsIgnoreCase("SwitchChrome")) {
							driver.switchTo().window(currentWindow);
							System.out.println("SWITHC BACK");
							System.out.println(currentWindow);
						} else if ((!browserName.equals("chrome"))) {
							driver.switchTo().window(currentWindow);
							System.out.println("SWITHC BACK");
							System.out.println(currentWindow);
						}
					} catch (WebDriverException e) {
						CustomReports.print_Report("FAIL", "Perform Action", "Window not found ");
					}

					break;

				case "RDBT":
					try {
						if (strBcFnFieldValue.equals("done"))
							System.out.println("yes");
						WebElement rdbtEle = objActObj.get(0);
						rdbtEle.click();
						CustomReports.print_Report("INFO", "Perform Action", strBcFnClmLstNm + " value is selected in radio options ");
					} catch (Exception e) {
						CustomReports.print_Report("FAIL", "Perform Action", "Unknown exception is occured");
						strreexeFlg = false;
					}
					break;

				case "CAL":
					 Class objMBDCls = CommonFunction.class; 
					 Method methodToExecute =
					 objMBDCls.getDeclaredMethod(strBcFnClmLstNm, new Class[]{String.class,String.class} ); 
					 strFlag = (String) methodToExecute.invoke(objMBDCls.newInstance(), new Object[]{strBcFnFieldValue,driver});
				}
			}
			if (strBcFnFieldValue.contains("::")) {
				ValidationVerification.resultVerVal(strBcFnFieldValue, strBusFn, strSheet, objActObj, strBcFnClmLstNm);
			}

		}

		if (!objActObj.isEmpty() && (objActObj != null)) {
			return true;
		} else {
			return false;
		}
	}
	
	// For Dropdown Select
	public static WebElement getdrpdowntoselect(List<WebElement> objActObj, String strBcFnFieldValue) throws InterruptedException {
		WebElement drpdnobjret = null;
		for (WebElement drpdnobj : objActObj) {
			strDrpdnObjNm = drpdnobj.getText();
			if (strDrpdnObjNm.isEmpty()) {
				strDrpdnObjNm = drpdnobj.getText();
			}
			if (strBcFnFieldValue.equals("Null"))
				strBcFnFieldValue = "";
			if (strDrpdnObjNm.equalsIgnoreCase(strBcFnFieldValue) || strDrpdnObjNm.contains(strBcFnFieldValue)) {
				System.out.println(strDrpdnObjNm);
				drpdnobjret = drpdnobj;
				break;
			} else if (drpdnobj.getAttribute("value").equalsIgnoreCase(strBcFnFieldValue)) {
				drpdnobjret = drpdnobj;
				break;
			}

		}
		return drpdnobjret;
	}

}

	







 