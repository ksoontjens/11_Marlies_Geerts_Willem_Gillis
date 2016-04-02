package hellotvxlet;

import java.awt.Point;

/**
 *
 * @author student
 */
public class Blocks {

	private static Cube[][] mBlocksArr;

	public Blocks(int widthBoard, int heightBoard) {
		mBlocksArr = new Cube[widthBoard][heightBoard];
	}

	public static void AddBlocks(Point[] blocks, Cube[] cubeIn) {
		for (int i = 0; i < cubeIn.length; i++) {
			if (blocks[i].y<0) {
				HelloTVXlet.GameOver();
			}else{
				mBlocksArr[blocks[i].x][blocks[i].y] = cubeIn[i];
			}
		}
		PrintBoard();
		CheckLines();
	}

	public static Cube[][] GetBlocks() {
		return mBlocksArr;
	}

	private static void CheckLines() {
		byte linesGotten = 0;
		for (int i = 0; i < mBlocksArr[0].length; i++) {
			boolean isClear = true;
			for (int j = 0; j < mBlocksArr.length; j++) {
				if (mBlocksArr[j][i] == null) {
					isClear = false;
				}
			}
			if (isClear) {
				System.out.println("Removing line: " + (i+1));
				RemoveLine(i);
				linesGotten++;
			}
		}
		Score.AddScore(linesGotten);
	}

	private static void RemoveLine(int line) {
		for (int j = 0; j < mBlocksArr.length; j++) {
			mBlocksArr[j][line].Destroy();
			mBlocksArr[j][line] = null;
		}

		for (int i = line; i > 0; i--) {
			for (int j = 0; j < mBlocksArr.length; j++) {
				if (mBlocksArr[j][i-1] != null) {
					mBlocksArr[j][i] = mBlocksArr[j][i-1];
					mBlocksArr[j][i-1] = null;
					mBlocksArr[j][i].UpdateBlock(new Point(mBlocksArr[j][i].GetLocation().x, mBlocksArr[j][i].GetLocation().y + Cube.GetSize()));
				}
			}
		}
	}

	private static void PrintBoard() {
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
