package hellotvxlet;

import java.awt.Point;

/**
 *
 * @author student
 */
public class Blocks {

	private Cube[][] mBlocksArr;
	private SingletonObject mObject;

	public Blocks(int widthBoard, int heightBoard) {
		mObject = SingletonObject.getInstance();
		mBlocksArr = new Cube[widthBoard][heightBoard];	
	}

	public void AddBlocks(Cube[] cubeIn) {
		for (int i = 0; i < cubeIn.length; i++) {
			if (cubeIn[i].GetLocalPosition().y<1) {
				mObject.GameOver();
			}
			else{
				mBlocksArr[cubeIn[i].GetLocalPosition().x][cubeIn[i].GetLocalPosition().y] = cubeIn[i];
				mObject.AddToScene(mBlocksArr[cubeIn[i].GetLocalPosition().x][cubeIn[i].GetLocalPosition().y],1);
			}
		}
		PrintBoard();
		CheckLines();
	}

	public Cube[][] GetBlocks() {
		return mBlocksArr;
	}

	private void CheckLines() {
		byte linesGotten = 0;
		for (int i = 0; i < mBlocksArr[0].length; i++) {
			boolean isClear = true;
			for (int j = 0; j < mBlocksArr.length; j++) {
				if (mBlocksArr[j][i] == null) {
					isClear = false;
				}
			}
			if (isClear) {
				RemoveLine(i);
				linesGotten++;
			}
		}
		Score.getInstance().AddScore(linesGotten);
	}

	private void RemoveLine(int line) {
		for (int j = 0; j < mBlocksArr.length; j++) {
			SingletonObject.getInstance().RemoveFromScene(mBlocksArr[j][line], 1);
			mBlocksArr[j][line] = null;
		}

		for (int i = line; i > 0; i--) {
			for (int j = 0; j < mBlocksArr.length; j++) {
				if (mBlocksArr[j][i-1] != null) {
					mBlocksArr[j][i] = mBlocksArr[j][i-1];
					mBlocksArr[j][i-1] = null;
					mBlocksArr[j][i].UpdateCube(new Point(j, i));
				}
			}
		}
	}

	private void PrintBoard() {
		for (int i = 0; i < mBlocksArr[0].length; i++) {
			for (int j = 0; j < mBlocksArr.length; j++) {
				if (mBlocksArr[j][i] == null) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
