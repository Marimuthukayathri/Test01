package test02;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.Assert;

public class imgverify {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File fileInput = new File("C:\\\\\\\\Users\\\\\\\\c906128\\\\\\\\Desktop\\\\\\\\qr1.png");
	       File fileOutPut = new File("C:\\\\Users\\\\c906128\\\\Desktop\\\\qr2.png");   

	       BufferedImage bufferfileInput = ImageIO.read(fileInput);
	       DataBuffer bufferfileInput1 = bufferfileInput.getData().getDataBuffer();
	       int sizefileInput = bufferfileInput1.getSize();                     
	       BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
	       DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer(); 
	       int sizefileOutPut = datafileOutPut.getSize();
	       Boolean matchFlag = true;
	       System.out.println(sizefileInput);
	       System.out.println(sizefileOutPut);
	       
	       if(fileInput.exists()) {
	         for(int i=0; i<sizefileInput;  i++) {
	        	   if(bufferfileInput1.getElem(i) != datafileOutPut.getElem(i)) {
	                     matchFlag = false;
	                     Assert.assertTrue(matchFlag, "Images are not same"); 
	                     System.out.println("Images are not same");  
	                      break;
	               }
	        	 } 
	       }   
	             
	         
	      
	       else
	       
	        {                           
	          matchFlag = true;
	       Assert.assertTrue(matchFlag, "Images are same"); 
	       System.out.println("Images are same"); 
	    }

    }
}
