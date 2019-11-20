package test02;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

import javax.imageio.ImageIO; 
import java.io.File; 
import java.io.IOException; 
  
public class imgcmpr {
 
    public static void main(String[] args) throws IOException { 
      
     //   BufferedImage img1 = null; 
      //  BufferedImage img2 = null; 
 
        File fileA = new File("C:\\Users\\c906128\\Desktop\\qr1.jpg");
            File fileB =  new File("C:\\\\Users\\\\c906128\\\\Desktop\\qr3.jpg");    
           
            BufferedImage 	img1 = ImageIO.read(fileA); 
            BufferedImage img2 = ImageIO.read(fileB); 
         
           bufferedImagesEqual(img1, img2); 
        
           
    }  
        static boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
            if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
                for (int x = 0; x < img1.getWidth(); x++) {
                    for (int y = 0; y < img1.getHeight(); y++) {
                        if (img1.getRGB(x, y) != img2.getRGB(x, y))
                            return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        }
                  
   
     
} 
    
    
    
    
    
    
    