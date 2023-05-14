
package project;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class kartinki {
    // метод для загрузки изображения из jar архива 
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
