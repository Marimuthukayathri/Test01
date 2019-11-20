package test02;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImageComparison {

	
	public WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setUp() throws Exception {

    	System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
       baseUrl = "https://www.google.co.in/";
       driver.navigate().to(baseUrl);
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);      
    }

   
    @Test
    public void testImageComparison( ) throws IOException, InterruptedException {         
    
   	//   File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   //    FileUtils.copyFile(screenshot, new File("GoogleOutput.jpg"));
    	   try {

    //	Runtime.getRuntime().exec("C:\\\\Users\\\\c906128\\\\Downloads\\\\Training Content\\\\a1.exe"); 
       
       File fileInput = new File("C:\\Users\\c906128\\Desktop\\only QR.jpg");
       File fileOutPut =  new File("C:\\\\Users\\\\c906128\\\\Desktop\\\\rerr.jpg"); 
       
       BufferedImage bufferfileInput = ImageIO.read(fileInput);
       DataBuffer bufferfileInput1 = bufferfileInput.getData().getDataBuffer();
       int sizefileInput = bufferfileInput1.getSize();  
       System.out.println(sizefileInput);
       boolean matchFlag = true;
           BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
       DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer();
       int sizefileOutPut = datafileOutPut.getSize();
       System.out.println(sizefileOutPut);
       
       if(fileInput.exists()) {
           for(int i=0; i<sizefileInput;  i++) {
          	   if(bufferfileInput1.getElem(i) != datafileOutPut.getElem(i)) {
                       matchFlag = false;
                       Assert.assertTrue(matchFlag, "Images are not same"); 
                        break;
                 }
             } 
         }   
      
    } catch (Exception e) {
    	
    	System.out.println(e.getMessage()); 
    	
    	
    }
    	   
     
    }
}