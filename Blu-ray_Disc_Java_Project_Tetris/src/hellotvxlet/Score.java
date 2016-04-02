package hellotvxlet;

import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Score {

	private static int mScore = 0;
	private static int mPointsLine = 5;
	private static int mTotalLines = 0;	
	private static int mNextLevelScore = 5;

	public static void UpdatePointsLine() {
		mPointsLine *= 2;
	}

	public static void AddScore(byte linesGotten) {
		mScore += mPointsLine * Math.pow(linesGotten, 1.5);
		mTotalLines += linesGotten;
		HelloTVXlet.GetScoreLabel().setTextContent("Score: "+mScore, HVisible.ALL_STATES);
		HelloTVXlet.GetAmountOfLinesLabel().setTextContent("Amount of lines: "+mTotalLines, HVisible.ALL_STATES);
		if (mScore >= mNextLevelScore) {
			Level.LevelUp();
			mNextLevelScore += mNextLevelScore *1.2;
		}
	}

	public static int GetScore() {
		return mScore;
	}

	public static int GetTotalLines() {
		return mTotalLines;
	}
}
