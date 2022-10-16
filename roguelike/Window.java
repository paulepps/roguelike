

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -610221877235495921L;
	private String state = "menu";
	private JFrame frame;
	private Main main;

	public Window(int width, int height, String title, Main main){
		frame = new JFrame(title); //set window title
		this.main = main;

		//set size of window
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		//set settings of window
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//add game to the window
		frame.add(main);
		frame.setVisible(true);
		main.start();

	}

	/*if the player isn't in the menu, clear the current cursor*/
	public void tick(){
		state = main.getState();
		if (!state.equals("menu") && !state.equals("pause") && !state.equals("death"))
			try {
				frame.setCursor(frame.getToolkit().createCustomCursor(ImageIO.read(getClass().getResource("assets/blank.png")), new Point(), null));
			} catch (Exception e) {
				e.printStackTrace();
			}
	    else 
			frame.setCursor(Cursor.getDefaultCursor());
	}
}
