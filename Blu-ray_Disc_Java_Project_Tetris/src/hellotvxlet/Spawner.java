package hellotvxlet;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import java.util.TimerTask;

/**
 *
 * @author student
 */
public class Spawner extends TimerTask {

	private boolean[][] mOArr = {{false, false, false, false},
		{false, true, true, false},
		{false, true, true, false},
		{false, false, false, false}
	};
	private boolean[][] mIArr = {{false, false, false, false},
		{true, true, true, true},
		{false, false, false, false},
		{false, false, false, false}
	};
	private boolean[][] mSArr = {{false, false, false, false},
		{false, false, true, true},
		{false, true, true, false},
		{false, false, false, false}
	};
	private boolean[][] mZArr = {{false, false, false, false},
		{false, true, true, false},
		{false, false, true, true},
		{false, false, false, false}
	};
	private boolean[][] mLArr = {{false, false, false, false},
		{false, true, true, true},
		{false, true, false, false},
		{false, false, false, false}
	};
	private boolean[][] mJArr = {{false, false, false, false},
		{false, true, true, true},
		{false, false, false, true},
		{false, false, false, false}
	};
	private boolean[][] mTArr = {{false, false, false, false},
		{false, true, true, true},
		{false, false, true, false},
		{false, false, false, false}
	};
	private Color[] mColorArr = {Color.YELLOW, Color.CYAN, Color.GREEN, Color.RED, Color.ORANGE, Color.BLUE, Color.PINK};
	private byte mCurrentType;
	private byte mNextType;
	private Random mRnd = new Random();
	private Tetromino mCurrentTetromino;
	private Tetromino mNextTetromino;
	private int mTime = 0;
	private Blocks mBlocks;
	private final int WIDTH_BOARD = 10;
	private final int HEIGHT_BOARD = 20;
	private int mSpeed;
	private int mCounter  = 0;

	public Spawner() {
		mNextType = (byte) mRnd.nextInt(7);
		mBlocks = new Blocks(WIDTH_BOARD, HEIGHT_BOARD);
		SpawnTetromino();		
		mSpeed = Level.getInstance().GetSpeed();
	}

	public void run() {
		if (!SingletonObject.getInstance().GetIsGamePaused()) {
			if (mSpeed < mCounter) {
				mTime++;
				mCurrentTetromino.Update(mTime);
				mCounter = 0;
			}
			mCounter++;
		}
	}

	public void SpawnTetromino() {
		mCurrentType = mNextType;
		mNextType = (byte) mRnd.nextInt(7);
		mCurrentTetromino = TetrominoPicker(mCurrentType, new Point(3, -3), false);

		ShowNext();
		mSpeed = Level.getInstance().GetSpeed();
	}

	private Tetromino TetrominoPicker(byte tetrominoNumber, Point location, boolean isStatic) {
		boolean[][] tetrominoArr = null;
		switch (tetrominoNumber) {
			case 0:
				tetrominoArr = mOArr;
				break;
			case 1:
				tetrominoArr = mIArr;
				break;
			case 2:
				tetrominoArr = mSArr;
				break;
			case 3:
				tetrominoArr = mZArr;
				break;
			case 4:
				tetrominoArr = mLArr;
				break;
			case 5:
				tetrominoArr = mJArr;
				break;
			case 6:
				tetrominoArr = mTArr;
				break;
			default:
				break;
		}

		if (!isStatic) {
			return new Tetromino(mColorArr[tetrominoNumber], tetrominoArr, location, this, mBlocks);
		} else {
			return new Tetromino(mColorArr[tetrominoNumber], tetrominoArr, this);
		}
	}

	private void ShowNext() {
		if (mNextTetromino != null) {
			mNextTetromino.Destroy();
		}
		mNextTetromino = TetrominoPicker(mNextType, new Point(0, 0), true);
	}

	public Tetromino GetCurrentTetromino() {
		return mCurrentTetromino;
	}
}
