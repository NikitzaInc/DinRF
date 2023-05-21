
package project;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class kartinki {
    // method to load image from jar archive
    public static BufferedImage loadResourceImage(String fileName){
        try{
            return ImageIO.read(kartinki.class.getResourceAsStream(fileName));
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        return null; 
    }            
}
