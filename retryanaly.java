package test02;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class retryanaly implements IRetryAnalyzer {
	
	
	private int retryCount = 0;
    private int maxRetryCount = 5;

    public boolean retry1 (ITestResult result) {

       if (retryCount < maxRetryCount) {
              retryCount++;
              return true;
       }
              return false;
    }

    @Test(retryAnalyzer=retryanaly.class) 
    public void testGenX() {

    	Scanner sc = new Scanner(System.in);
		//Taking noOfRows value from the user
		System.out.println("How Many Rows You Want In Your Pyramid?");
		int noOfRows = sc.nextInt();
		//Initializing rowCount with noOfRows
		int rowCount = noOfRows;
		System.out.println("Here Is Your Pyramid");
		//Implementing the logic
		for (int i = 1; i <= noOfRows; i++) {
			//Printing i*2 spaces at the beginning of each row
			for (int j = 1; j <= i*2; j++) {
				System.out.print(" ");
			}
			
			
			//Printing j where j value will be from 1 to rowCount
			for (int j = 1; j <= rowCount; j++) {
				System.out.print(j+" ");
			}
			
			//Printing j where j value will be from rowCount-1 to 1
			for (int j = rowCount-1; j >= 1; j--) {
				System.out.print(j+" ");
			}
			
			
			System.out.println();
			//Decrementing the rowCount
			rowCount--;
			
		}   
    }

    @Test(retryAnalyzer = calendar.class) 
    public void testGenY() {

           // ListenerTest fails
           Assert.assertEquals("World", "World");
    }

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}
}
	


