/**
 * 
 */
package kata.tennisgame.app;

import org.springframework.stereotype.Component;

/**
 * @author Aladinux
 *
 */
@Component
public class Player implements Scoreable<Integer> {

	private String	name;
	
	private int	pointsNb = 0;
	
	public Player(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pointsNb
	 */
	public int getPointsNb() {
		return pointsNb;
	}

	/**
	 * @param pointsNb the pointsNb to set
	 */
	public void setPointsNb(int pointsNb) {
		this.pointsNb = pointsNb;
	}

	@Override
	public Integer getScore() {
		return ScoreEngine.getInstance().getScore(pointsNb);
	}

	@Override
	public void resetScore() {
		setPointsNb(0);
	}
	
	public void winPoint() {
		pointsNb++;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + name + " : " + getScore() + "]";
	}
	
	

}
