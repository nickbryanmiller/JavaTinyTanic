import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Ice2b {
	private static int xPos;
	private static int yPos;
	private static int height;
	private static int width;
	private static int xSpeed;
	private static int ySpeed = 1;
	private ImageIcon img;


	public Ice2b(int x, int y) {
		
		img = new ImageIcon("iceberg2.png");
		height = img.getIconHeight();
		width = img.getIconWidth();
		xPos = x;
		yPos = y;

	}

	public void move() {

		if (yPos == 750) {
			xPos = (int)(Math.random() * ((601) + 0));
			yPos = -20;
		}
		
		xPos += xSpeed;
		yPos += ySpeed;	
	}

	public void setXspeed(int newSpeed) {
		xSpeed = newSpeed;
	}

	public void delete() {
		xPos = 900;
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