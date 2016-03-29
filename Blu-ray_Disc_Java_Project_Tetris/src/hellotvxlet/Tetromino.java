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
    private Point mOffset;
    private Spawner mSpawner;

    public Tetromino(Color color, boolean[][] tetrominoArr, Point location, Point offset, Spawner spawner) {
	mColor = color;
	mTetrominoArr = tetrominoArr;
	mLocation = location;
	mOffset = offset;
	mSpawner = spawner;

	byte counter = 0;
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (mTetrominoArr[j][i]) {
		    mCubeArr[counter] = new Cube(new Point(mOffset.x + Cube.GetSize() * (i + mLocation.x), mOffset.y + Cube.GetSize() * (j + mLocation.y)), mColor);
		    HelloTVXlet.AddToScene(mCubeArr[counter]);
		    counter++;
		}
	    }
	}

    }

    public void RedrawCubes() {
	byte counter = 0;
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (mTetrominoArr[j][i]) {
		    mCubeArr[counter].UpdateBlock(new Point(mOffset.x + Cube.GetSize() * (i + mLocation.x), mOffset.y + Cube.GetSize() * (j + mLocation.y)));
		    counter++;
		}
	    }
	}
    }

    public void Update(int time) {
	mLocation.y++;
	RedrawCubes();
    }

    public void Rotate(boolean direction) {
	if (direction) {
	    mRotation += 1;
	    mRotation %= 4;
	} else {
	    mRotation -= 1;
	    mRotation %= 252;  //Rest van 3 indien 255

	}
	ChangeBoolRotation();
    }

    private void ChangeBoolRotation() {
	boolean[][] tempArr = new boolean[4][4];
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		tempArr[i][j] = mTetrominoArr[3 - j][i];
	    }
	}
	mTetrominoArr = tempArr;
	RedrawCubes();
    }

    public void CheckCollision(int rotation, int transform) {
	boolean[][] test = Blocks.GetBlocks();
	byte counter = 0;
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (mTetrominoArr[j][i]) {
		    
		}
	    }
	}
	mSpawner.SpawnTetromino();
    }

    public void MoveDown() {
	mLocation.y++;
	RedrawCubes();
    }

    public void MoveLeftRight(int direction) {

	if (mLocation.x >= 0 && direction < 0) {
	    mLocation.x += direction;
	    RedrawCubes();
	}
	if (mLocation.x <= 5 && direction > 0) {
	    mLocation.x += direction;
	    RedrawCubes();
	}

    }

    public Point GetLocation() {
	return mLocation;
    }

    public void Destroy() {
    }
}
