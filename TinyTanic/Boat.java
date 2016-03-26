import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Boat {
	private static int xPos;
	private static int yPos;
	private static int height;
	private static int width;
	private static int xSpeed;
	private static int ySpeed;
	private ImageIcon img;


	public Boat() {
		
		img = new ImageIcon("boat.png");
		height = img.getIconHeight();
		width = img.getIconWidth();
		xPos = 250;
		yPos = 575;

	}

	public void move() {
		
		if (xPos <= -5) {
			setXspeed(0);
			xPos = xPos + 5;
		}
		if (xPos >= 505) {
			setXspeed(0);
			xPos = xPos - 5;
		}
		if (yPos >= 580) {
			setYspeed(0);
			yPos = yPos - 5;
		}
		if (yPos <= 0) {
			setYspeed(0);
			yPos = yPos + 5;
		}
		xPos += xSpeed;
		yPos += ySpeed;	
	}		

	public void setXspeed(int newSpeed) {
		xSpeed = newSpeed;
	}

	public void setYspeed(int newSpeed) {
		ySpeed = newSpeed;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getX() {
		return xPos;
	}

	public void paint(Graphics2D brush) {
		brush.drawImage(img.getImage(), xPos, yPos, null);
	}

	public Rectangle2D.Double getBounds() {
		return new Rectangle2D.Double(xPos, yPos, width, height);
	}

}