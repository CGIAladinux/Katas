/**
 * 
 */
package kata.tennisgame.app;

/**
 * @author Aladinux
 *
 */
public class ScoreEngine {
	
	private ScoreEngine()
	{}
 
	private static ScoreEngine INSTANCE = null;
 
	public static ScoreEngine getInstance()
	{	
		if (INSTANCE == null)
		{ 	
			synchronized(ScoreEngine.class)
			{
				if (INSTANCE == null)
				{	INSTANCE = new ScoreEngine();
				}
			}
		}
		return INSTANCE;
	}
	
	private static final int[]	SCORE	= { 0, 15, 30, 40 };
	private static final String[]	SCOREDESC	= { "love", "fifteen", "thirty", "forty" };
	
	/**
	 * 
	 * @param points
	 * @return
	 */
	public Integer getScore(int points) {
		if (points <= 3)
			return SCORE[points];
		return SCORE[3];
	}

	/**
	 * 
	 * @param points
	 * @return
	 */
	public String getScoreDesc(int points) {
		if (points <= 3)
			return SCOREDESC[points];
		return SCOREDESC[3];
	}
}
