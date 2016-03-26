import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class SunUp {
	private static int xPos;
	private static int yPos;
	private static int height;
	private static int width;
	private static int xSpeed;
	private static int ySpeed;
	private ImageIcon img;


	public SunUp(int x, int y) {
		
		img = new ImageIcon("warm.png");
		height = img.getIconHeight();
		width = img.getIconWidth();
		xPos = x;
		yPos = y;
	}

	public void move() {
		
		xPos += xSpeed;
		yPos += ySpeed;	
	}

	public void setXspeed(int newSpeed) {
		xSpeed = newSpeed;
	}
	public void setYspeed(int newSpeed) {
		ySpeed = newSpeed;
	}
	
	public void delete() {
		xPos = 900;
	}

	public void change(int n, int m) {
		xPos = n;
		yPos = m;
	}

	public void paint(Graphics2D brush) {
		brush.drawImage(img.getImage(), xPos, yPos, null);
	}

	public Rectangle2D.Double getBounds() {
		return new Rectangle2D.Double(xPos, yPos, width, height);
	}

}