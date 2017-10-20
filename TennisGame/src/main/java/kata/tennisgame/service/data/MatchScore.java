package kata.tennisgame.service.data;

import java.util.List;
import java.util.Set;

public class MatchScore {
	
	private List<SetScore> setsScores;

	public MatchScore(List<SetScore> setsScores) {
		super();
		this.setsScores = setsScores;
	}

	/**
	 * @return the setsScores
	 */
	public List<SetScore> getSetsScores() {
		return setsScores;
	}

	/**
	 * @param setsScores the setsScores to set
	 */
	public void setSetsScores(List<SetScore> setsScores) {
		this.setsScores = setsScores;
	}
	
	

}
