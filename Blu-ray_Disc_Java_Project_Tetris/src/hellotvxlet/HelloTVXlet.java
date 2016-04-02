package hellotvxlet;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
	private static boolean mPaused = false;
	private static boolean mIsGameOver = false;
	private static Border mTetrisFieldBorder = new Border(38, 10, 250, 500, 10);
	private static Spawner mSpawner;
	private static Timer mTimer;
	
	private static HStaticText mPausedLabel = new HStaticText("PAUSED",38+125-200,10+250-25,400,50);
	private static HStaticText mGameOverLabel = new HStaticText("GAME OVER",38+125-200,10+250-25,400,50);
	private static HStaticText mLevelLabel = new HStaticText("Level: 1",38+325,10+175-30,400,60);
	private static HStaticText mScoreLabel = new HStaticText("Score: 0",38+325+150,10+175-30,400,60);
	private static HStaticText mAmountOfLinesLabel = new HStaticText("Amount of lines: 0",38+325,10+175-30+60,400,60);

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
		repository.addKey(HRcEvent.VK_ENTER);

		manager.addUserEventListener(this, repository);
	}

	public void startXlet() throws XletStateChangeException {
		mPausedLabel.setVisible(false);
		mPausedLabel.setFont(new Font("Serif", Font.BOLD, 30));
		scene.add(mPausedLabel);
		
		mGameOverLabel.setVisible(false);
		mGameOverLabel.setFont(new Font("Serif", Font.BOLD, 30));
		scene.add(mGameOverLabel);
		
		mScoreLabel.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		mLevelLabel.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		mAmountOfLinesLabel.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		
		scene.add(mScoreLabel);
		scene.add(mLevelLabel);
		scene.add(mAmountOfLinesLabel);


		scene.add(mTetrisFieldBorder);
		mSpawner = new Spawner();
		scene.validate();
		scene.setVisible(true);

		//mTimer = new Timer(50, mSpawner);
		//mTimer.start();
		
		mTimer = new Timer();
		mTimer.scheduleAtFixedRate(mSpawner, 0, 300);
		
	}

	public void pauseXlet() {
	}

	public void destroyXlet(boolean unconditional) throws XletStateChangeException {
	}

//	private static void Timing () {
//		while (!mPaused) {
//			mTimer++;
//			if (mTimer >= Level.GetSpeed()) {
//				mSpawner.run();
//				mTimer = 0;
//			}
//		}
//		
//	}
	//public static void ChangeSpeed() {
		//mTimer.setDelay(20);
		//mTimer.cancel();
		//mTimer = new Timer();
		//mTimer.scheduleAtFixedRate(mSpawner, 0, 20);
		//mSpawner.scheduledExecutionTime();
	//}
	public static void AddToScene(Cube itemToAdd) {
		scene.add(itemToAdd);
		scene.repaint();
	}

	public static void RemoveFromScene(Cube itemToRemove) {
		scene.remove(itemToRemove);
		scene.repaint();
	}

	public static void GameOver() {
		//mTimer.cancel();
		//mTimer.stop();
		mIsGameOver = true;
		mGameOverLabel.setVisible(mIsGameOver);
	}

	public static HScene GetScene() {
		return scene;
	}

	public static Border GetTetrisFieldBorder() {
		return mTetrisFieldBorder;
	}
	
	public static boolean GetIsGamePaused() {
		return mPaused;
	}

	public static HStaticText GetScoreLabel () {
		return mScoreLabel;
	}
	
	public static HStaticText GetLevelLabel () {
		return mLevelLabel;
	}
	
	public static HStaticText GetAmountOfLinesLabel () {
		return mAmountOfLinesLabel;
	}
	
	public void userEventReceived(UserEvent e) {
		if (e.getType() == KeyEvent.KEY_PRESSED) {
			if (!mIsGameOver && !mPaused) {
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
			if (!mIsGameOver) {
				if (e.getCode() == HRcEvent.VK_ENTER) {
					mPaused = !mPaused;
					System.out.println("Removing line:");
					//ChangeSpeed();
					mPausedLabel.setVisible(mPaused);
				}
			}
		}
	}
}
