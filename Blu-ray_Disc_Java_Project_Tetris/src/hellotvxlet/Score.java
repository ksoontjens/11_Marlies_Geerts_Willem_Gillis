package hellotvxlet;

import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Score {

	private int mScore = 0;
	private int mPointsLine = 5;
	private int mTotalLines = 0;	
	private int mNextLevelScore = 10;

	private static Score instance = new Score();
	
	public Score() {
		
	}
	
	public static Score getInstance() {
		return instance;
	}
	
	public void UpdatePointsLine() {
		mPointsLine *= 2;
	}

	public void AddScore(byte linesGotten) {
		mScore += mPointsLine * Math.pow(linesGotten, 1.5);
		mTotalLines += linesGotten;
		SingletonObject.getInstance().GetScoreLabel().setTextContent("Score: "+mScore, HVisible.ALL_STATES);
		SingletonObject.getInstance().GetAmountOfLinesLabel().setTextContent("Amount of lines: "+mTotalLines, HVisible.ALL_STATES);
		if (mScore >= mNextLevelScore) {
			Level.getInstance().LevelUp();
			mNextLevelScore += mNextLevelScore *1.2;
		}
	}

	public int GetScore() {
		return mScore;
	}

	public int GetTotalLines() {
		return mTotalLines;
	}
}
