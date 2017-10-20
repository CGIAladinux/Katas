package kata.tennisgame.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Set implements Playable, Scoreable<Map<Player,Integer>> {

	private int	setNumber;

	private ArrayList<String> setHist = new ArrayList<>();
	
	private Map<Player, Integer> scoreSets = new HashMap<>();
	
	private GameUnit currentGame;
	
	private boolean tieBreak = false;
	
	private MatchHandler matchHandler;
	
	public Set(MatchHandler matchHandler, int setNumber) {
		this.setNumber = setNumber;
		this.matchHandler = matchHandler;
		this.initScore();
	}

	@Override
	public void start() {
		initScore();
		while (!end()) {
			currentGame = new GameUnit(matchHandler, setHist.size()+1);
			currentGame.resetScore();
			currentGame.start();
			setHist.add(currentGame.toString());
			scoreSets.put(matchHandler.getAdvantagePlayer(), scoreSets.get(matchHandler.getAdvantagePlayer()) + 1);
			if (tieBreak) {
				break;
			}
		}
	}

	public void initScore() {
		scoreSets.put(matchHandler.getPlayerOne(), new Integer(0));
		scoreSets.put(matchHandler.getPlayerTwo(), new Integer(0));
	}

	@Override
	public boolean end() {
		if (isSixGameReached() && !tieBreak) {
			tieBreak = Math.abs(scoreSets.get(matchHandler.getPlayerOne()) - scoreSets.get(matchHandler.getPlayerTwo())) == 0;
		}
		return isSixGameReached()
				&& Math.abs(scoreSets.get(matchHandler.getPlayerOne()) - scoreSets.get(matchHandler.getPlayerTwo())) >= 2;
	}

	/**
	 * 
	 * @return
	 */
	private boolean isSixGameReached() {
		boolean sixGameReached = //currentGame != null && scoreSets.get(matchHandler.getPlayerOne()) != null &&
		        (scoreSets.get(matchHandler.getPlayerOne()) >= 6 || scoreSets.get(matchHandler.getPlayerTwo()) >= 6);
		return sixGameReached;
	}
	
	/**
	 * 
	 * @return
	 */
	public Player getLeadingPlayer() {
		if(scoreSets.get(matchHandler.getPlayerOne()) > scoreSets.get(matchHandler.getPlayerTwo())){
			return matchHandler.getPlayerOne();
		}else if(scoreSets.get(matchHandler.getPlayerOne()) < scoreSets.get(matchHandler.getPlayerTwo())){
			return matchHandler.getPlayerTwo();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public Player getSetWinnerPlayer() {
		if(end()) {
			return getLeadingPlayer();
		}
		return null;
	}
	
	/**
	 * @return the setNumber
	 */
	public int getSetNumber() {
		return setNumber;
	}

	/**
	 * @param setNumber the setNumber to set
	 */
	public void setSetNumber(int setNumber) {
		this.setNumber = setNumber;
	}

	/**
	 * @return the setHist
	 */
	public ArrayList<String> getSetHist() {
		return setHist;
	}

	/**
	 * @param setHist the setHist to set
	 */
	public void setSetHist(ArrayList<String> setHist) {
		this.setHist = setHist;
	}

	/**
	 * @return the currentGame
	 */
	public GameUnit getCurrentGame() {
		return currentGame;
	}

	/**
	 * @param currentGame the currentGame to set
	 */
	public void setCurrentGame(GameUnit currentGame) {
		this.currentGame = currentGame;
	}

	@Override
	public Map<Player, Integer> getScore() {
		return scoreSets;
	}

	@Override
	public void resetScore() {
		scoreSets.clear();		
		this.initScore();
	}

}
