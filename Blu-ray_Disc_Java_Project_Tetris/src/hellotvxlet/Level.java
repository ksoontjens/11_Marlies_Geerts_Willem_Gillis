package hellotvxlet;

/**
 *
 * @author student
 */
public class Level {
	private float mSpeedMultiplier = 1;
	private byte mLevelAmount = 0;
	private int mNextLevelScore = 50;
	
	public Level() {
		
	}
	
	public void LevelUp(){
		mLevelAmount++;
		mSpeedMultiplier*=1.5f;
	}
	
	public byte GetLevelAmount(){
		return mLevelAmount;
	}
}
