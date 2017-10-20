package kata.tennisgame.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
	
	Set currentSet;
    Player playerOne = new Player("Aladin");
    Player playerTwo = new Player("Andy");
	MatchHandler matchHandler;
	
	@Before
    public void beforeSetTest() {
		matchHandler = new MatchHandler(playerOne, playerTwo);
		currentSet = new Set(matchHandler, 1);
    }

	@Test
    public void setShouldBeWonByTheFirstPlayerToHaveWonAtLeastSixGameUnitsAndWithAtLeastTwoSetsMoreThanTheOpponent() {
		currentSet.start();
		System.out.println(currentSet.getSetHist());
		System.out.println(currentSet.getScore());
		assertNotEquals(null, currentSet.getSetWinnerPlayer());
	}

	@Test
	public void testGetLeadingPlayer() {
		assertEquals(null, currentSet.getLeadingPlayer());
		currentSet.getScore().put(playerOne, 3);
		assertEquals(playerOne, currentSet.getLeadingPlayer());
	}

	@Test
	public void testGetSetWinnerPlayer() {
		currentSet.resetScore();
		assertEquals(null, currentSet.getSetWinnerPlayer());
		currentSet.getScore().put(playerOne, 6);
		currentSet.getScore().put(playerTwo, 4);
		assertEquals(playerOne, currentSet.getSetWinnerPlayer());
	}

	@Test
	public void testResetScore() {
		currentSet.resetScore();
		assertTrue(currentSet.getScore() != null);
		assertEquals(new Integer(0),currentSet.getScore().get(playerOne));
		assertEquals(new Integer(0),currentSet.getScore().get(playerTwo));
	}

}
