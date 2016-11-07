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

	public static void main(String[] args) throws IOException {
		Config appConfig = new Config(5, 5);
		ProgramRunner runner = new ProgramRunner(new TaskQueue(appConfig.getQueueCapacity()),
				appConfig.getCacheCapacity());

		if (args.length >= 1) {
			runner.runWithArgs(args);
		} else {
			runner.runWithNoArgs();
		}
	}
}