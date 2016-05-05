package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;
import org.havi.ui.HVisible;

public class Player extends Sprite{
	Image mijnImage;
	int widthImage;
	int heightImage;
	int herlaadTijd;
	int teller;
	public Player(int x, int y){
		super(x,y);
		mijnImage = this.getToolkit().getImage("spaceship2.png");
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(mijnImage, 1);
		try {
			mt.waitForAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setGraphicContent(mijnImage, HVisible.NORMAL_STATE);
		
		widthImage = mijnImage.getWidth(this);
		heightImage = mijnImage.getHeight(this);
		//this.setResizeMode(Image.SCALE_FAST);
		this.setSize(widthImage, mijnImage.getHeight(this));
		
		Random random = new Random();
		random.setSeed(x*y);
		herlaadTijd = random.nextInt(5000)+500;
	}
	
	public void Update(int tijd) {
		int x = this.getX();
		int y = this.getY();
		this.setLocation(x, y);
	}
}
