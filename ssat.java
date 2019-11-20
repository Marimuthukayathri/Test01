package test02;

public class ssat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 1;
		//this is outside of the private void button1_click
		 String newpass = "Merrill@TCC"; 
		
		  newpass = newpass.replace(String.format("{0}@", i - 1), "@"); 
		 
		System.out.println(newpass);
		
		 int wi = 0; //this is outside of the private void button1_click
		 String newpass1 = "Merrill_TCC"; 
		 int pos = newpass.lastIndexOf("_");
	        String str2 = newpass.substring(pos);
	        String str3 = newpass.substring(0, newpass.lastIndexOf("_")); 
	        newpass = str3 + i++ + str2;
		
		
	}

}
