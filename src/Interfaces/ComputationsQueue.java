package Interfaces;

import pl.edu.agh.kis.Pair;

public interface ComputationsQueue {
	public void add(Pair toAdd);
	public Pair remove();
	public boolean isEmpty();
	public boolean isFull();
}
