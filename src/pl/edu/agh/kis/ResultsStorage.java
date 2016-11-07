package pl.edu.agh.kis;

import java.math.BigInteger;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;

import Interfaces.Cache;

/**
 * Class ResultStorage computes Factorials reusing previously stored results
 * 
 * @author szymon
 *
 */
public class ResultsStorage implements Cache {
	/**
	 * Computed results are stored here so to reuse them in future
	 */
	LinkedHashMap<Integer, BigInteger> storage;
	/**
	 * Max size of <code>storage</code>
	 */
	int storageSupremum;
	/**
	 * Current size of <code>storage</code>
	 */
	int currentSize;

	/**
	 * Parametrized constructor
	 * 
	 * @param length
	 *            Capacity of <code>storage</code>
	 */
	ResultsStorage(int length) {
		storage = new LinkedHashMap<Integer, BigInteger>(length);
		storage.put(new Integer(0), new BigInteger("" + 1));

		storageSupremum = length;
		currentSize = 1;
	}

	/**
	 * @return 1 if Storage is empty, 0 otherwise
	 */
	public boolean isEmpty() {
		if (currentSize == 0)
			return true;
		else
			return false;
	}

	/**
	 * @return 1 if Storage is full, 0 otherwise
	 */
	public boolean isFull() {
		return (currentSize == storageSupremum);
	}

	/**
	 * This method is used to store some results in <code>storage</code>
	 * 
	 * @param index
	 *            number for which index! was previously computed
	 * @param result
	 *            result is index!
	 */
	public void storeResult(int index, BigInteger result) { //PRIORITIZING INSIDE
		if (isFull()) {
			System.out.println("Cache is full! Removing least used element");
			deleteLeastUsedResult();
		}
		
		if (!containsIndex(index)) {
			storage.put(index, result);
			currentSize++;
		} else {
			storage.remove(index);
			storage.put(index, result);
		}
	}

	/**
	 * this method returns Result previously computed for given index
	 */
	public BigInteger getResult(int index) { //PRIORITIZING INSIDE
		BigInteger result = storage.get(index);
		storage.remove(index);
		storage.put(index, result);
		return result;
	}

	/**
	 * @return 1 if Storage contains result of given index
	 */
	public boolean containsIndex(int index) {
		return storage.containsKey(index);
	}

	/**
	 * Simple printing the storage
	 */
	public void print() {
		for (Integer name : storage.keySet()) {

			String key = name.toString();
			String value = storage.get(name).toString();
			System.out.println(key + " " + value);
		}
	}
	
	/* 
	 * This method removes all results from cache (cache is re-constructed)
	 */
	public void clearCache() {
		storage = new LinkedHashMap<Integer, BigInteger>(storageSupremum);
		storage.put(new Integer(3), new BigInteger("" + 6));
		currentSize = 1;
	}
	
	/**
	 *  This method removes this result from cache which was the least used 
	 */
	public void deleteLeastUsedResult() {
		int keyFirst;
		keyFirst = storage.keySet().iterator().next();
		storage.remove(keyFirst);
		--currentSize;
	}
	
	public long evaluateMemoryUsage() {
		long suma = 0;
		
		for (BigInteger bigInt : storage.values()) {
			suma += ObjectSizeFetcher.getObjectSize(bigInt);
		}
		
		return suma;
	}
}