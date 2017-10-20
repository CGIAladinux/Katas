/**
 * 
 */
package kata.tennisgame.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Aladinux
 *
 */
public class PlayerTest {
	
	Player player = new Player("Aladin");
	
	/**
	 * Test method for {@link kata.tennisgame.app.Player#getScore()}.
	 */
	@Test
	public void testGetScore() {
		assertEquals(new Integer(0), player.getScore());
		player.setPointsNb(1);
		assertEquals(new Integer(15), player.getScore());
		player.setPointsNb(2);
		assertEquals(new Integer(30), player.getScore());
		player.setPointsNb(3);
		assertEquals(new Integer(40), player.getScore());
		player.setPointsNb(4);
		assertEquals(new Integer(40), player.getScore());
	}

	/**
	 * Test method for {@link kata.tennisgame.app.Player#resetScore()}.
	 */
	@Test
	public void testResetScore() {
		player.resetScore();
		assertEquals(0, player.getPointsNb());
	}

	/**
	 * Test method for {@link kata.tennisgame.app.Player#winPoint()}.
	 */
	@Test
	public void testWinPoint() {
		player.resetScore();
		assertEquals(0, player.getPointsNb());
		player.winPoint();
		assertEquals(1, player.getPointsNb());
		player.winPoint();
		assertEquals(2, player.getPointsNb());
	}

}
