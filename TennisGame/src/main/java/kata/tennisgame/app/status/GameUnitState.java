package kata.tennisgame.app.status;

import kata.tennisgame.app.GameUnit;

public interface GameUnitState {
	public void setState(GameUnit context);
}
