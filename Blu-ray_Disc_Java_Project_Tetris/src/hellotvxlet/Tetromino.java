package hellotvxlet;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author student
 */
public class Tetromino {
    
	private byte mRotation = 0; //0 = UP; 1 = RIGHT; 2 = DOWN; 3 = LEFT
	private Color mColor;
	private Point mLocation;
	private boolean[][] mTetrominoArr;
        private Cube[] mCubeArr = new Cube[4];
	
	public Tetromino(Color color, boolean[][] tetrominoArr) {
		this.mColor = color;
		this.mTetrominoArr = tetrominoArr;
               
                byte counter = 0;
                for (int i = 0; i < 4; i++) {                
                   for (int j = 0; j < 4; j++) {
                    if (mTetrominoArr[i][j]) {
                        mCubeArr[counter] = new Cube(new Point(Cube.GetSize() * (i + mLocation.x), Cube.GetSize() * (j + mLocation.y)) , mColor);
                        counter++;
                    }
                   }
                }
	}
	
        public void RedrawCubes() {
            byte counter = 0;
                for (int i = 0; i < 4; i++) {                
                   for (int j = 0; j < 4; j++) {
                    if (mTetrominoArr[i][j]) {
                        mCubeArr[counter].UpdateBlock(new Point(Cube.GetSize() * (i + mLocation.x), Cube.GetSize() * (j + mLocation.y)));
                        counter++;
                    }
                   }
                } 
        }
        
	public void Update(int time){
		
	}
	
	public void Rotate(boolean direction){
		if (direction) {
                    mRotation +=1;
                    mRotation %= 4;
                }
                else {
                    mRotation -=1;
                    mRotation %= 252;  //Rest van 3 indien 255
                }
                ChangeBoolRotation();
	}
	
        private void ChangeBoolRotation() {
           boolean[][] tempArr = new boolean[4][4];
           for (int i = 0; i < 4; i++) {
               for (int j = 0; j < 4; j++) {
                   tempArr[i][j] = mTetrominoArr[ 3 - j][i];
               }
           }
            mTetrominoArr = tempArr;
        }
        
	public void CheckCollision(int rotation, int transform){
		
	}
	
	public void MoveDown(){
		
	}
        
        public void MoveLeftRight(){
		
	}
	
	public Point GetLocation(){
		return mLocation;
	}
	
	public void Destroy(){
		
	}
}
