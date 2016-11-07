package pl.edu.agh.kis;

import java.io.IOException;

/**
 * The Class Factorial, which is used to compute Factorials even for huge
 * numbers (operation results are BigIntegers)
 * 
 * @see <a href=
 *      "https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html">
 *      BigInteger</a>
 * @author szymon sadowski
 */
public class Main {
	static final int CAPACITY = 5;

	public static void main(String[] args) throws IOException {
		ProgramRunner runner = new ProgramRunner(new TaskQueue(CAPACITY), CAPACITY);

		if (args.length >= 1) {
			runner.runWithArgs(args);
		} else {
			runner.runWithNoArgs();
			// ProgramRunner.runWithArgsInFile("/tmp/factorial_args.txt");
		}
	}
}