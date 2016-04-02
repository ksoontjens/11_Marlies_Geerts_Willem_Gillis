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
		if (CheckCollision()) {
			mLocation.y--;
			RedrawCubes();
			Point[] blockPositions = new Point[mCubeArr.length];
			for (int i = 0; i < mCubeArr.length; i++) {
				blockPositions[i] = ResetCubeLocation(mCubeArr[i].GetLocation());
			}
			Blocks.AddBlocks(blockPositions, mCubeArr);
			mSpawner.SpawnTetromino();
		}
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
		boolean[][] tempArr2 = mTetrominoArr;
		mTetrominoArr = tempArr;
		RedrawCubes();

		if (CheckCollision()) {
			mTetrominoArr = tempArr2;
			RedrawCubes();
			for (int i = 0; i < mCubeArr.length; i++) {
				//Blocks.AddBlocks(ResetCubeLocation(mCubeArr[i].GetLocation()));
			}
		//mSpawner.SpawnTetromino();
		}
	}

	public boolean CheckCollision() {
		Cube[][] blockArr = Blocks.GetBlocks();

		for (int j = 0; j < mCubeArr.length; j++) {
			Point pointCube = mCubeArr[j].GetLocation();
			pointCube = ResetCubeLocation(pointCube);
			if (pointCube.x < 0 || pointCube.x > blockArr.length - 1 || pointCube.y > blockArr[0].length - 1 || (pointCube.y > 0 && blockArr[pointCube.x][pointCube.y] != null)) {
				return true;
			}
		}
		return false;
	}

	public void MoveDown() {
		mLocation.y++;
		RedrawCubes();
		if (CheckCollision()) {
			mLocation.y--;
			RedrawCubes();
		}
	}

	public void MoveLeftRight(int direction) {
		mLocation.x += direction;
		RedrawCubes();
		if (CheckCollision()) {
			mLocation.x -= direction;
			RedrawCubes();
		}
	}

	public Point GetLocation() {
		return mLocation;
	}

	private Point ResetCubeLocation(Point pointCube) {
		pointCube = new Point((pointCube.x - mOffset.x) / Cube.GetSize(), (pointCube.y - mOffset.y) / Cube.GetSize());
		return pointCube;
	}
	
	public void Destroy() {
		for (int i = 0; i < mCubeArr.length; i++) {
			mCubeArr[i].Destroy();
		}
	}
}
