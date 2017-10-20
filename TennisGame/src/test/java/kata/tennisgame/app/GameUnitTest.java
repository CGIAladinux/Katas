/**
 * 
 */
package kata.tennisgame.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Aladinux
 *
 */
public class GameUnitTest {
	
    GameUnit currentGame;
    Player playerOne = new Player("Aladin");
    Player playerTwo = new Player("Andy");
	private MatchHandler matchHandler;
    
    @Before
    public void beforeGameTest() {
		matchHandler = new MatchHandler(playerOne, playerTwo);
        currentGame = new GameUnit(matchHandler, 1);
    }
    
    @Test
    public void advantageShouldBe_AtLeastScoredFortyByEachSideAndAdvantagePlayerHasOnePointMoreThanHisOpponent() {
    	matchHandler.resetScores();
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            playerOne.winPoint();
            playerTwo.winPoint();
        });
        playerTwo.winPoint();
        assertEquals(new Integer(40), playerOne.getScore());
        assertEquals(new Integer(40), playerTwo.getScore());
        assertEquals(playerTwo, matchHandler.getAdvantagePlayer());
    }
 
    @Test
    public void deuceShouldBe_AtLeastFortyScoredByEachSideAndTheScoresAreEqual() {
    	matchHandler.resetScores();
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            playerOne.winPoint();
            playerTwo.winPoint();
        });
        assertEquals(new Integer(40), playerOne.getScore());
        assertEquals(new Integer(40), playerTwo.getScore());
        assertEquals(null, matchHandler.getAdvantagePlayer());
    }
 
    @Test
    public void gameUnitShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
//    	IntStream.rangeClosed(1, 3).forEach((Integer) -> {
//            playerOne.winPoint();
//            playerTwo.winPoint();
//        });
//    	playerTwo.winPoint();
//    	playerTwo.winPoint();
    	currentGame.start();
    	
    	assertEquals(playerTwo, matchHandler.getLeadPlayer());
    	assertEquals(2, matchHandler.getScoreGape());
    }
    
	/**
	 * Test method for {@link kata.tennisgame.app.GameUnit#start()}.
	 */
	@Test
	public void testStart() {
		currentGame.resetScore();
		
		java.util.Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		    	currentGame.start();
		    	Thread.sleep(5000);
		        return "Task 1";
		    }
		});
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			List<Future<String>> futures = executor.invokeAll(callables);
			futures.stream().forEach(task -> {try {
				task.get(10, TimeUnit.MILLISECONDS);
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
			 // Timeout of 10 seconds.
				fail(e.getMessage());
			}assertTrue(task.isDone());});
			executor.shutdown();
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link kata.tennisgame.app.GameUnit#resetScore()}.
	 */
	@Test
	public void testResetScore() {
		currentGame.resetScore();
		assertEquals(0, playerOne.getPointsNb());
		assertEquals(0, playerTwo.getPointsNb());
	}

}
