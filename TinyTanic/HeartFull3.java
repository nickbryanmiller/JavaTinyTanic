import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class HeartFull3 {
	private static int xPos;
	private static int yPos;
	private static int height;
	private static int width;
	private ImageIcon img;


	public HeartFull3(int x, int y) {
		
		img = new ImageIcon("heartfull.png");
		height = img.getIconHeight();
		width = img.getIconWidth();
		xPos = x;
		yPos = y;
	}

	public void switcher(){
		img = new ImageIcon("heartempty.png");
	}
	public void switcher2(){
		img = new ImageIcon("heartfull.png");
	}

	public void switchtj(){
		img = new ImageIcon("tj.png");
	}

	public void paint(Graphics2D brush) {
		brush.drawImage(img.getImage(), xPos, yPos, null);
	}

	public Rectangle2D.Double getBounds() {
		return new Rectangle2D.Double(xPos, yPos, width, height);
	}

}