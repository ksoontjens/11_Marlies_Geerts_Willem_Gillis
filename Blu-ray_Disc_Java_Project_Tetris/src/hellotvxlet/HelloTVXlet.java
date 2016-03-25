package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import java.awt.Point;
import org.havi.ui.HVisible;

public class HelloTVXlet implements Xlet {
	private static HScene scene = null;
	private boolean mPaused = false;
	Border mTetrisFieldBorder = new Border(38,38,250,500,10);
	
	public void initXlet(XletContext ctx) throws XletStateChangeException {
		scene = HSceneFactory.getInstance().getDefaultHScene();
		scene.setBackground(Color.BLACK);
		scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
		
	}
	
	public void startXlet() throws XletStateChangeException {
		//Dimension test = scene.getSize();
		
		//HStaticText label = new HStaticText(test.toString(),10,100,400,50);
		//scene.add(label);
		scene.add(mTetrisFieldBorder);
		scene.validate();
		scene.setVisible(true);
	}
	
	public void pauseXlet() {
		
	}
	
	public void destroyXlet(boolean unconditional) throws XletStateChangeException {
		
	}
	
	public static HScene getScene(){
		return scene;
	}

}
