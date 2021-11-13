/*
 * Answer for Q1
 * @author Eren Karakas 22002722
 * @version 1.0
 * 20/07/2021
 */


import java.util.Scanner;

public class Q1 {

    /**
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        String input;

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Input: " );

        input = scanner.nextLine();
        System.out.println( findLength( input ) );
    }

    /**
     * Recursively calculates a String's length
     *
     * @param target String to calculate its length
     * @return target's length
     */
    public static int findLength( String target ) {
        if ( target.equals( "" ) ) {
            return 0;
        }
        else {
            return findLength( target.substring( 1 ) ) + 1;
        }
    }
}
