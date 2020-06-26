import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
Alien(int x, int y, int width, int height, int speed){
	super(x, y, width, height, speed);
}

	void update() {
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
	}
}
