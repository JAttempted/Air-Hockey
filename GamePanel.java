import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	
	static final int WIDTH = 1250;
	static final int HEIGHT = 600;
	
	Pads pads = new Pads();
	Puck puck = new Puck();
	
	public GamePanel(){
		
		this.setFocusable(true);
		
		// adds the keylistener
		this.addKeyListener(
				new KeyListener(){
					
					//for when you press the key, what should happen
					public void keyPressed(KeyEvent e){
						switch(e.getKeyCode()){
						case KeyEvent.VK_UP:
								Pads.pad2_up();
								break;
						case KeyEvent.VK_DOWN:
								Pads.pad2_down();
								break;
						case KeyEvent.VK_LEFT:
								Pads.pad2_left();
								break;
						case KeyEvent.VK_RIGHT:
								Pads.pad2_right();
								break;
						case KeyEvent.VK_W:
								Pads.pad1_up();
								break;
						case KeyEvent.VK_S:
								Pads.pad1_down();
								break;
						case KeyEvent.VK_A:
 							    Pads.pad1_left();
								break;
						case KeyEvent.VK_D:
								Pads.pad1_right();
						        break;
						default:
								break;
						}
					}
					// when you release the key, what should happen
					public void keyReleased(KeyEvent e) {
						switch (e.getKeyCode()){
							case KeyEvent.VK_UP:
							case KeyEvent.VK_DOWN:
								Pads.pad2_release();
								break;
							case KeyEvent.VK_LEFT:
							case KeyEvent.VK_RIGHT:
								Pads.pad2_release2();
								break;
							case KeyEvent.VK_W:
							case KeyEvent.VK_S:
								Pads.pad1_release();
								break;
							case KeyEvent.VK_A:
							case KeyEvent.VK_D:
								Pads.pad1_release1();
								break;
							default:
								break;
						}
					}
					public void keyTyped(KeyEvent arg0) {}
				}
		);
		
		//Just incase you wanna interact with the puck on screen, for fun lol
		this.addMouseMotionListener(
				new MouseMotionAdapter(){
					public void mouseDragged(MouseEvent e){
							Puck.setY(e.getY());
							Puck.setX(e.getX());
					}
				}
		);
	}
	
	//paints the background, pads, and the puck, (the background comes with the pads)
	public void paint(Graphics g){
		
		pads.paint(g);
		puck.paint(g);
		
	}
	
	//for when you move the pads or puck
	public void move() {
		
		pads.move_pads();
	    puck.move();
	    
	}
}
