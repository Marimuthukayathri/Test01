package test02;

import java.util.Scanner;

public class pyram {

	public static void main(String[] args) {
		
				
		Scanner sc = new Scanner(System.in);
		//Taking noOfRows value from the user
		System.out.println("How Many Rows You Want In Your Pyramid?");
		int rows = sc.nextInt();
		//Initializing rowCount with noOfRows
		//int rowCount = noOfRows;
		System.out.println("Here Is Your Pyramid");
		//Implementing the logic
		 for (int i = 1; i <= rows; i++)
	        {
	            for (int j = rows; j > i; j--)
	            {
	                System.out.print(" ");
	            }
	            for (int k = 1; k <= i; k++)
	            {
	                System.out.print(k);
	            }
	            for (int l = i - 1; l >= 1; l--)
	            {
	                System.out.print(l);
	            }
	            System.out.println();
			
			
		}   
		
	}

}


