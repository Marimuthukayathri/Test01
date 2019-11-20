package test02;

import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int b;// take a variable to perform Reverse operation
		Scanner sc = new Scanner(System.in);
		//Taking noOfRows value from the user
		System.out.println("enter the number to reverse"); 
		int n = sc.nextInt();// //take a input value
        System.out.print("Reverse the Number is ");
        for (int a = n; a > 0; a = a / 10)// condition for Reverse the number
        {
            b = a % 10;
            System.out.print(b);
        }
    }
}		
		
		
	/*	 int i,j,n;
		 Scanner sc = new Scanner(System.in);
		     System.out.println("Enter the no of lines");
		     n = sc.nextInt();
		    
		 for(i=n; i>=1; i--)  
		     {
		         for(j=i; j<=n; j++)   
		         {
		             System.out.print(" "); 
		         }
		         
		         
		         for(j=1; j<=(2*i)-1; j++)
		         {
		             System.out.print(j+ " ");
		         }
		         
		         System.out.println(" ");
		     } 
*/
	


