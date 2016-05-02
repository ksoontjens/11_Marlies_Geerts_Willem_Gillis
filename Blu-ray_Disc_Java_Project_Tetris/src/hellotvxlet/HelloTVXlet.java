package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HVisible;

public class HelloTVXlet implements Xlet {

	private HScene mScene = null;
	private SingletonObject mObject;

	public void initXlet(XletContext ctx) throws XletStateChangeException {
		mScene = HSceneFactory.getInstance().getDefaultHScene();
		mScene.setBackground(Color.BLACK);
		mScene.setBackgroundMode(HVisible.BACKGROUND_FILL);
		
		mObject = SingletonObject.getInstance();
		mObject.UserInputHandling();
		mObject.SetScene(mScene);
	}

	public void startXlet() throws XletStateChangeException {
		
		mObject.InitializeGame();
		
	}

	public void pauseXlet() {
	}

	public void destroyXlet(boolean unconditional) throws XletStateChangeException {
	}

	
}
