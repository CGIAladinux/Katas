/**
 * 
 */
package kata.tennisgame.app.status;

import kata.tennisgame.app.GameUnit;

/**
 * @author Aladinux
 *
 */
public class Deuce implements GameUnitState {

	/* (non-Javadoc)
	 * @see kata.tennisgame.status.GameState#doAction(kata.tennisgame.Game)
	 */
	@Override
	public void setState(GameUnit context) {
		context.setState(this);
	}

}
