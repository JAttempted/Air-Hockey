import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main{
	static JFrame frame = new JFrame();
	
	public static void main(String args[]){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(GamePanel.WIDTH,GamePanel.HEIGHT);
		frame.setLocationRelativeTo(null);
	    frame.setUndecorated(true);
		
		theGame();
	}
	
	public static void theGame(){
		GamePanel game = new GamePanel();
		
		//ever 5 milliseconds it will repaint the whole game(puck, pads, background) etc..
		Timer tm = new Timer(
			5, new ActionListener(){
				public void actionPerformed(ActionEvent e){
					game.move();
					game.repaint();
				}
			}
		);
		
		game.setVisible(true);
		frame.add(game);
		frame.setVisible(true);
		
		tm.start();
	}
}
