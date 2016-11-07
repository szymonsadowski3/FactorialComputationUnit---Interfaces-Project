package pl.edu.agh.kis;

import java.util.Comparator;
import java.util.PriorityQueue;

import Interfaces.ComputationsQueue;

/**
 * This class TaskQueue performs computations prioritization
 * @author szymon
 *
 */
public class TaskQueue implements ComputationsQueue {
	/**
	 * Queue capacacity
	 */
	int capacity;
	
	/**
	 * Comparator for Pair class
	 */
	static Comparator<Pair> comparator;
	/**
	 * Queue of tasks
	 */
	static PriorityQueue<Pair> queue;
	
	/**
	 * Default Constructor
	 */
	TaskQueue(int capacity_) {
		Comparator<Pair> comparator = new PairComparator();
		queue = new PriorityQueue<Pair>( capacity_, comparator);
		capacity = capacity_;
	}

	/* 
	 * This method adds Pair [<PRIORITY> <ARGUMENT>] to Queue
	 */
	public void add(Pair toAdd) {
		queue.add(toAdd);
	}
	
	/* 
	 * This method removes Pair [<PRIORITY> <ARGUMENT>] from front of Queue and returns it
	 */
	public Pair remove() {
		return queue.remove();
	}
	
	/* 
	 * 1 if Queue is empty, 0 otherwise
	 */
	public boolean isEmpty() {
		return (queue.size() == 0);
	}
	
	/* 
	 * 1 if Queue is full, 0 otherwise
	 */
	public boolean isFull() {
		return (queue.size() == capacity);
	}
}