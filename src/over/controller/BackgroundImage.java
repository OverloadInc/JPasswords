package over.controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackgroundImage {
    private static String name = null;
    
    public static void setName(String name) {
        BackgroundImage.name = name;
    }
    
    public static String getName() {
        return name;
    }
    
    public static Image request() {
        Image targetImage = null;
        
        String workingDirectory = "src" + File.separator + "over" + File.separator + "resources" + File.separator + "img" + File.separator + "wallpaper" + File.separator + name;
        
        try {
            targetImage = ImageIO.read(new File(workingDirectory));            
        }
        catch (IOException e) {
        }

        return targetImage;
    }
}