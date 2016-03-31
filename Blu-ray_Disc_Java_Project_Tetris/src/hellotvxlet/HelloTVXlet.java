package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.*;
import org.dvb.event.UserEvent;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Timer;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HVisible;

public class HelloTVXlet implements Xlet, UserEventListener {

    private static HScene scene = null;
    private boolean mPaused = false;
    private static Border mTetrisFieldBorder = new Border(38, 10, 250, 500, 10);
    private Spawner mSpawner;

    public void initXlet(XletContext ctx) throws XletStateChangeException {
	scene = HSceneFactory.getInstance().getDefaultHScene();
	scene.setBackground(Color.BLACK);
	scene.setBackgroundMode(HVisible.BACKGROUND_FILL);

	EventManager manager = EventManager.getInstance();

	UserEventRepository repository = new UserEventRepository("Controls");
	repository.addKey(HRcEvent.VK_LEFT);
	repository.addKey(HRcEvent.VK_RIGHT);
	repository.addKey(HRcEvent.VK_DOWN);
	repository.addKey(HRcEvent.VK_1);
	repository.addKey(HRcEvent.VK_3);

	manager.addUserEventListener(this, repository);
    }

    public void startXlet() throws XletStateChangeException {
	//Dimension test = scene.getSize();

	//HStaticText label = new HStaticText(test.toString(),10,100,400,50);
	//scene.add(label);

	scene.add(mTetrisFieldBorder);
	mSpawner = new Spawner();
	scene.validate();
	scene.setVisible(true);

	Timer time1 = new Timer();
	time1.scheduleAtFixedRate(mSpawner, 0, 1000);
    }

    public void pauseXlet() {
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public static void AddToScene(Cube itemToAdd) {
	scene.add(itemToAdd);
    }

    public static HScene GetScene() {
	return scene;
    }

    public static Border GetTetrisFieldBorder() {
	return mTetrisFieldBorder;
    }

    public void userEventReceived(UserEvent e) {
	if (e.getType() == KeyEvent.KEY_PRESSED) {
	    switch (e.getCode()) {
		case HRcEvent.VK_LEFT:
		    mSpawner.GetCurrentTetromino().MoveLeftRight(-1);
		    break;
		case HRcEvent.VK_RIGHT:
		    mSpawner.GetCurrentTetromino().MoveLeftRight(1);
		    break;
		case HRcEvent.VK_DOWN:
		    mSpawner.GetCurrentTetromino().MoveDown();
		    break;
		case HRcEvent.VK_1:
		    mSpawner.GetCurrentTetromino().Rotate(false);
		    break;
		case HRcEvent.VK_3:
		    mSpawner.GetCurrentTetromino().Rotate(true);
		    break;
	    }
	}
    }
}
