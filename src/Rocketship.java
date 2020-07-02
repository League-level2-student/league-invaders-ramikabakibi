import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int xspeed = 0;
	int yspeed = 0;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}

	void update() {
		if (x + xspeed <= LeagueInvaders.WIDTH - width && x + xspeed >= 0) {
			x += xspeed;
		}
		if (y + yspeed <= LeagueInvaders.HEIGHT - height - 25 && y + yspeed >= 0) {
			y += yspeed;
		}

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
}
