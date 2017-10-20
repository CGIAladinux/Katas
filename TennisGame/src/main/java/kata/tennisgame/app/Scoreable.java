package kata.tennisgame.app;

public interface Scoreable<T> {
	
	T getScore();

	void resetScore();
}
