package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Border extends HComponent{
	int mPosX;
	int mPosY;
	int mWidth;
	int mHeight;
	int mBorderWidth;
	
	public Border(int posX, int posY, int width, int height, int borderWidth) {
		mPosX = posX;
		mPosY = posY;
		mWidth = width;
		mHeight = height;
		mBorderWidth = borderWidth;
		this.setBounds(0, 0, mPosX + mWidth+mBorderWidth*2, mPosY+mHeight+mBorderWidth*2);
	}
	
	public void paint (Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(mPosX-mBorderWidth,	mPosY-mBorderWidth,	mBorderWidth,			mHeight + mBorderWidth*2);
		g.fillRect(mPosX-mBorderWidth,	mPosY-mBorderWidth,	mWidth+ mBorderWidth*2,	mBorderWidth);
		g.fillRect(mPosX-mBorderWidth,	mPosY+ mHeight,		mWidth+ mBorderWidth*2,	mBorderWidth);
		g.fillRect(mPosX+mWidth,		mPosY-mBorderWidth,	mBorderWidth,			mHeight + mBorderWidth*2);
	}
}
