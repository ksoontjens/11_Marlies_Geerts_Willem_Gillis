package hellotvxlet;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author student
 */
public class Spawner {
	private boolean[][] mOArr =		{{false,false,false,false},
						{ false,true, true, false},
						{ false,true, true, false},
						{ false,false,false,false}};
	
	private boolean[][] mIArr=		{{false,false,false,false},
						{ true, true, true, true },
						{ false,false,false,false},
						{ false,false,false,false}};
	
	private boolean[][] mSArr=		{{false,false,false,false},
						{ false,false,true, true },
						{ false,true, true, false},
						{ false,false,false,false}};
	
	private boolean[][] mZArr=		{{false,false,false,false},
						{ false,true, true, false},
						{ false,false,true, true },
						{ false,false,false,false}};
	
	private boolean[][] mLArr=		{{false,false,false,false},
						{ false,true, true, true },
						{ false,true, false,false},
						{ false,false,false,false}};
	
	private boolean[][] mJArr=		{{false,false,false,false},
						{ false,true, true, true },
						{ false,false,false,true },
						{ false,false,false,false}};
	
	private boolean[][] mTArr=		{{false,false,false,false},
						{ false,true, true, true },
						{ false,false,true, false},
						{ false,false,false,false}};
	
        private Color[] mColorArr = {Color.YELLOW, Color.CYAN, Color.GREEN, Color.RED, Color.ORANGE, Color.BLUE, Color.PINK};
	private byte mCurrentType;
	private byte mNextType;
        private Random mRnd;
        private Tetromino mCurrentTetromino;
        
	private static final int WIDTH_BOARD = 10;
	private static final int HEIGHT_BOARD = 20;
	
	public Spawner() {
	}
	
	public void Update(int time){
	}

	private void SpawnTetromino(){         
            mCurrentType = mNextType;
            mNextType = (byte)mRnd.nextInt(7);
                       
            switch(mCurrentType) {
                     case 0:
                        mCurrentTetromino = new Tetromino(mColorArr[mCurrentType], mOArr);
                        break;
                     case 1:
                        mCurrentTetromino = new Tetromino(mColorArr[mCurrentType], mIArr);
                        break;
                     case 2:
                        mCurrentTetromino = new Tetromino(mColorArr[mCurrentType], mSArr);
                        break; 
                     case 3: //
                        mCurrentTetromino = new Tetromino(mColorArr[mCurrentType], mZArr);
                        break; 
                     case 4:
                        mCurrentTetromino = new Tetromino(mColorArr[mCurrentType], mLArr);
                        break; 
                     case 5:
                        mCurrentTetromino = new Tetromino(mColorArr[mCurrentType], mJArr);
                        break;
                     case 6:
                        mCurrentTetromino = new Tetromino(mColorArr[mCurrentType], mTArr);
                        break; 
                     default:
                        break;
               }
                
	}
}
