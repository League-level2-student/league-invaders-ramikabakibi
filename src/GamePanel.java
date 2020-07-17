import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont =new Font("Arial", Font.PLAIN, 48);
    Font enterFont=new Font("Arial", Font.PLAIN, 30);
    Font spaceFont=new Font("Arial", Font.PLAIN, 30);
    Timer frameDraw;
    Timer alienSpawn;
    Rocketship rocket=new Rocketship(250,700,50,50);
    ObjectManager manager=new ObjectManager(rocket);
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;	
    GamePanel(){
    	frameDraw=new Timer(1000/60, this);
    	frameDraw.start();
    	if (needImage) {
    	    loadImage ("space.png");
    	}
    }
    void startGame() {
    	alienSpawn=new Timer(1000,manager);
    	alienSpawn.start();
    }
    void updateMenuState() {  
    	
    }
    void  updateGameState() {  
    	rocket.update();
    	manager.update();
    	if(rocket.isActive==false) {
    		currentState=END;
    	}
    }
    void updateEndState()  {  
    	
    }
   void drawMenuState(Graphics g) {  
	   g.setColor(Color.BLUE);
	   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	   g.setFont(titleFont);
	   g.setColor(Color.YELLOW);
	   g.drawString("LEAGUE INVADERS", 200, 150);
	   g.setFont(enterFont);
	   g.setColor(Color.YELLOW);
	   g.drawString("Press ENTER to start", 250, 400);
	   

   }
   void  drawGameState(Graphics g) {  
	   if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
	   manager.draw(g);
	   g.setFont(new Font("Arial", Font.PLAIN, 20));
	   g.setColor(Color.WHITE);
	   g.drawString("Score: "+manager.getScore(),100,50);
   }
   void  drawEndState(Graphics g)  { 
	   g.setColor(Color.RED);
	   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	   g.setFont(titleFont);
	   g.setColor(Color.BLACK);
	   g.drawString("Game Over", 250, 150);
	   g.setFont(spaceFont);
	   g.setColor(Color.BLACK);
	   g.drawString("Press ENTER to restart", 250, 600);
	   g.setFont(spaceFont);
	   g.setColor(Color.BLACK);
	   g.drawString("Score: "+manager.getScore() , 300, 350);
   }
   void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END){
		    	currentState = MENU;
		    	rocket=new Rocketship(250,700,50,50);
		    	manager=new ObjectManager(rocket);
		    } 
		    else {
		        currentState++;
		        if(currentState==GAME) {
		        	startGame();
		        }
		        if(currentState==END) {
		        	alienSpawn.stop();
		        }
		        
		    }
		}   
		if(currentState==GAME) {
			
			
			
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    rocket.up();
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    rocket.down();
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    rocket.left();
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			    rocket.right();
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				manager.addProjectile(rocket.getProjectile());
			}
			
			
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT ||e.getKeyCode()==KeyEvent.VK_LEFT ) {
			rocket.xspeed=0;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP|| e.getKeyCode()==KeyEvent.VK_DOWN) {
			rocket.yspeed=0;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
