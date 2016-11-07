package pl.edu.agh.kis;

import java.math.BigInteger;

import Interfaces.Cache;

/**
 * Class FactorialComputer which performs Factorials Computations (n!=?)
 * 
 * @author szymon
 *
 */
public class FactorialComputer {
	/**
	 * Computed results are stored here so to reuse them in future
	 */
	Cache cache;

	FactorialComputer(int cacheCapacity) {
		cache = new ResultsStorage(cacheCapacity);
	}

	/**
	 * @param index
	 *            Given index. In its left neighborhood results will be searched
	 * @return Index of nearest result on the left to input <code>index</code>
	 */
	int findNearestResultBelowGivenIndex(int index) {
		for (int i = index; i >= 0; --i) {
			if (cache.containsIndex(i)) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * @param index
	 *            Given index. In its left neighborhood results will be searched
	 * @return Nearest result on the left to index
	 */
	BigInteger getNearestResultBelowGivenIndex(int index) {
		int bestIndex = findNearestResultBelowGivenIndex(index);
		return cache.getResult(bestIndex);
	}

	/**
	 * This method is advanced Factorial calculator (reuses previous results
	 * stored in <code>storage</code>)
	 * 
	 * @param index
	 *            index of already stored result in <code>storage</code>
	 * @param storedResult
	 *            its value is <code>index!</code>. Function will make use of
	 *            this result
	 * @param n
	 *            argument to compute Factorial from
	 * @return n!
	 */
	BigInteger calculateFactorialReusingResult(int index, int n, BigInteger storedResult) {
		BigInteger result = new BigInteger("" + storedResult);

		for (int i = index + 1; i <= n; ++i) {
			result = result.multiply(new BigInteger("" + i));
		}

		return result;
	}

	/**
	 * This method is advanced Factorial calculator (reuses previous results
	 * stored in <code>storage</code>). This method finds the best result in
	 * <code>storage</code> by itself.
	 * 
	 * @param n
	 *            argument to compute Factorial from
	 * @return n!
	 */
	BigInteger calculateFactorialReusingResult(int n) {
		BigInteger storedResult = new BigInteger("0");
		storedResult = getNearestResultBelowGivenIndex(n);
		int storedResultIndex = findNearestResultBelowGivenIndex(n);

		BigInteger result = calculateFactorialReusingResult(storedResultIndex, n, storedResult);

		cache.storeResult(n, result);

		return result;
	}
}
