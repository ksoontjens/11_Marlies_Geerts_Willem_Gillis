package hellotvxlet;

import java.awt.Color;
import java.util.Timer;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HVisible;

public class HelloTVXlet implements Xlet {
	static HScene scene = null;
	static Subject publisher = null;
	public void initXlet(XletContext ctx) throws XletStateChangeException {
		scene = HSceneFactory.getInstance().getDefaultHScene();
		scene.setBackground(Color.BLACK);
		scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
		publisher  = new Subject();
		Timer tim1 = new Timer();
		tim1.scheduleAtFixedRate(publisher, 0, 10);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				Enemy enemy = new Enemy(i*100, j*100+20);
				scene.add(enemy);
				publisher.Register(enemy);
			}
		}
		
		Player player = new Player(250,510);
		scene.add(player);
		publisher.Register(player);
		scene.validate();
		scene.setVisible(true);
	}
	
	public void startXlet() throws XletStateChangeException {
		
	}
	
	public void pauseXlet() {
		
	}
	
	public void destroyXlet(boolean unconditional) throws XletStateChangeException {
		
	}
	
	public static HScene getScene(){
		return scene;
	}
	
	public static Subject getPublisher(){
		return publisher;
	}
}
