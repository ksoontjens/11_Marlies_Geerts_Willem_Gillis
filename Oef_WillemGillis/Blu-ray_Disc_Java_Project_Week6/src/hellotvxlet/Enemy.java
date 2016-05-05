package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;
import org.havi.ui.HVisible;

public class Enemy extends Sprite{
	Image mijnImage;
	int	direction = 1;
	int widthImage;
	int heightImage;
	int herlaadTijd;
	int teller;
	public Enemy(int x, int y){
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
		if (x > 720-widthImage-20) {
			direction = -1;
		}else if(x<20){
			direction = 1;
		}
		x+=direction;
	
		int y = this.getY();
		//y++;
		this.setLocation(x, y);
		
		teller++;
		if (teller > herlaadTijd) {
			teller = 0;
			EnemyRocket rocket = new EnemyRocket(this.getX()+widthImage/2, this.getY()+heightImage/2);
			HelloTVXlet.getScene().add(rocket);
			HelloTVXlet.getPublisher().Register(rocket);
		}
		
	}
}
