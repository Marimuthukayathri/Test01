package test02;

import java.util.Scanner;

public class rev1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		//Taking noOfRows value from the user
		System.out.println("enter the string to reverse"); 
		
		String n = sc.nextLine();// //take a input value
		String rev = "" ; 
		
		
		for (int i=n.length()-1; i>=0; i--) {
		
		rev = rev + n.charAt(i);
				
		}
		System.out.println(rev); 
	}

}
