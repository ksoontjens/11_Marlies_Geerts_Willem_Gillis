package hellotvxlet;

import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Level {

	private static int mSpeedMultiplier = 1000;
	private static byte mLevelAmount = 1;

	public static void LevelUp() {
		mLevelAmount++;
		mSpeedMultiplier *= 0.9f;
		HelloTVXlet.GetLevelLabel().setTextContent("Level: "+mLevelAmount, HVisible.ALL_STATES);
	}

	public static int GetSpeed() {
		return mSpeedMultiplier;
	}
	
	public static byte GetLevelAmount() {
		return mLevelAmount;
	}
}
