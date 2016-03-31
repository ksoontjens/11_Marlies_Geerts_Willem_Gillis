package hellotvxlet;

import java.awt.Point;

/**
 *
 * @author student
 */
public class Blocks {
	private static boolean[][] mBlocksArr;
	
	public Blocks(int widthBoard, int heightBoard) {
		mBlocksArr = new boolean[widthBoard][heightBoard];
	}
	
	public static void AddBlocks(Point blocks){
		mBlocksArr[blocks.x][blocks.y] = true;
	}
	
	public static boolean[][] GetBlocks(){
	    return mBlocksArr;
	}
	
	private void RemoveLine(){
	    
	}
}
