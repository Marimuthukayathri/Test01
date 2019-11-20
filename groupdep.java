package test02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class groupdep {

	@Test(groups = "groupA")
    public void testMethod1ForGroupA() { 
    	System.out.println("Running test method1 of groupA");
    }
     
    @Test(groups = "groupA1")
    public void testMethod1ForGroupA1() {
    	System.out.println("Running test method2 of groupA");
    	Assert.assertFalse(true); 
    }
     
    @Test(dependsOnGroups = "groupA")
    public void dependentTestOnGroupA() {
    	System.out.println("Running the dependent test");
    	
    	Assert.assertFalse(false, "message"); 
    }
}

