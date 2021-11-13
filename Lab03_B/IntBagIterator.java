/*
 * IntBagIterator to iterate through IntBag
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


public class IntBagIterator implements IntIterator {

    private IntBag aBag;
    private int index;

    /**
     * Constructs a regular iterator for the IntBag class
     * @param bag IntBag instance
     */
    public IntBagIterator( IntBag bag ) {
        aBag = bag;
        index = -1;
    }

    /**
     * @return Object at next index
     */
    public Object next() {
        index++;
        return aBag.intAtIndex( index );
    }

    /**
     * Returns the value as int, default option
     * @return int at next index
     */
    public int nextInt() {
        index++;
        return aBag.intAtIndex( index );
    }

    /**
     * @return True if there is one more value to iterate
     */
    public boolean hasNext() {
        return index < aBag.size() - 1;
    }
}
