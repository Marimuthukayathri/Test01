package frameworkCore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ValidationVerification {

	public static List<WebElement> objActObj;
	public static String strBcFnFieldName, strVerfValue,strReadDataText,strTestCasenFName;
	public static String [] strDrpdnVerf;

	public static void resultVerVal(String strBcFnFieldValue, String strBusFn, String strSheet, List<WebElement> objActObj,String strBcFnClmLstNm) throws Throwable {

		String [] strTmpBcFnFieldValue = strBcFnFieldValue.split("::");
		strBcFnFieldValue = strTmpBcFnFieldValue[1];
    	strVerfValue =strTmpBcFnFieldValue[2];
		
    	if(strVerfValue.contains("$$"))
    	{
				strTestCasenFName =strVerfValue.substring(1);
				strVerfValue =	Utility.readOutputData(strTestCasenFName);
				Thread.sleep(5000);
    	}
    	
  	
    	if(strVerfValue.contains(";"))
		{
			
			strDrpdnVerf = strVerfValue.split(";");
			
		}

		switch(strBcFnFieldValue.toUpperCase())
   	 {
   	 
		// To check the dropdown value
   	case "DRPDNVALUE" :
   		
   		ArrayList<String> strDrpInpVal = new ArrayList<String>();
   		
   		for(int i=0;i<strDrpdnVerf.length;i++)
		 {
			strDrpInpVal.add(strDrpdnVerf[i]);
		 }
   		
   		Select objDrpSlt = new Select(objActObj.get(0));
   		
   		ArrayList<String> strDrpOutVal = new ArrayList<String>();
   		
   		List<WebElement> objOptions = objDrpSlt.getOptions();
   		
   		for (WebElement objIndOptions : objOptions) {
   			
  			 String strOptionsVal = objIndOptions.getText();
  			strDrpOutVal.add(strOptionsVal);
   		}
   		
   		strDrpInpVal.removeAll(strDrpOutVal);
   		
   		//System.out.println(strDrpInpVal);
   		 
   		if(strDrpInpVal.isEmpty())
   		 {
   			CustomReports.print_Report("PASS", "Verification",
					"All values are available in dropdown and successfully validated.<a href='" + CustomReports.takeSnap()  
			+ "'> Click here </a> to view the screen shot");
   		 }
   		 
   		 else
   		 {
   			 System.out.println(strDrpInpVal);
   			CustomReports.print_Report("FAIL", "Verification",
   					strDrpInpVal+	"values are not available in dropdown.<a href='" + CustomReports.takeSnap()  
			+ "'> Click here </a> to view the screen shot");
   		 }
 
   		 break;
   		/* case "DRPDNVALUE" :
   		 
    		if (objActObj.isEmpty()||objActObj==null)
 		 {
 	          	custom_Reports.print_Report("FAIL", "Perform Action", "Element could not be found drpdn" );   	
        	 }
    		
         ArrayList<String> strDrpdnVal = new ArrayList<String>();
 		
 		for(int i=0;i<strDrpdnVerf.length;i++)
 			 {
 			strDrpdnVal.add(strDrpdnVerf[i]);
 			 }
 		
    		
    		Select objDrpSlt = new Select(objActObj.get(0));
    		List<WebElement> objOptions = objDrpSlt.getOptions();
    		 for (WebElement objIndOptions : objOptions) {
    			 String strOptionsVal = objIndOptions.getText();
    			for (String strDrpdnIndVal : strDrpdnVal)
    			{
    				 if(strOptionsVal.equals(strDrpdnIndVal))
    				 {
    					strDrpdnVal.remove(strDrpdnIndVal);
    					System.out.println(strOptionsVal+" value is available in the dropdown");
    					if(strDrpdnVal.isEmpty())
    					break;
    					
    				 }
    			 }
    			
    		 }*/
   	// To check the whether check box is selected
   	case "ISSELECTED" :
   		
   	 
   		if (objActObj.isEmpty()||objActObj==null)
		 {
	          	CustomReports.print_Report("FAIL", "Perform Action", "Element could not be found " );   	
       	 }
   		
   		 if(String.valueOf(objActObj.get(0).isSelected()).equalsIgnoreCase(strVerfValue))
   		 {
   			 
   			CustomReports.print_Report("PASS", "Verification",
   					strBcFnClmLstNm +"CheckBox is Selected.<a href='" + CustomReports.takeSnap()
					+ "'> Click here </a> to view the screen shot");
   		 }
   		 
   		 else
   		 {
   			CustomReports.print_Report("FAIL", "Verification",
   					strBcFnClmLstNm + "CheckBox is Not Selected.<a href='" + CustomReports.takeSnap()
					+ "'> Click here </a> to view the screen shot");
   		 }
   		
   		 break;
   	// To check the text is available or not	 
   	case "TEXT":
   		try
   		{
   		String text = objActObj.get(0).getText();
		System.out.println(text);
		if(text.equals("") || text.equals(" "))
			text = "Null";
		if (text.contains(strVerfValue) || strVerfValue.contains(text)) {
			CustomReports.print_Report("PASS", "Verification",
					strBusFn + " funtionality is successfully validated.<a href='" + CustomReports.takeSnap()
							+ "'> Click here </a> to view the screen shot");
		} 
		
   				else
   				{
   					CustomReports.print_Report("FAIL", "Verification", strBusFn + " funtionality is failed. <a href='"
   							+ CustomReports.takeSnap() + "'> Click here </a> to view the screen shot");
   				}
   		}catch(Exception e)
   		{
   			CustomReports.print_Report("FAIL", "Verification", strBusFn + " funtionality is failed. <a href='"
						+ CustomReports.takeSnap() + "'> Click here </a> to view the screen shot");
   		}
		break;
		// To check negative conditions
   	case "TEXTNEG":
   		try
   		{
   		String text = objActObj.get(0).getText();
		System.out.println(text);
		if (!text.equalsIgnoreCase(strVerfValue)) {
			CustomReports.print_Report("PASS", "Verification",
					strBusFn + " funtionality is successfully validated.<a href='" + CustomReports.takeSnap()
							+ "'> Click here </a> to view the screen shot");
		} 
		
   				else
   				{
   					CustomReports.print_Report("FAIL", "Verification", strBusFn + " funtionality is failed. <a href='"
   							+ CustomReports.takeSnap() + "'> Click here </a> to view the screen shot");
   				}
   		}catch(Exception e)
   		{
   			CustomReports.print_Report("FAIL", "Verification", strBusFn + " funtionality is failed. <a href='"
						+ CustomReports.takeSnap() + "'> Click here </a> to view the screen shot");
   		}
		break;
		
   	case "ISDISPLAYED" :
   		
      	 
   		if (objActObj.isEmpty()||objActObj==null)
		 {
	          	CustomReports.print_Report("FAIL", "Perform Action", "Element could not be found" );   	
       	 }
   		try
   		{
   			boolean displayed = objActObj.get(0).isDisplayed();
   			Thread.sleep(2000);
   		 if(String.valueOf(objActObj.get(0).isDisplayed()).equalsIgnoreCase(strVerfValue))
   		 {
   			 
   			CustomReports.print_Report("PASS", "Verification",
   					strBcFnClmLstNm+ "Button is displayed");
   			CustomReports.print_Report("PASS", "Verification",
					strBusFn + " funtionality is successfully validated.<a href='" + CustomReports.takeSnap()
							+ "'> Click here </a> to view the screen shot");
   		 }
   		 
   		 else
   		 {
   			CustomReports.print_Report("FAIL", "Verification",
   					strBcFnClmLstNm+ "CheckBox is Not Selected.<a href='" + CustomReports.takeSnap()
					+ "'> Click here </a> to view the screen shot");
   		 }
   		}catch(Exception e)
   		{
   			CustomReports.print_Report("FAIL", "Verification", strBusFn + " funtionality is failed. <a href='"
					+ CustomReports.takeSnap() + "'> Click here </a> to view the screen shot");
   		}
   		 break;
   	// To check the attribute value	 
   	case "ATTRIBUTE" :
   		
   		if (objActObj.isEmpty()||objActObj==null)
		 {
	          	CustomReports.print_Report("FAIL", "Perform Action", "Element could not be found" );   	
      	 }
   		
   		try
   		{
   			String strattrivalue = objActObj.get(0).getAttribute("value");
   			if(strattrivalue.equals(""))
   				strattrivalue = "Null";
   			if (strattrivalue.contains(strVerfValue) || strVerfValue.contains(strattrivalue)) {
   				CustomReports.print_Report("PASS", "Verification",
   						strBusFn + " funtionality is successfully validated.<a href='" + CustomReports.takeSnap()
   								+ "'> Click here </a> to view the screen shot");
   			} 
   			
   	   				else
   	   				{
   	   					CustomReports.print_Report("FAIL", "Verification", strBusFn + " funtionality is failed. <a href='"
   	   							+ CustomReports.takeSnap() + "'> Click here </a> to view the screen shot");
   	   				}
   	   		}catch(Exception e)
   	   		{
   	   			CustomReports.print_Report("FAIL", "Verification", strBusFn + " funtionality is failed. <a href='"
   							+ CustomReports.takeSnap() + "'> Click here </a> to view the screen shot");
   	   		}
   			break;
   			
   		// To check the selected option in the drop down	
   	case "SELECTEDOPTION":
   		
   		Select objDrpSlt1 = new Select(objActObj.get(0));
   		
   		WebElement selectedOption = objDrpSlt1.getFirstSelectedOption();
   		String text = selectedOption.getText();
   		if(text.equalsIgnoreCase(" ")||text.equalsIgnoreCase(""))
   		{
   			text="Null";
   		}
   		
   		if(text.equalsIgnoreCase(strVerfValue))
   		{
   			CustomReports.print_Report("PASS", "Verification",
					strBusFn + " funtionality is successfully validated.<a href='" + CustomReports.takeSnap()
							+ "'> Click here </a> to view the screen shot");
   		}
   		else
   		{
   			CustomReports.print_Report("FAIL", "Verification",
					strBusFn + " funtionality is successfully validated.<a href='" + CustomReports.takeSnap()
							+ "'> Click here </a> to view the screen shot");
   		}
   		
break;
	}
		
			
		
		}
	}


