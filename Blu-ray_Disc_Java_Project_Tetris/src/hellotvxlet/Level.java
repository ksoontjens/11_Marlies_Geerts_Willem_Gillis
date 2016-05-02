package hellotvxlet;

import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Level {

	private int mSpeedMultiplier = 1000;
	private byte mLevelAmount = 1;

	private static Level instance = new Level();
	
	public Level() {
		
	}
	
	public static Level getInstance() {
		return instance;
	}
		
	public void LevelUp() {
		mLevelAmount++;
		mSpeedMultiplier *= 0.9f;
		SingletonObject.getInstance().GetLevelLabel().setTextContent("Level: "+mLevelAmount, HVisible.ALL_STATES);
	}

	public int GetSpeed() {
		return mSpeedMultiplier;
	}
	
	public byte GetLevelAmount() {
		return mLevelAmount;
	}
}
