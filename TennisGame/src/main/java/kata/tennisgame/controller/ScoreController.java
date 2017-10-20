package kata.tennisgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kata.tennisgame.service.ScoreService;
import kata.tennisgame.service.data.MatchScore;

@RestController
@RequestMapping("/TennisMatch/ScoreBoard")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping("/hello")
    public String index() {
        return "Greetings from TennisGame App!";
    }
	
	@RequestMapping(value = "/Score", method = RequestMethod.GET, produces = "application/json")
	public MatchScore getScore() {
		MatchScore currentScore = scoreService.getCurrentScore();
		return currentScore;
	}
	
	@RequestMapping(value = "/Set/{setNumber}", method = RequestMethod.GET)
	public String getSetScore(@PathVariable("setNumber") String setNumber) {
		return "Set ["+setNumber +"] Score";
	}
	
	@RequestMapping("/Players")
	public String getPlayers() {
		return "Players:";
	}

	@RequestMapping("/Score/{playername}")
	public String getPlayerScore(@PathVariable("playername") String playerName) {
		return "Players:";
	}

	@RequestMapping("/Score")
	public ResponseEntity<?> getScoreByPlayerName(@RequestParam("playername") String playerName) {
		return new ResponseEntity<>("Players:"+playerName, HttpStatus.OK);
	}

}
