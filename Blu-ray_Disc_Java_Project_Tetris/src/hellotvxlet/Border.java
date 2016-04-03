package hellotvxlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Border extends HComponent {

	private Point mPosition;
	private Dimension mDimensions;
	
	private int mBorderWidth;

	public Border(Point position, Dimension dimensions, int borderWidth) {
		mPosition = position;
		mDimensions = dimensions;
		mBorderWidth = borderWidth;
		this.setBounds(0, 0, mPosition.x + mDimensions.width + mBorderWidth * 2, mPosition.y + mDimensions.height + mBorderWidth * 2);
	}

	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(mPosition.x - mBorderWidth, mPosition.y - mBorderWidth, mBorderWidth, mDimensions.height + mBorderWidth * 2);
		g.fillRect(mPosition.x - mBorderWidth, mPosition.y - mBorderWidth, mDimensions.width + mBorderWidth * 2, mBorderWidth);
		g.fillRect(mPosition.x - mBorderWidth, mPosition.y + mDimensions.height, mDimensions.width + mBorderWidth * 2, mBorderWidth);
		g.fillRect(mPosition.x + mDimensions.width, mPosition.y - mBorderWidth, mBorderWidth, mDimensions.height + mBorderWidth * 2);
	}

	public Point GetPosition() {
		return mPosition;
	}
}
