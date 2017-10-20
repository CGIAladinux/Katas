/**
 * 
 */
package kata.tennisgame.app;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Aladinux
 *
 */
public class MatchHandlerTest {
	
	MatchHandler matchHandler;
	Player playerOne = new Player("Aladin");
    Player playerTwo = new Player("Andy");
    
    @Before
    public void beforeGameTest() {
		matchHandler = new MatchHandler(playerOne, playerTwo);
    }

	/**
	 * Test method for {@link kata.tennisgame.app.MatchHandler#attributePoint(kata.tennisgame.app.Player)}.
	 */
	@Test
	public void testAttributePoint() {
		playerOne.resetScore();
		matchHandler.attributePoint(playerOne);
		assertEquals(1, playerOne.getPointsNb());
	}

	/**
	 * Test method for {@link kata.tennisgame.app.MatchHandler#resetScores()}.
	 */
	@Test
	public void testResetScores() {
		matchHandler.attributePoint(playerOne);
		matchHandler.attributePoint(playerTwo);
		matchHandler.resetScores();
		assertEquals(0, playerOne.getPointsNb());
		assertEquals(0, playerTwo.getPointsNb());
	}

	/**
	 * Test method for {@link kata.tennisgame.app.MatchHandler#getAdvantagePlayer()}.
	 */
	@Test
	public void testGetAdvantagePlayer() {
		matchHandler.resetScores();
		matchHandler.attributePoint(playerOne);
		assertEquals(null, matchHandler.getAdvantagePlayer());
		matchHandler.attributePoint(playerTwo);
		assertEquals(null, matchHandler.getAdvantagePlayer());
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			playerOne.winPoint();
		});
		IntStream.rangeClosed(1, 2).forEach((Integer) -> {
			playerTwo.winPoint();
		});
		assertEquals(playerOne, matchHandler.getAdvantagePlayer());
	}

	/**
	 * Test method for {@link kata.tennisgame.app.MatchHandler#getAdvantagePlayer()}.
	 */
	@Test
	public void testGetLeadPlayer() {
		matchHandler.resetScores();
		matchHandler.attributePoint(playerOne);
		assertEquals(playerOne, matchHandler.getLeadPlayer());
		matchHandler.attributePoint(playerTwo);
		assertEquals(null, matchHandler.getLeadPlayer());
	}

	/**
	 * Test method for {@link kata.tennisgame.app.MatchHandler#getPlayerBehind()}.
	 */
	@Test
	public void testGetPlayerBehind() {
		matchHandler.resetScores();
		matchHandler.attributePoint(playerOne);
		assertEquals(playerTwo, matchHandler.getPlayerBehind());
		matchHandler.attributePoint(playerTwo);
		assertEquals(null, matchHandler.getPlayerBehind());
	}

	/**
	 * Test method for {@link kata.tennisgame.app.MatchHandler#attributeWinnerPlayer()}.
	 */
	@Test
	public void testAttributeWinnerPlayer() {
		matchHandler.resetScores();
		matchHandler.attributeWinnerPlayer();
		Player leadPlayer = matchHandler.getLeadPlayer();
		assertTrue(playerOne.equals(leadPlayer) || playerTwo.equals(leadPlayer));
	}

	/**
	 * Test method for {@link kata.tennisgame.app.MatchHandler#getScoreGape()}.
	 */
	@Test
	public void testGetScoreGape() {
		matchHandler.resetScores();
		matchHandler.attributeWinnerPlayer();
		assertTrue(matchHandler.getScoreGape() == 1);
	}
	
	@Test
    public void loveShouldBe_ForScore0() {
    	assertEquals("", new Integer(0), matchHandler.getPlayerOne().getScore());
    	assertEquals("", new Integer(0), matchHandler.getPlayerTwo().getScore());
    }
 
    @Test
    public void fifteenShouldBe_ForScore15() {
    	matchHandler.resetScores();
    	matchHandler.attributePoint(playerOne);
    	matchHandler.attributePoint(playerTwo);
    	assertEquals("", new Integer(15), matchHandler.getPlayerOne().getScore());
    	assertEquals("", new Integer(15), matchHandler.getPlayerTwo().getScore());
    }
 
    @Test
    public void thirtyShouldBe_ForScore30() {
    	matchHandler.resetScores();
    	IntStream.rangeClosed(1, 2).forEach((Integer) -> {
    		playerOne.winPoint();
    		playerTwo.winPoint();
    	});
    	assertEquals("", new Integer(30), matchHandler.getPlayerOne().getScore());
    	assertEquals("", new Integer(30), matchHandler.getPlayerTwo().getScore());
    }
 
    @Test
    public void fortyShouldBe_ForScore40() {
    	matchHandler.resetScores();
    	IntStream.rangeClosed(1, 3).forEach((Integer) -> {
    		playerOne.winPoint();
    		playerTwo.winPoint();
    	});
    	assertEquals("", new Integer(40), matchHandler.getPlayerOne().getScore());
    	assertEquals("", new Integer(40), matchHandler.getPlayerTwo().getScore());
    }

}
