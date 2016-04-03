package hellotvxlet;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
	private static Spawner mSpawner;
	private static Timer mTimer;
	private static Point mFieldPosition = new Point(38, 10);
	private static Dimension mFieldDimensions = new Dimension(250, 500);
	private static int mCubeSize = mFieldDimensions.width / 10;
	private static int mFieldBorderWidth = 10;
	private static Border mTetrisFieldBorder = new Border(mFieldPosition, mFieldDimensions, mFieldBorderWidth);
	private static Container mPlayingFieldContainer = new Container();
	private static Container mNextTetrominoFieldContainer = new Container();
	private static Container mGameDataContainer = new Container();
	private static HStaticText mPausedLabel = new HStaticText("PAUSED", 0, 0, mFieldDimensions.width, mFieldDimensions.height);
	private static HStaticText mGameOverLabel = new HStaticText("GAME OVER", 0, 0, mFieldDimensions.width, mFieldDimensions.height);
	private static HStaticText mLevelLabel = new HStaticText("Level: 1", 0, 0, 400, 60);
	private static HStaticText mScoreLabel = new HStaticText("Score: 0", 130, 0, 400, 60);
	private static HStaticText mAmountOfLinesLabel = new HStaticText("Amount of lines: 0", 0, 60, 400, 60);

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
		Cube.SetSize(mCubeSize);
		
		mPausedLabel.setVisible(false);
		mPausedLabel.setFont(new Font("Serif", Font.BOLD, 30));
		mPlayingFieldContainer.add(mPausedLabel);

		mGameOverLabel.setVisible(false);
		mGameOverLabel.setFont(new Font("Serif", Font.BOLD, 30));
		mPlayingFieldContainer.add(mGameOverLabel);

		mScoreLabel.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		mLevelLabel.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		mAmountOfLinesLabel.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		mGameDataContainer.add(mAmountOfLinesLabel);

		mGameDataContainer.add(mScoreLabel);
		mGameDataContainer.add(mLevelLabel);

		mGameDataContainer.setBounds(mFieldPosition.x + mFieldDimensions.width + 30, mFieldPosition.y + mCubeSize * 4 + 30, 400, 200);
		mPlayingFieldContainer.setBounds(mFieldPosition.x, mFieldPosition.y, mFieldDimensions.width, mFieldDimensions.height);
		mNextTetrominoFieldContainer.setBounds(mFieldPosition.x + mFieldDimensions.width + 30, mFieldPosition.y, mCubeSize * 4, mCubeSize * 4);

		scene.add(mPlayingFieldContainer);
		scene.add(mNextTetrominoFieldContainer);
		scene.add(mGameDataContainer);

		scene.add(mTetrisFieldBorder);
		mSpawner = new Spawner();
		scene.validate();
		scene.setVisible(true);

		mTimer = new Timer();
		mTimer.scheduleAtFixedRate(mSpawner, 0, 1);
	}

	public void pauseXlet() {
	}

	public void destroyXlet(boolean unconditional) throws XletStateChangeException {
	}

	public static void AddToScene(Cube itemToAdd, int container) {
		switch (container) {
			case 0:
				scene.add(itemToAdd);
				scene.repaint();
				break;
			case 1:
				mPlayingFieldContainer.add(itemToAdd);
				mPlayingFieldContainer.repaint();
				break;
			case 2:
				mNextTetrominoFieldContainer.add(itemToAdd);
				mNextTetrominoFieldContainer.repaint();
				break;
		}
	}

	public static void RemoveFromScene(Cube itemToRemove, int container) {
		switch (container) {
			case 0:
				scene.remove(itemToRemove);
				scene.repaint();
				break;
			case 1:
				mPlayingFieldContainer.remove(itemToRemove);
				mPlayingFieldContainer.repaint();
				break;
			case 2:
				mNextTetrominoFieldContainer.remove(itemToRemove);
				mNextTetrominoFieldContainer.repaint();
				break;
		}
	}

	public static void GameOver() {
		mTimer.cancel();
		mIsGameOver = true;
		mGameOverLabel.setVisible(mIsGameOver);
	}

	public static boolean GetIsGamePaused() {
		return mPaused;
	}

	public static HStaticText GetScoreLabel() {
		return mScoreLabel;
	}

	public static HStaticText GetLevelLabel() {
		return mLevelLabel;
	}

	public static HStaticText GetAmountOfLinesLabel() {
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
					mPausedLabel.setVisible(mPaused);
				}
			}
		}
	}
}
