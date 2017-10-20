package kata.tennisgame.app;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchHandler {

	@Autowired
	private Player playerOne, playerTwo;

	public MatchHandler(Player playerOne, Player playerTwo) {
		super();
		this.setPlayerOne(playerOne);
		this.setPlayerTwo(playerTwo);
	}

	/**
	 * @return the playerOne
	 */
	public Player getPlayerOne() {
		return playerOne;
	}

	/**
	 * @param playerOne
	 *            the playerOne to set
	 */
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	/**
	 * @return the playerTwo
	 */
	public Player getPlayerTwo() {
		return playerTwo;
	}

	/**
	 * @param playerTwo
	 *            the playerTwo to set
	 */
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public void attributePoint(Player winnerPlayer) {
		winnerPlayer.winPoint();
	}

	/**
	 * 
	 */
	public void resetScores() {
		playerOne.resetScore();
		playerTwo.resetScore();
	}

	/**
	 * 
	 * @return
	 */
	public Player getAdvantagePlayer() {
		if (playerOne.getPointsNb() <= 3 && playerTwo.getPointsNb() <= 3) {
			return null;
		}
		return getLeadPlayer();
	}

	/**
	 * 
	 * @return
	 */
	public Player getLeadPlayer() {
		return (playerOne.getPointsNb() > playerTwo.getPointsNb() ? playerOne
				: (playerOne.getPointsNb() < playerTwo.getPointsNb()) ? playerTwo : null);
	}

	/**
	 * 
	 * @return
	 */
	public Player getPlayerBehind() {
		if (getLeadPlayer() == null)
			return null;
		if (playerOne.equals(getLeadPlayer())) {
			return playerTwo;
		}
		return playerOne;
	}

	/**
	 * 
	 * @return
	 */
	public int getScoreGape() {
		return Math.abs(playerOne.getPointsNb() - playerTwo.getPointsNb());
	}

	/**
	 * 
	 */
	public void attributeWinnerPlayer() {
		if (new Random().nextBoolean())
			playerOne.winPoint();
		else
		playerTwo.winPoint();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return builder.append(playerOne.toString()).append(playerTwo.toString()).toString();
	}
}
