package hellotvxlet;

/**
 *
 * @author student
 */
public class Score {
	private int mScore = 0;
	private int mPointsLine = 5;
	private int mTotalLines = 0;

	public Score() {
		
	}
	
	public void UpdatePointsLine(){
		mPointsLine *= 2;
	}
	
	public void AddScore(byte linesGotten){
		mScore += mPointsLine * Math.pow(mTotalLines, 1.5);
		mTotalLines += linesGotten;
	}

	public int GetScore() {
		return mScore;
	}

	public int GetTotalLines() {
		return mTotalLines;
	}
}
