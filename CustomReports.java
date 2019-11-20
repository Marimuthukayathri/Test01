package frameworkCore;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
//import org.testng.ITestResult;
import org.testng.log4testng.Logger;

//import com.relevantcodes.extentreports.HTMLReporter;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaEntityModelProvider;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.Configuration;
//import org.testng.asserts.SoftAssert;

public class CustomReports {
	public static ExtentReports extent;
	public static ExtentTest logger;
	//public static ExtentHtmlReporter htmlReports;
	static String filePath;
	static final Logger log = Logger.getLogger(CustomReports.class);
    static String envExecStatus;

    // To start the report
	public static void startReport() {

		String strCurDate = new SimpleDateFormat("yyyyMMdd_HH_mm_ss").format(new Date());
		filePath = "./execution_Reports/JMS_Automation_Execution_report_"+strCurDate+".html";// +strCurDate+".html";
		// String sourcePath = ".\\log4j.properties";//System.getProperty("user.dir")
		// +"\\log4j.properties";
		// PropertyConfigurator.configure(sourcePath);
		
		extent = new ExtentReports(filePath, true);

		extent
				// .addSystemInfo("Host Name", "CI")
				.addSystemInfo("Application", "JMS").addSystemInfo("User Name", "Sudharson");
		extent.loadConfig(new File("./config.xml"));

	}

	
	// To start the test
	public static void strtTest(String Tc_Name) {

		logger = extent.startTest(Tc_Name);
		

	}

	//To print the status, steps and Description
	public static void print_Report(String strStatus, String strStep, String strDesc) throws IOException {

		System.out.println(strStatus + "--->" + strStep + ": " + strDesc);
		if (strStatus.toUpperCase().equals("PASS")) {
			logger.log(LogStatus.PASS, strStep, strDesc);

		} else if (strStatus.toUpperCase().equals("FAIL")) {
			logger.log(LogStatus.FAIL, strStep, strDesc);
			envExecStatus = "Fail";
		} else if (strStatus.toUpperCase().equals("INFO")) {
			logger.log(LogStatus.INFO, strStep, strDesc);

		} else if (strStatus.toUpperCase().equals("WARNING")) {
			logger.log(LogStatus.WARNING, strStep, strDesc);

		}
	}

	//To end the report
	public static void endReport() {
		
		extent.flush();
		extent.endTest(logger);
	}
	
	//To have the recent reports in the recent_execution_Reports
	public static void copy_LatestReport(){
		try {
			File source = new File(filePath);			
			File dest = new File("./recent_execution_Reports/JMS_Automation_Execution_report.html");
			if(dest.exists()) 
				dest.delete();
			FileUtils.copyFile(source, dest);
			
			if(envExecStatus.equals("Fail")) {
				
				Assert.fail();
				
	        }
		}catch(Exception e) {
			System.out.println(e);
		} 
	}
	
    // To take the Screen shot
	public static String takeSnap() throws WebDriverException, IOException {
		String Sharepath;
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; // Snapshort for unique Name

		String destination = System.getProperty("user.dir") + "/recent_execution_Reports/reports/images/" + number + ".jpg";
		/*System.out.println(destination);
		System.out.println(System.getProperty("user.dir"));*/
		String name = getSystemName();
		File finalDestination = new File(destination);
		FileUtils.copyFile(LoadDriver.driver.getScreenshotAs(OutputType.FILE), finalDestination);
		if((name.equalsIgnoreCase("P94833CHE") || name.equalsIgnoreCase("ind00191ch")))
		 Sharepath = System.getProperty("user.dir") + "/recent_execution_Reports/reports/images/" + number + ".jpg";
		 //"file://"+name+"/Users/111527/git/JMS_Automation_Suite/recent_execution_Reports/reports/images/" + number + ".jpg"; 
		else
			Sharepath = "file://"+name+"/recent_execution_Reports/reports/images/" + number + ".jpg";
		// To open the screenshots in different machine
		return Sharepath;
	}
	
	// To get the system name
	public static String  getSystemName(){  
	    try{
	        InetAddress inetaddress=InetAddress.getLocalHost(); //Get LocalHost refrence
	        String name = inetaddress.getHostName(); //Get Host Name
	       // System.out.println(name);
	      return name;
	    }
	    catch(Exception E){
	        E.printStackTrace();  //print Exception StackTrace
	        return null;
	    }
		
	}
	
	

}
