package test02;

public class strfmt {

	public static void main(String[] args) {
		
		String value = "Hello_1";
		int Value = Integer.parseInt(value.replaceAll("[^0-99]", "")); // returns 123	
		System.out.println(Value);
		Value++;
		System.out.println(Value);
		String value1 = "Hello_"+Value;
		System.out.println(value1);
		
	}	
		
	}