import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

	
public class TinyTanic {

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Welcome to TinyTanic!" + "\nDirections: " + "\nTo learn about the game press 'L'" + "\nTo see the rules press 'R'");
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,800);
        frame.setTitle("TinyTanic");
        frame.setResizable(false);
        frame.add(new GamePanel());
        frame.setVisible(true);
        
        Music music = new Music();
        try {
			music.playTheme();
		}
		catch(Exception ex) {
		}
	}

	private static class GamePanel extends JPanel {

		Boat boat;
		Ice1 ice1;
		Ice1b ice1b;
		Ice2 ice2;
		Ice2b ice2b;
		Ice3 ice3;
		Ice3b ice3b;
		Ice3c ice3c;
		Background background;
		HeartFull1 heart1;
		HeartFull2 heart2;
		HeartFull3 heart3;
		SunUp sun;
		HeartBall red;
		Music music1;
		boolean lose;
		boolean start;
		boolean isSun;
		int switcher1 = 0;
		int switcher2 = 0;
		int heartSwitcher = 0;
		int seconds = 0;
		int score;
		int lives;
		int sunner = 0;
		int hearter = 0;
		Timer timer;
		GamePanel panel;

		public GamePanel() {
			super();

			initializeGameObjects();
			
			addKeyListener(new Mover());

			setFocusable(true);	

			lose = false;
			start = false;
			isSun = false;	
		}

		public void initializeGameObjects() {
			
			boat = new Boat();
			ice1 = new Ice1(((int)(Math.random() * ((581) + 0))), -20);
			ice1b = new Ice1b(((int)(Math.random() * ((581) + 0))), -56);
			ice2 = new Ice2(((int)(Math.random() * ((581) + 0))), -5);
			ice2b = new Ice2b(((int)(Math.random() * ((581) + 0))), -17);
			ice3 = new Ice3(((int)(Math.random() * ((581) + 0))), -10);
			ice3b = new Ice3b(((int)(Math.random() * ((581) + 0))), -10);
			ice3c = new Ice3c(((int)(Math.random() * ((581) + 0))), -10);
			background = new Background();
			heart1 = new HeartFull1(25, 0);
			heart2 = new HeartFull2(225, 0);
			heart3 = new HeartFull3(425, 0);
			sun = new SunUp(((int)(Math.random() * ((501) + 100))), ((int)(Math.random() * ((401) + 300))));
			red = new HeartBall(((int)(Math.random() * ((501) + 50))), ((int)(Math.random() * ((401) + 300))));
			music1 = new Music();

			timer = new Timer(10, new GameMotion());
			timer.start();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;

			background.paint(g2);
			ice1.paint(g2);
			ice1b.paint(g2);
			ice2.paint(g2);
			ice2b.paint(g2);
			ice3.paint(g2);
			ice3b.paint(g2);
			ice3c.paint(g2);
			sun.paint(g2);
			red.paint(g2);
			boat.paint(g2);
			heart1.paint(g2);
			heart2.paint(g2);
			heart3.paint(g2);

			if (lose) {
				g2.setColor(Color.BLACK);
				g2.setFont(new Font("Serif", Font.PLAIN, 30));
				g2.drawString("GAME OVER. YOU HIT THREE ICEBERGS...", 0, 300);
				g2.drawString("FINAL SCORE: " + (score/100), 150, 400);
				timer.stop();
			}
			
		}

		private class GameMotion implements ActionListener {

			public GameMotion() {
				
			}

			public void actionPerformed(ActionEvent evt) {
				
				if (start == true) {
					if (switcher1 > 0) {
						ice1.move();
						ice2.move();
					}
					if (switcher1 > 175) {
						ice3.move();
					}
					if (switcher1 > 350) {
						ice1b.move();
						ice3b.move();
					}
					if (switcher1 > 500) {
						ice2b.move();
						ice3c.move();
					}
					switcher1++;
					score++;
					sunner++;
					hearter++;
				}
				if (switcher2 >= 0 && switcher2 < 40) {
					background.background1();
				}
				if (switcher2 >= 40 && switcher2 < 60) {
					background.background2();
				}
				if (switcher2 >= 60) {
					switcher2 = 0;
				}
				if (heartSwitcher == 1) {
					heart1.switcher();
				}
				if (heartSwitcher == 2) {
					heart2.switcher();
				}
				if (heartSwitcher == 3) {
					heart3.switcher();
					lose = true;
				}
				if (sunner < 501) {
					sun.change(900, 0);
				}
				if (sunner == 1501) {
					sun.change(((int)(Math.random() * ((401) + 50))), ((int)(Math.random() * ((401) + 300))));
				}
				if (hearter < 501) {
					red.change(900, 0);
				}
				if (hearter == 2201) {
					red.change(((int)(Math.random() * ((401) + 50))), ((int)(Math.random() * ((401) + 300))));
				}
				if (seconds == 15500) {
					seconds = 0;
				}
				if (seconds == 0) {
					try {
						music1.playTheme();
					}
					catch(Exception ex) {
					}
				}
				boat.move();
				sun.move();

				checkForHit();
				
				repaint();
				switcher2++;
				seconds++;

			}
		}


		private class Mover implements KeyListener {

			public void keyPressed(KeyEvent evt) {
				
				int key = evt.getKeyCode();

				if (key == KeyEvent.VK_LEFT) {
					boat.setXspeed(-2);
				}
				if (key == KeyEvent.VK_RIGHT) {
					boat.setXspeed(2);
				}
				if (key == KeyEvent.VK_UP) {
					boat.setYspeed(-2);
				}
				if (key == KeyEvent.VK_DOWN) {
					boat.setYspeed(2);
				}
				if (key == KeyEvent.VK_S) {
					heartSwitcher++;
				}
				if (key == KeyEvent.VK_N) {
					heartSwitcher--;
				}
				if (key == KeyEvent.VK_P) {
					timer.stop();
					JOptionPane.showMessageDialog(null, "Game paused");
				}
				if (key == KeyEvent.VK_SPACE) {
					start = true;
				}
				if (key == KeyEvent.VK_R) {
					JOptionPane.showMessageDialog(null, "Hello and Welcome to TinyTanic!" + "\nTo start the game press the spacebar" + "\nTo pause the game press 'P'" + "\nTo resume the game press 'G'" + "\nTo learn about the story press 'S'");
				}
				if (key == KeyEvent.VK_L) {
					JOptionPane.showMessageDialog(null, "I am glad you are here! It is a long voyage we have ahead of us as we sail through the Arctic.\nThese icebergs look dangerous. Our ship can only take three hits before we sink.\nYou are now our captain. Guide us through the rough seas and don't let us crash!");
				}
				if (key == KeyEvent.VK_T) {
					heart1.switchtj();
					heart2.switchtj();
					heart3.switchtj();
				}
				if (key == KeyEvent.VK_G) {
					timer.start();
				}

			}
			public void keyReleased(KeyEvent evt) {

				int keylet = evt.getKeyCode();

				if (keylet == KeyEvent.VK_LEFT) {
					boat.setXspeed(0);
				}
				if (keylet == KeyEvent.VK_RIGHT) {
					boat.setXspeed(0);
				}
				if (keylet == KeyEvent.VK_UP) {
					boat.setYspeed(0);
				}
				if (keylet == KeyEvent.VK_DOWN) {
					boat.setYspeed(0);
				}

			}
			public void keyTyped(KeyEvent evt) {}
		}

		public void checkForHit() {
			if (boat.getBounds().intersects(ice1.getBounds())) {
				ice1.delete();
				heartSwitcher++;
			}
			if (boat.getBounds().intersects(ice2.getBounds())) {
				ice2.delete();
				heartSwitcher++;
			}
			if (boat.getBounds().intersects(ice3.getBounds())) {
				ice3.delete();
				heartSwitcher++;
			}
			if (boat.getBounds().intersects(ice1b.getBounds())) {
				ice1b.delete();
				heartSwitcher++;
			}
			if (boat.getBounds().intersects(ice2b.getBounds())) {
				ice2b.delete();
				heartSwitcher++;
			}
			if (boat.getBounds().intersects(ice3b.getBounds())) {
				ice3b.delete();
				heartSwitcher++;
			}
			if (boat.getBounds().intersects(ice3c.getBounds())) {
				ice3c.delete();
				heartSwitcher++;
			}
			if (boat.getBounds().intersects(sun.getBounds())) {
				try {
					music1.playWarm();
				}
				catch(Exception ex) {
				}
				globalWarming();
				sun.change(900, 0);
				sunner = 0;
			}
			if (boat.getBounds().intersects(red.getBounds())) {
				heartSwitcher--;
				if (heartSwitcher == 2) {
					heart3.switcher2();
				}
				else if (heartSwitcher == 1) {
					heart2.switcher2();
				}
				else if (heartSwitcher == 0) {
					heart1.switcher2();
				}
				red.change(900, 0);
				hearter = 0;
			}
		}

		public void globalWarming() {
			ice1.delete();
			ice2.delete();
			ice3.delete();
			ice1b.delete();
			ice2b.delete();
			ice3b.delete();
			ice3c.delete();
		}

	}
}