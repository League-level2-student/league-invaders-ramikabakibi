import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame=new JFrame();
	GamePanel panel;
	public static final int WIDTH=800;
	public static final int HEIGHT=800;
	LeagueInvaders() {
		frame=new JFrame();
		panel=new GamePanel();
		
	}
	void setup() {
		frame.add(panel);
		frame.setSize(LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	


}
