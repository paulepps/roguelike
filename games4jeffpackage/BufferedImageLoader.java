 

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class BufferedImageLoader {

  private BufferedImage image;

  /*takes in path to image, returns a buffered image*/
  public BufferedImage loadImage(String path){
    try{
      image = ImageIO.read(new File(path));
    } catch (IOException e){
      e.printStackTrace();
    }
    return image;
  }
}
