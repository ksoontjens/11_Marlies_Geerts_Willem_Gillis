package hellotvxlet;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import org.dvb.event.UserEvent;
import org.havi.ui.HScene;
import org.havi.ui.HStaticText;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Timer;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class SingletonObject implements UserEventListener {
	private HScene mScene = null;
	private boolean mPaused = false;
	private boolean mIsGameOver = false;
	private Spawner mSpawner;
	private Timer mTimer;
	private Point mFieldPosition = new Point(38, 10);
	private Dimension mFieldDimensions = new Dimension(250, 500);
	private int mCubeSize = mFieldDimensions.width / 10;
	private int mFieldBorderWidth = 10;
	private Border mTetrisFieldBorder = new Border(mFieldPosition, mFieldDimensions, mFieldBorderWidth);
	private Container mPlayingFieldContainer = new Container();
	private Container mNextTetrominoFieldContainer = new Container();
	private Container mGameDataContainer = new Container();
	private HStaticText mPausedLabel = new HStaticText("PAUSED", 0, 0, mFieldDimensions.width, mFieldDimensions.height);
	private HStaticText mGameOverLabel = new HStaticText("GAME OVER", 0, 0, mFieldDimensions.width, mFieldDimensions.height);
	private HStaticText mLevelLabel = new HStaticText("Level: 1", 0, 0, 400, 60);
	private HStaticText mScoreLabel = new HStaticText("Score: 0", 130, 0, 400, 60);
	private HStaticText mAmountOfLinesLabel = new HStaticText("Amount of lines: 0", 0, 60, 400, 60);
	
	private static SingletonObject instance = new SingletonObject();
	
	private SingletonObject(){

	}
	
	public void SetScene(HScene scene){
		mScene = scene;
	}
	
	public static SingletonObject getInstance(){
		return instance;
	}
	
	public void UserInputHandling(){
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
	
	public void InitializeGame(){
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

		mScene.add(mPlayingFieldContainer);
		mScene.add(mNextTetrominoFieldContainer);
		mScene.add(mGameDataContainer);

		mScene.add(mTetrisFieldBorder);
		mSpawner = new Spawner();
		mScene.validate();
		mScene.setVisible(true);

		mTimer = new Timer();
		mTimer.scheduleAtFixedRate(mSpawner, 0, 1);
	}
	
	public void AddToScene(Cube itemToAdd, int container) {
		switch (container) {
			case 0:
				mScene.add(itemToAdd);
				mScene.repaint();
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

	public void RemoveFromScene(Cube itemToRemove, int container) {
		switch (container) {
			case 0:
				mScene.remove(itemToRemove);
				mScene.repaint();
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

	public void GameOver() {
		mTimer.cancel();
		mIsGameOver = true;
		mGameOverLabel.setVisible(mIsGameOver);
	}

	public boolean GetIsGamePaused() {
		return mPaused;
	}

	public HStaticText GetScoreLabel() {
		return mScoreLabel;
	}

	public HStaticText GetLevelLabel() {
		return mLevelLabel;
	}

	public HStaticText GetAmountOfLinesLabel() {
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
