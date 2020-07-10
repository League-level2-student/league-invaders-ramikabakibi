import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
Rocketship crewDragon;
ArrayList<Projectile> projectiles=new ArrayList<Projectile>();
ArrayList<Alien> aliens=new ArrayList<Alien>();
Random random=new Random();
	ObjectManager( Rocketship rocketship ){
		crewDragon = rocketship;
	}
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for(int i=0; i<aliens.size();i++) {
			aliens.get(i).update();
			if(aliens.get(i).y>LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive=false;
			}
		}
		for(int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).update();
			if(projectiles.get(i).y<0) {
				projectiles.get(i).isActive=false;
			}
		}
	}
	void draw(Graphics g) {
		crewDragon.draw(g);
		for(int i=0; i<aliens.size();i++) {
			aliens.get(i).draw(g);
	}
		for(int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).draw(g);
}
}
	void purgeObjects() {
		for(int i=0; i<aliens.size();i++) {
			if(aliens.get(i).isActive==false) {
				aliens.remove(aliens.get(i));
			}
		}
		for(int i=0; i<projectiles.size(); i++) {
			if(projectiles.get(i).isActive==false) {
				projectiles.remove(projectiles.get(i));
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}

//2. Make a constructor for this class that takes a Rocketship parameter
//and use it to initialize the member variable created above.