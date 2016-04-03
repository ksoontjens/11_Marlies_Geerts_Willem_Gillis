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
	private Point mLocalPosition;
	private Point mGlobalPosition;

	public Cube(Point location, Color color) {
		mColor = color;
		mLocalPosition = location;
		mGlobalPosition = new Point(mLocalPosition.x*mSize, mLocalPosition.y*mSize);
		this.setBounds(mGlobalPosition.x, mGlobalPosition.y,  mSize, mSize);
	}

	public void UpdateCube(Point location) {
		mLocalPosition = location;
		mGlobalPosition = new Point(mLocalPosition.x*mSize, mLocalPosition.y*mSize);
		this.setBounds(mGlobalPosition.x, mGlobalPosition.y,  mSize, mSize);
	}

	public void paint(Graphics g) {
		g.setColor(mColor);
		g.fillRect(0, 0, mSize, mSize);
	}

	public Point GetLocalPosition() {
		return mLocalPosition;
	}
	
	public static void SetSize(int size) {
		mSize = size;
	}
}
