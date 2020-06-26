import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    Rocketship rocket=new Rocketship(250,700,50,50, 5);
    GamePanel(){
    	frameDraw=new Timer(1000/60, this);
    	frameDraw.start();
    }
    void updateMenuState() {  
    	
    }
    void  updateGameState() {  
    	rocket.update();
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
	   g.setFont(spaceFont);
	   g.setColor(Color.YELLOW);
	   g.drawString("Press SPACE for instructions", 200, 600);

   }
   void  drawGameState(Graphics g) {  
	   g.setColor(Color.BLACK);
	   g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	   rocket.draw(g);
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
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		if(currentState==GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    rocket.up();
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    rocket.down();;
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    rocket.left();;
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			    rocket.right();
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
