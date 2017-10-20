package kata.tennisgame.service.data;

import java.util.List;

public class SetScore {
	
	private List<String> score;

	public SetScore(List<String> score) {
		super();
		this.score = score;
	}

	/**
	 * @return the score
	 */
	public List<String> getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(List<String> score) {
		this.score = score;
	}
	
	

}
