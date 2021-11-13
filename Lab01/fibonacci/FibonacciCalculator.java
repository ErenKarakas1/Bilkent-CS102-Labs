/*
 * Fibonacci calculator using IntBag class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 17/06/2021
 */


package library.fibonacci;
import library.IntBag.IntBag;

public class FibonacciCalculator {
    // Properties
    private IntBag fiboNumbers;

    // Constructor
    /**
     * Constructor initializes an IntBag then
     * adds 0 and 1
     */
    public FibonacciCalculator() {
        fiboNumbers = new IntBag();

        fiboNumbers.add( 0 );
        fiboNumbers.add( 1 );
    }

    /**
     * @param number Desired Fibonacci number's location
     * @return Desired Fibonacci number
     */
    // Methods
    public int calculate( int number ) {
        int size = fiboNumbers.size();
        int newNumber;

        if ( size < number ) {
            for (int i = size; i <= number; i++) {
                // Adds last two values together and adds it to the IntBag
                newNumber = fiboNumbers.intAtIndex( i - 1 ) + fiboNumbers.intAtIndex( i - 2 );
                fiboNumbers.add(newNumber);
            }
        }
        return fiboNumbers.intAtIndex( number );
    }

    public String toString() {
        return fiboNumbers.toString();
    }
}
