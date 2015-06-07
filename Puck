import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class Puck extends JPanel {
	Pads pad = new Pads();
	private static int size = 60;
	private static int x = GamePanel.WIDTH / 2;
	private static int y = GamePanel.HEIGHT / 2;
	private static int vx = 2;
	private static int vy = 2;
	private int player1_score = 0;
	private int player2_score = 0;
	private String player1Score = "0";
	private String player2Score = "0";
	private Image puck;
	
	//Keeps track of the scores
	public void pScore_1(){
		player1_score += 1;
		player1Score = Integer.toString(player1_score);
	}
	public void pScore_2(){
		player2_score += 1;
		player2Score = Integer.toString(player2_score);
	}
	
	//for when you score on the opposite player which way should the puck go
	public int regX(int d){
		vx = d;
		return vx;
	}
	
	public int regY(int d){
		vy = d;
		return vy;
	}
	
	// makes the puck move up
	public int up(){
		return vy = -2;
	}
	
	// makes the puck move down
	public int down(){
		return vy = 2;
	}
	
	// makes the puck move left
	public int left(){
	     int es1 = (int)(Math.random() * -10);
	     
	     if(es1 >= -4){
	    	 es1 = -5;
	     }
	     
		return vx = es1;
	}
	
	// makes the puck move right
	public int right(){
	     int es1 = (int)(Math.random() * 10);
	     
	     if(es1 <= 4){
	    	 es1 = 5;
	     }
	     
		return vx = es1;
	}
	
	//moves the puck
	public void move(){
		
		//starting movement
		setY(getY() + vy);
		setX(getX() + vx);
		
		puck = new ImageIcon("C:\\Users\\Javier\\Desktop\\Hockey\\puck.png").getImage();
		
		//if it hits above or below, just bounce back
		if(getY() >= GamePanel.HEIGHT - size){
			
			setY(getY() + up());
			
		}else if(getY() <= 0){
			
			setY(getY() + down());
			
		}
		
		//Reset the location of the puck once you score
	    if(getX() >= GamePanel.WIDTH){
	    	
	    	 pScore_1();
	    	 
		     setY(GamePanel.HEIGHT / 2);
		     setX(GamePanel.WIDTH / 2);
		    
		     int es1 = (int)(Math.random() * -3);
		     int es2 = (int)(Math.random() * -3);
		     
		     if(es1 >= 0){
		    	 es1 = -1;
		     }else if(es2 >= 0){
		    	 es2 = -1;
		     }
		     
	    	 regX(es1);
	    	 regY(es2);
	    	 
	    }else if(getX() <= 0){
	    	
	    	 pScore_2();
	    	 
		     setY(GamePanel.HEIGHT / 2);
		     setX(GamePanel.WIDTH / 2);
		     
		     int es1 = (int)(Math.random() * 3);
		     int es2 = (int)(Math.random() * 3);
		     
		     if(es1 <= 0){
		    	 es1 = 1;
		     }else if(es2 <= 0){
		    	 es2 = 1;
		     }
		     
	    	 regX(es1);
	    	 regY(es2);
	    	 
	    }
	    
	    //for collision (must be included in the movement method)
		collision();
		
	}
	
	//Checks whether the puck collided with the pads, if it did it will bounce back.
	public void collision(){
		
		if(thepuck().intersects(pad.getPad1())){
			
		     int es1 = (int)(Math.random() * -2);
		     
		     if(es1 >= 0){
		    	 es1 = -1;
		     }
		     
			setX(getX() + right());
			setY(getY() + es1);
			
		}else if(thepuck().intersects(pad.getPad2())){
			
		     int es2 = (int)(Math.random() * 2);
		     
		     if(es2 <= 0){
		    	 es2 = 1;
		     }
		     
			setX(getX() + left());
			setY(getY() + es2);
			
		}
	}
	
	//The puck
	public void paint(Graphics g){
		super.paint(g);
		g.setFont(new Font("Arial", Font.BOLD, 48));
		g.setColor(Color.BLACK);
		g.drawString(player1Score, 30, 550);
		
		g.setColor(Color.BLACK);
		g.drawString(player2Score, 970, 550);
		
		g.drawImage(puck, getX(), getY(), null);
		
	}
	
	// X & Y Getters/Setters
	public int getY() {
		return y;
	}
	
	public static void setY(int ay) {
		y = ay;
	}
	
	public int getX() {
		return x;
	}
	
	public static void setX(int ax) {
		x = ax;
	}
	
	public Rectangle thepuck(){
		return new Rectangle(getX(), getY(), size, size);
	}
}
