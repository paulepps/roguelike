

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	private Screen screen;
  private Main main;
	private boolean [] keyDown = new boolean [4];

	public KeyInput(Handler handler, Screen screen, Main main){
		this.handler = handler;
		this.screen = screen;
    this.main = main;

		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}

	/* ran whenever a key is pressed */
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode(); //get what the key pressed is
		for(int i = 0; i < handler.stuff.size(); i++){
			GameThing thing = handler.stuff.get(i);
			if (thing.getId() == "Player"){
				//takes in the key and changes the player's velocity depending on key input
				if (screen.getMovement()){
					if (key == KeyEvent.VK_W) {thing.setVelY(-4*screen.getSpeedMod()); keyDown[0]=true;}
					if (key == KeyEvent.VK_S) {thing.setVelY(4*screen.getSpeedMod()); keyDown[1]=true;}
					if (key == KeyEvent.VK_D) {thing.setVelX(4*screen.getSpeedMod()); keyDown[2]=true;}
					if (key == KeyEvent.VK_A) {thing.setVelX(-4*screen.getSpeedMod()); keyDown[3]=true;}
				}
			}
		}
		if (key == KeyEvent.VK_SPACE){
			screen.changeWeapon(); //changes weapon when space pressed
		}
		if (key == KeyEvent.VK_R){
			screen.reload(); //reloads weapon when R pressed
		}
    if (key == KeyEvent.VK_P){
      main.togglePause();
    }
	}

	/* ran when keys are pressed */
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.stuff.size(); i++){
			GameThing thing = handler.stuff.get(i);
			if (thing.getId() == "Player"){
				//stops the player's movement when keys are released
				if (key == KeyEvent.VK_W){ keyDown[0]=false;}
				if (key == KeyEvent.VK_S) { keyDown[1]=false;}
				if (key == KeyEvent.VK_D) { keyDown[2]=false;}
				if (key == KeyEvent.VK_A) { keyDown[3]=false;}
				if(!keyDown[0] && !keyDown[1]) thing.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) thing.setVelX(0);
			}
		}
	}
}
