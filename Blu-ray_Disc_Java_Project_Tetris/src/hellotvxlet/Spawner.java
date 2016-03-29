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
        private Random mRnd = new Random();
        private Tetromino mCurrentTetromino;
        private Tetromino mNextTetromino;
        private Point mTetrisFieldBorderPos;
        private int mTime = 0;
	private Blocks mBlocks;
        
	private static final int WIDTH_BOARD = 10;
	private static final int HEIGHT_BOARD = 20;
	
	public Spawner() {
            mNextType = (byte)mRnd.nextInt(7);
            mTetrisFieldBorderPos = HelloTVXlet.GetTetrisFieldBorder().GetPosition();
            SpawnTetromino();     
	    mBlocks = new Blocks(WIDTH_BOARD,HEIGHT_BOARD);
	}
	
	/*public void Update(int time){
            
	} */
        
        public void run() {
            mTime++;
            mCurrentTetromino.Update(mTime);
        }

	public void SpawnTetromino(){         
            mCurrentType = mNextType;
            mNextType = (byte)mRnd.nextInt(7);
            mCurrentTetromino = TetrominoPicker(mCurrentType, new Point(3, -3), mTetrisFieldBorderPos);           
            
            ShowNext();   
	}
        
        private Tetromino TetrominoPicker(byte tetrominoNumber, Point location, Point offset) {
            Tetromino tetrominoToShow = null;
            
            switch(tetrominoNumber) {
                     case 0:
                        tetrominoToShow = new Tetromino(mColorArr[tetrominoNumber], mOArr, location, offset, this);
                        break;
                     case 1:
                        tetrominoToShow = new Tetromino(mColorArr[tetrominoNumber], mIArr, location, offset, this);
                        break;
                     case 2:
                        tetrominoToShow = new Tetromino(mColorArr[tetrominoNumber], mSArr, location, offset, this);
                        break; 
                     case 3: 
                        tetrominoToShow = new Tetromino(mColorArr[tetrominoNumber], mZArr, location, offset, this);
                        break; 
                     case 4:
                        tetrominoToShow = new Tetromino(mColorArr[tetrominoNumber], mLArr, location, offset, this);
                        break; 
                     case 5:
                        tetrominoToShow = new Tetromino(mColorArr[tetrominoNumber], mJArr, location, offset, this);
                        break;
                     case 6:
                        tetrominoToShow = new Tetromino(mColorArr[tetrominoNumber], mTArr, location, offset, this);
                        break; 
                     default:
                        break;
               }
            return tetrominoToShow;
        }
        
        private void ShowNext() {          
            mNextTetromino = TetrominoPicker(mNextType, new Point(0, 0), new Point(350,mTetrisFieldBorderPos.y));
        }

        public Tetromino GetCurrentTetromino(){
            return mCurrentTetromino;
        }
}
