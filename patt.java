package test02;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String s = "   n    or  15  2    ";

		    Pattern pattern = Pattern.compile("[a-z-0-9]\\s+[a-z-0-9]", Pattern.CASE_INSENSITIVE); 

		    Matcher m = pattern.matcher(s);

		        while(m.find()){
		        String replacestr = "";


		        int i = m.start();
		            while(i<2){
		                replacestr = replacestr + s.charAt(i);
		                i++;
		            }

		            m = pattern.matcher(s);
		        }

		        System.out.println(s);
		
		
	}

}
