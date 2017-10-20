package kata.tennisgame.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Match implements Playable {

	
	private Map<Player, java.util.Set<Set>> scoreSets = new HashMap<>();
	
	private Set currentSet;
	
	@Autowired
	private MatchHandler matchHandler;
	
	
	
	public Match(MatchHandler matchHandler) {
		super();
		this.matchHandler = matchHandler;
	}

	private void initScore() {
		scoreSets.put(matchHandler.getPlayerOne(), new HashSet<Set>());
		scoreSets.put(matchHandler.getPlayerTwo(), new HashSet<Set>());
	}
	
	@Override
	public void start() {
		initScore();
		int setNumber = 1;
		while(!end()) {
			currentSet = new Set(matchHandler, setNumber);
			currentSet.start();
			currentSet.getScore();
			setNumber++;
		}
		
	}

	@Override
	public boolean end() {
		if(isFifthSetReached() && currentSet.end()) {
			return true;
		}
		return false;
	}

	private boolean isFifthSetReached() {
		return currentSet.getSetNumber() == 5? true: false;
	}

}
