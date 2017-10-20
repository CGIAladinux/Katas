package kata.tennisgame.app.status;

import kata.tennisgame.app.GameUnit;

public class Advantage implements GameUnitState {

	@Override
	public void setState(GameUnit context) {
		context.setState(this);
	}

}
