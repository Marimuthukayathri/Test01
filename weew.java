package test02;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class weew {


public String baseURL = "http://www.javascripttoolbox.com/lib/mktree/";

 public static WebDriver driver;
 @BeforeMethod
 public void setup()
 {
	 
	 System.setProperty("webdriver.chrome.driver", "C:\\DataSite Test QA\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
  driver.get(baseURL);
 }

 @AfterMethod
 public void tear()
 {
  driver.quit();
 }

 @Test
 public void testTreeStructure() throws InterruptedException
 {
  driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td[1]/div[2]/div[2]/p[6]/a[2]")).click();
  Thread.sleep(3000);
  List<WebElement> roots = driver.findElements(By.xpath(".//*[@id='tree1']/li"));
  int rootSize = 1;
  for(WebElement root: roots)
  {
   String openRoot = root.getAttribute("class");
   if(openRoot.equalsIgnoreCase("liClosed"))
   {
    String xpath = ".//*[@id='tree1']/li["+rootSize+"]/span";
    openTree(xpath);
    List<WebElement> childRoots = driver.findElements(By.xpath(".//*[@id='tree1']/li["+rootSize+"]/ul/li"));
    int subRootSize = 1;
    for(WebElement childRoot: childRoots)
    {
     String openSubRoot = childRoot.getAttribute("class");
     if(openSubRoot.equalsIgnoreCase("liClosed"))
     {
      String path = ".//*[@id='tree1']/li["+rootSize+"]/ul/li["+subRootSize+"]/span";
      openTree(path);
     }
     subRootSize = subRootSize+1;
    }
   }
   rootSize = rootSize+1;
  }
 }

 public void openTree(String xpath) throws InterruptedException
 {
  driver.findElement(By.xpath(xpath)).click();
  Thread.sleep(3000);
 }
 
 
 
 
}