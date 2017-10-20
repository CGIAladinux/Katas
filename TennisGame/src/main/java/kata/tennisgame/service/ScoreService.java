package kata.tennisgame.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kata.tennisgame.app.Match;
import kata.tennisgame.service.data.MatchScore;
import kata.tennisgame.service.data.SetScore;

@Service
public class ScoreService {

	@Autowired
	private Match tennisMatch;

	public MatchScore getCurrentScore() {
		List<SetScore> setsScores = new ArrayList<>();
		List<String> score = new ArrayList<>();
		score.add("Aladin 6 - 3 AI");
		SetScore setScore = new SetScore(score );
		setsScores.add(setScore);
		return new MatchScore(setsScores);
		// TODO Auto-generated method stub
		
	}
}
