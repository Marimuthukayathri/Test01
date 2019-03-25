package test02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class deptest {

	@Test
    public void parentTest() { 
      System.out.println("Running parent test.");
   //   Assert.fail();
    }
   
    @Test(dependsOnMethods={"parentTest"}) 
    public void dependentTest() { 
      System.out.println("Running dependent test.");
    } 

}
