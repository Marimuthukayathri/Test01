package frameworkCore;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class Utility {

	
	// To Write data to the excel
	public static void writeOutputData(String strTestCase, String fieldName, String value) {
		String strQuery;
		strQuery = "Update OutputData Set value='" + value + "' where Test_Case_Name='" + strTestCase
				+ "' and Field_Name='" + fieldName + "'";
		DataConnections.update_DataFile(strQuery);

	}
	
	// To read data from the excel
	public static String readOutputData(String strBcFnFieldValue) throws FilloException {

		String[] strTemp = strBcFnFieldValue.split("\\$\\$");

		String strTestName = strTemp[0];
		String strFieldName = strTemp[1];

		String strDriverQry = " Select * from OutputData where Test_Case_Name = '" + strTestName
				+ "' AND Field_Name = '" + strFieldName + "'";
		Recordset rs = DataConnections.qry_DataFile(strDriverQry);

		while (rs.next()) {
			strBcFnFieldValue = rs.getField("value");
		}

		return strBcFnFieldValue;

	}
    
	//To read Json File
	public static String readJSONRepository(String strObjName, String strSheet) {
		String strXpath = null;
		try {

		String strActualJson = FileUtils.readFileToString(
					new File("./Repository.JSON"),
					Charset.defaultCharset());
			
			/*String strActualJson = FileUtils.readFileToString(
					new File("./MCS.JSON"),
					Charset.defaultCharset());*/
			JSONParser parser = new JSONParser(); 
			JSONObject objActJsn = (JSONObject) parser.parse(strActualJson);
		JSONObject objActJsnIn = (JSONObject) objActJsn.get(strSheet);
		strXpath =objActJsnIn.get(strObjName).toString();
			

		
		/*String strActualJson = FileUtils.readFileToString(
				new File("C:\\Users\\111527\\git\\JMS_Automation_Suite\\JMS Repository.JSON"),
				Charset.defaultCharset());
				JSONArray arrActRes = new JSONArray(strActualJson);
			JSONObject objActJsn = arrActRes.getJSONObject(0);
			strXpath = objActJsn.get(strObjName).toString();*/

		} catch (Exception e) {
			System.out.println(e);
		}
		return strXpath;

	}
	
	// To enable the download Chrome Options
	public static Object chromeoptsDwnld(RemoteWebDriver driver)
	{
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("safebrowsing.enabled", "true"); //this is the needed configuration
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		return options;
		
		
	}
	
	
	
	}

