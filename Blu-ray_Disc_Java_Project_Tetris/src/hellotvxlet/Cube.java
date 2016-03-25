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
	private int mWidth=25;
	private int mHeight=25;
	private Color mColor;
	private Point mLocation;
	
	public Cube(Point location, Color color) {
		mColor = color;
		mLocation = location;
		this.setBounds(0, 0, location.x+mWidth, location.y+mHeight);
	}
	
	public void UpdateBlock(Point location){
		mLocation = location;
	}
	
	public int GetHeight() {
		return mHeight;
	}

	public int GetWidth() {
		return mWidth;
	}
	
	public void paint (Graphics g) {
		g.setColor(mColor);
		g.fillRect(mLocation.x-mWidth/2, mLocation.y-mHeight/2, mWidth, mHeight);
	}
}
