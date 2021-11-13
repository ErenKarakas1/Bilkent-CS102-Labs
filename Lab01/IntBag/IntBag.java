/*
 * IntBag class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 17/06/2021
 */


package library.IntBag;

public class IntBag {
    // Properties
    private int[] bag;

    // Constructor
    /**
     * Constructor initializes an array of ints then
     * puts the sentinel value
     */
    public IntBag() {
        bag = new int[5];
        bag[0] = -1;
    }

    // Methods
    /**
     * @param number Number to add
     * Adds a number to the end of array
     */
    public void add( int number ) {
        int index = size();
        regulateSize( index );

        bag[index + 1] = bag[index];
        bag[index] = number;
    }

    /**
     * @param targetIndex Index to add number to
     * @param number Number to add
     * Adds a number to the specified index
     */
    public void add( int targetIndex, int number ) {
        int index = size();

        if ( targetIndex <= index ) {
            regulateSize( index );

            for ( int i = index; i >= targetIndex; i-- ) {
                bag[i + 1] = bag[i];
            }

            bag[targetIndex] = number;
        }
    }

    /**
     * @param targetIndex Index to remove from
     * Removes the number from the specified index
     */
    public void remove( int targetIndex ) {
        int index = size();

        if ( targetIndex < index ) {
            bag[targetIndex] = bag[index - 1];
            bag[index - 1] = bag[index];
        }
    }

    /**
     * @param number Number to remove
     * Removes all occurrences of the specified number
     */
    public void removeAll( int number ) {
        int counter;
        int index = size();
        int[] newBag = new int[index];

        counter = 0;
        for ( int i = 0; i <= index; i++ ) {
            if ( bag[i] != number ) {
                newBag[counter] = bag[i];
                counter++;
            }
        }

        bag = newBag;
    }

    /**
     * @param number Number to check
     * @return True if IntBag contains the value, false otherwise
     * Checks if IntBag contains the specified value
     */
    public boolean contains( int number ) {
        int index = size();

        for ( int i = 0; i < index; i++ ) {
            if ( bag[i] == number ) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return Size of the IntBag
     * Iterates over the array until the sentinel value, returns
     * the size
     */
    public int size() {
        int size = 0;

        // Iterates until the sentinel value and stops
        for (int i = 0; i < bag.length; i++ ) {
            if ( bag[i] < 0 ) {
                size = i;
                i += bag.length;
            }
        }
        return size;
    }

    /**
     * @param index Index to look for
     * @return Value at the index
     */
    public int intAtIndex( int index ) {
        return bag[index];
    }

    /**
     * @return String representation of the IntBag class
     */
    public String toString() {
        int index = size();
        StringBuffer finalString;

        finalString = new StringBuffer( "[" );

        // Adds the values and commas/spaces until the last value
        for ( int i = 0; i < index; i++ ) {
            finalString.append( bag[i] );
            if ( i != index - 1 ) {
                finalString.append( ", " );
            }
        }

        finalString.append( ']' );
        return finalString.toString();
    }

    /**
     * @param index Index of sentinel value
     * Checks if the array is big enough, doubles its
     * size if necessary
     */
    private void regulateSize( int index ) {
        if ( index == bag.length - 1 ) {
            int[] newBag = new int[bag.length * 2];

            for ( int i = 0; i < bag.length; i++ ) {
                newBag[i] = bag[i];
            }

            bag = newBag;
        }
    }
}
