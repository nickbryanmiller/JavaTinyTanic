import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Background {
	private static int xPos;
	private static int yPos;
	private static int height;
	private static int width;
	private ImageIcon img;


	public Background() {
		
		img = new ImageIcon("background1.png");
		height = img.getIconHeight();
		width = img.getIconWidth();
		xPos = 0;
		yPos = 0;

	}

	public void background1(){
		img = new ImageIcon("background1.png");
	}

	public void background2(){
		img = new ImageIcon("background2.png");
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