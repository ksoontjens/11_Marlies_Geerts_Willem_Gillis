package hellotvxlet;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author student
 */
public class Tetromino {
	
	
/**
 *
 * Xlet werkt enkel met Java 1.3 en deze versie heeft nog geen enum ondersteuning
 * Dus UP = 0, RIGHT = 90, DOWN = 180, LEFT = 270
 */
//	public enum Rotation{
//		UP(0), RIGHT(90), DOWN(180), LEFT(270);
//		
//		private final int rotation;
//		private Rotation(int rotation){
//			this.rotation = rotation;
//		}
//	}
	private final static int UP = 0, RIGHT = 90, DOWN = 180, LEFT = 270;
	private int mRotation = UP;
	private Color mColor;
	private Point mLocation;
	private boolean[][] mTetrominoArr;
	
	public Tetromino(Color color, boolean[][] tetrominoArr) {
		this.mColor = color;
		this.mTetrominoArr = tetrominoArr;
	}
	
	public void Update(int time){
		
	}
	
	public void Rotate(boolean direction){
		
	}
	
	public void CheckCollision(int rotation, int transform){
		
	}
	
	public void MoveDown(){
		
	}
	
	public Point GetLocation(){
		return null;
	}
	
	public void Destroy(){
		
	}
}
