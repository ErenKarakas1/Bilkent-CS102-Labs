/*
 * IntBagStepIterator to iterate through IntBag with step values
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


public class IntBagStepIterator implements IntIterator {

    private IntBag aBag;
    private int step;
    private int index;

    /**
     * Constructs a stepping iterator for the IntBag class
     * @param bag IntBag instance
     * @param stepValue value to step
     */
    public IntBagStepIterator( IntBag bag, int stepValue ) {
        aBag = bag;
        index = -stepValue;
        step = stepValue;
    }

    /**
     * @return Object at next index
     */
    public Object next() {
        index += step;
        return aBag.intAtIndex( index );
    }

    /**
     * Returns the value as int, default option
     * @return int at next index
     */
    public int nextInt() {
        index += step;
        return aBag.intAtIndex( index );
    }

    /**
     * @return True if there is one more value to iterate
     */
    public boolean hasNext() {
        return index < aBag.size() - step;
    }
}
