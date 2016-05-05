package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HVisible;

public class EnemyRocket extends Sprite{
	Image mijnImage;
	int	direction = 1;
	int widthImage;
	public EnemyRocket(int x, int y){
		super(x,y);
		mijnImage = this.getToolkit().getImage("rocket.png");
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(mijnImage, 1);
		try {
			mt.waitForAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setGraphicContent(mijnImage, HVisible.NORMAL_STATE);
		
		widthImage = mijnImage.getWidth(this);
		this.setSize(widthImage, mijnImage.getHeight(this));
		
	}
	
	public void Update(int tijd) {
		int x = this.getX();
		int y = this.getY();
		y++;
		if(y>576){
			HelloTVXlet.scene.remove(this);
			HelloTVXlet.publisher.Unregister(this);
		}
		this.setLocation(x, y);
	}
}
