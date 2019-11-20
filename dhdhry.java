package test02;

public class dhdhry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
String newpass = "MerrillTCC_55";
		
		int Value = Integer.parseInt(newpass.replaceAll("[^0-99]", "")); // returns 123	
	//	System.out.println(Value);
		Value++;
	//	System.out.println(Value);
		
		newpass = newpass.substring(0, 11); 
		 newpass = newpass+Value; 
		System.out.println(newpass);
	}

}
