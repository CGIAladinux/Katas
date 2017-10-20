package kata.tennisgame.app;

import java.util.ArrayList;

import kata.tennisgame.app.status.GameUnitState;

public class GameUnit implements Playable {
	
	private Integer id;
	
	private GameUnitState state;
	
	private ArrayList<String> gameHist = new ArrayList<>();
	
	private MatchHandler matchHandler;

	public GameUnit(MatchHandler matchHandler, int gameNumber) {
		this.matchHandler = matchHandler;
		this.id = gameNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GameUnitState getState() {
		return state;
	}

	public void setState(GameUnitState state) {
		this.state = state;
	}

	@Override
	public void start() {
		resetScore();
		while (!this.end()) {
			matchHandler.attributeWinnerPlayer();
		}
	}

	@Override
	public boolean end() {
		return (matchHandler.getPlayerOne().getPointsNb() > 3 || matchHandler.getPlayerTwo().getPointsNb() > 3)
		        && Math.abs(matchHandler.getPlayerOne().getPointsNb() - matchHandler.getPlayerTwo().getPointsNb()) > 1;
	}

	/**
	 * @return the gameHist
	 */
	public ArrayList<String> getGameHist() {
		return gameHist;
	}

	/**
	 * @param gameHist the gameHist to set
	 */
	public void setGameHist(ArrayList<String> gameHist) {
		this.gameHist = gameHist;
	}

	public void resetScore() {
		matchHandler.resetScores();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[Game (" + id + ")]");
		return  builder.append(matchHandler.toString()).toString();
	}
	
	
}
