package test02;

public class regeex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*String s = " A ";
		String s2 = "Corporate Documents of the Company";
		
		s = s + s2;
		
		System.out.println(s);
		
		s = s.replaceAll("\\s", "");
		
		System.out.println(s);
		
		*/
		
		String regex = "\\s++$";
        
		String originalString1 = "howtodoinjava.com";    //3 leading spaces
		String originalString2 = "howtodoinjava.com   "; //3 leading and trailing spaces
		 
		String trimmedString1 = originalString1.replaceAll(regex, "");
		String trimmedString2 = originalString2.replaceFirst(regex, "");
		 
		System.out.println(trimmedString1);
		System.out.println(trimmedString2);
			   
		   
		
		
	/*	
		String str = "The State of the water = 'ICE'";
		str = str.replaceAll("'","");
		System.out.println(str); 
		
		String example = "The Value'sd is not valid value";

		String[] returnValues = example.split("'");  
		String temp1 = returnValues[0];
		String temp2 = returnValues[1];
		
		
		System.out.println(temp1+ "\n"+ temp2); */
		
	}

}
