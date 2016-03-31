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

    public static void AddBlocks(Point blocks, Cube cubeIn) {
	mBlocksArr[blocks.x][blocks.y] = cubeIn;
	CheckLines();
	PrintArrayTest();
    }

    public static Cube[][] GetBlocks() {
	return mBlocksArr;
    }

    private static void CheckLines() {
	for (int i = 0; i < mBlocksArr.length; i++) {
	    boolean isClear = true;
	    for (int j = 0; j < mBlocksArr[0].length; j++) {
		if (mBlocksArr[i][j] == null) {
		    isClear = false;
		}
	    }
	    if (isClear) {
		System.out.println("Removing lines");
		RemoveLine(i);
	    }
	}
    }

    private static void RemoveLine(int line) {
	for (int j = 0; j < mBlocksArr[0].length; j++) {
	    mBlocksArr[line][j].Destroy();
	    mBlocksArr[line][j] = null;
	}

	for (int i = line; i < mBlocksArr.length; i++) {
	    for (int j = 0; j < mBlocksArr[0].length; j++) {
		mBlocksArr[i][j].UpdateBlock(new Point( mBlocksArr[i][j].GetLocation().x, mBlocksArr[i][j].GetLocation().y + Cube.GetSize()));		
	    }
	}
    }
    
    private static void PrintArrayTest() {
	for (int i = 0; i < mBlocksArr.length; i++) {
	    for (int j = 0; j < mBlocksArr[0].length; j++) {
		System.out.print(mBlocksArr[i][j] + " ");
	    }
	    System.out.println("");
	    }
    }
}
