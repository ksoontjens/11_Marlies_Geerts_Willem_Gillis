package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Cube extends HComponent {
	private static int mSize = 25;
	private Color mColor;
	private Point mLocation;
	
	public Cube(Point location, Color color) {
		mColor = color;
		mLocation = location;
		this.setBounds(0, 0, location.x+mSize, location.y+mSize);
	}
	
	public void UpdateBlock(Point location){
		mLocation = location;
                this.setBounds(0, 0, mLocation.x+mSize, mLocation.y+mSize);
                repaint();
	}
	
	public static int GetSize() {
		return mSize;
	}
	
	public void paint (Graphics g) {
		g.setColor(mColor);
		g.fillRect(mLocation.x, mLocation.y, mSize, mSize);
	}
}
