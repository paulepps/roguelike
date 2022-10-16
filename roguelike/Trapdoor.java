import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Trapdoor extends GameThing {

  public Trapdoor (float x, float y, String id){
    super(x, y, id);

    width = 66;
    height = 64;
  }

  public void tick(){

  }

  //right now just renders a square in the ground
  public void render(Graphics g){
    g.setColor(new Color(178,219,191));
    g.fillRect((int)x, (int)y, (int)width, (int)height);
  }

  public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, (int)width, (int)height);
  }
}
