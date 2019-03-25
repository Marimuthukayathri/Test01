package test02;

import org.testng.annotations.Test;

public class setprior {

	@Test(priority=1)
	
	public void method1() {
	
		System.out.println("priority is 1");
	 }
	
	 
	
	@Test(enabled = false)
	
	public void method2() {
		
		System.out.println("priority is 2");
	
	 }
	
	 
	
	@Test(priority=0)
	
	public void method3() {
		
		System.out.println("priority is 0");
	
	 }
	
	
}
