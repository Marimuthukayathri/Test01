package test02;

import org.testng.annotations.Test;

public class excep {

	
	 int num1, num2;
	 
	 @Test
	 
	public void exceptest() {  
     try
     {
        /* We suspect that this block of statement can throw 
         * exception so we handled it by placing these statements
         * inside try and handled the exception in catch block
         */
        num1 = 0;
        num2 = 62 % num1;
        System.out.println(num2);
        System.out.println("Hey I'm at the end of try block");
     } 
     
	      catch (Exception e) { 
	    	  
	    	  System.out.println(e.getMessage());
        /* This block will only execute if any Arithmetic exception 
         * occurs in try block
         */
    //   System.out.println("You should not divide a number by zero");
     }


  
  }

}


	
	

