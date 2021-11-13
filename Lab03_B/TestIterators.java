/*
 * Test class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


import java.util.Iterator;

public class TestIterators {

    /**
     * Main method
     * @param args Command line arguments
     */
    public static void main( String[] args ) {

        // Iterates the IntBag without step value
        System.out.println( "Without step value" );
        IntBag bag1 = new IntBag();
        fill( bag1, 6 );

        iterate( bag1 );

        System.out.println( "\n\n" );

        // Iterates the IntBag with step value
        System.out.println( "With step value" );
        IntBag bag2 = new IntBag( 3 );
        fill( bag2, 21 );

        iterate( bag2 );
    }

    /**
     * Iterates through the given bag, copied from Lab instructions
     * @param bag IntBag instance
     */
    public static void iterate(IntBag bag) {
        Iterator i, j;
        i = bag.iterator();

        while (i.hasNext()) {
            System.out.println( i.next() );
            j = bag.iterator();
            while ( j.hasNext() ) {
                System.out.println( "--" + j.next() );
            }
        }
    }

    /**
     * Fills the bag until value
     * @param bag IntBag instance
     * @param value Value to fill until ( exclusive )
     */
    public static void fill( IntBag bag, int value ) {
        for ( int i = 1; i < value; i++ ) {
            bag.add( i );
        }
    }
}
