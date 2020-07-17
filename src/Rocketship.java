import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	int xspeed = 0;
	int yspeed = 0;
	public static BufferedImage image = null;
	public static boolean needImage = true;
	public static boolean gotImage = false;	


	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
		    loadImage ("rocket.png");
		}
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
} 

	void update() {
		if (x + xspeed <= LeagueInvaders.WIDTH - width && x + xspeed >= 0) {
			x += xspeed;
		}
		if (y + yspeed <= LeagueInvaders.HEIGHT - height - 25 && y + yspeed >= 0) {
			y += yspeed;
		}
		super.update();
	}

	public void right() {
		xspeed = speed;
	}

	public void left() {
		xspeed = -speed;
	}

	public void down() {
		yspeed = speed;
	}

	public void up() {
		yspeed = -speed;
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
	
}
