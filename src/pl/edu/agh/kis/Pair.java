package pl.edu.agh.kis;

/**
 * Simple utility class, storing two integers
 * 
 * @author szymon
 *
 */
public class Pair {
	int first;
	int second;

	/**
	 * @param f
	 *            first integer to be stored
	 * @param s
	 *            second integer to be stored
	 */
	Pair(int f, int s) {
		first = f;
		second = s;
	}

	/**
	 * @return first integer
	 */
	public int getFirst() {
		return first;
	}

	/**
	 * @return second integer
	 */
	public int getSecond() {
		return second;
	}
}
