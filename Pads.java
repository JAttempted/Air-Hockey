import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Pads extends JPanel{
	
	private static int pad_width = 100;
	private static int pad_height = 100;
	
	private static int pad1_x = 1;
	private static int pad1_y = GamePanel.HEIGHT / 2;
	private static int pad2_x = GamePanel.WIDTH - pad_width - 1;
	private static int pad2_y = GamePanel.HEIGHT / 2;

	private static int speed1 = 0;
	private static int speed2 = 0;
	private static int speed3 = 0;
	private static int speed4 = 0;
	
	private Image pad1;
	private Image pad2;
	private Image background;
	
	//Getters for when you press the key, down & up
	public static int pad1_up(){
		return speed1 = -3;
	}
	public static int pad1_down(){
		return speed1 = 3;
	}
	public static int pad2_up(){
		return speed2 = -3;
	}
	public static int pad2_down(){
		return speed2 = 3;
	}
	
	//Right & left
	public static int pad1_left(){
		return speed3 = -2;
	}
	public static int pad1_right(){
		return speed3 = 2;
	}
	public static int pad2_left(){
		return speed4 = -2;
	}
	public static int pad2_right(){
		return speed4 = 2;
	}
	
	// Getters for when you release the key
	public static int pad1_release(){
		return speed1 = 0;
	}
	public static int pad2_release(){
		return speed2 = 0;
	}
	public static int pad1_release1(){
		return speed3 = 0;
	}
	public static int pad2_release2(){
		return speed4 = 0;
	}
	
	public void move_pads(){
		
		//starting movement for pad 1 & pad 2
		
	    pad1_y += speed1;
		pad2_y += speed2;
		
		pad1_x += speed3;
		pad2_x += speed4;
		
		background = new ImageIcon("C:\\Users\\Javier\\Desktop\\Hockey\\background.png").getImage();
		pad1 = new ImageIcon("C:\\Users\\Javier\\Desktop\\Hockey\\pad1.png").getImage();
		pad2 = new ImageIcon("C:\\Users\\Javier\\Desktop\\Hockey\\pad2.png").getImage();
		
		//if pad1 hits top wall
	    if(pad1_y + pad_height > GamePanel.HEIGHT){
	    	
	    	speed1 = -1;
	  
	    //if pad1 hits bottom wall
	    }else if(pad1_y <= 0){
	    	
	    	speed1 = 1;
	    	
	    }
	    
	    //if the pad2 hits top wall
	    if(pad2_y + pad_height >= GamePanel.HEIGHT){
	    	
	    	speed2 = -1;
		
	    //if pad2 hits bottom wall
	    }else if(pad2_y <= 0){
	    	
	    	speed2 = 1;
	 
	    }
	    
		//if pad1 hits right wall
	    if(pad1_x + pad_width >= GamePanel.WIDTH){
	    	
	    	speed3 = -1;
	    	
	    //if pad1 hits left wall
	    }else if(pad1_x <= 0){
	    	
	    	speed3 = 1;
	    	
	    }
	    
	    //if the pad2 hits right wall
	    if(pad2_x + pad_width >= GamePanel.WIDTH){
	    	
	    	speed4 = -1;
		
	    //if pad2 hits left wall
	    }else if(pad2_x <= 0){
	    	
	    	speed4 = 1;
	 
	    }
	    

	}
	
	//This is for collision purposes, aka if the puck hits the pad, bounce the puck back
	public Rectangle getPad1(){
		return new Rectangle(pad1_x, pad1_y, pad_width, pad_height);
	}
	
	public Rectangle getPad2(){
		return new Rectangle(pad2_x, pad2_y, pad_width, pad_height);
	}
	
	//Draws both of the pads
	public void paint(Graphics g){
		super.paint(g);
		//the Background
		g.drawImage(background, 0, 0, null);
		
		//Pad 1
		g.drawImage(pad1, pad1_x, pad1_y, null);
		
		//Pad 2
		g.drawImage(pad2, pad2_x, pad2_y, null);
	}
	
}
