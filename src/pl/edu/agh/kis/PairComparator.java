package pl.edu.agh.kis;

import java.util.Comparator;

/**
 * This class is used to compare two Pair Objects by their <code>first</code> field
 * @author szymon
 *
 */
public class PairComparator implements Comparator<Pair>{
	@Override
    public int compare(Pair x, Pair y)
    {
        if (x.getFirst() < y.getFirst())
        {
            return -1;
        }
        if (x.getFirst() > y.getFirst())
        {
            return 1;
        }
        return 0;
    }
}