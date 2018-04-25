

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Mine extends GameThing{

  private Chicken chicken;
  private Handler handler;
  private Screen screen;
  private int timer = 0;

  public Mine(float x, float y, String id, Handler handler, Chicken chicken, Screen screen){
    super(x, y, id);
    this.chicken = chicken;
    this.handler = handler;
    this.screen = screen;

    width = 12;
    height = 12;
  }

  public void tick(){
    x += velX;
    y += velY;
    timer++;
    if (timer == 200){ //explode after 200 ticks
      explode();
    }
  }

  /*adds an explosion at current location*/
  public void explode(){
    handler.addObject(new Explosion(x+width/2, y+height/2, "Explosion", handler, 10, "Enemy"));
    handler.removeObject(this);
  }

  public void render(Graphics g){
    g.setColor(new Color(67, 119, 139));
    g.fillRect((int)x, (int)y, (int)width, (int)height);
    if (handler.stuff.contains(chicken)){
      chicken.render(g); //render chicken over the mine if it still exists
    }
  }

  public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, (int)width, (int)height);
  }

}
