/*
 * Answer for Q3
 * @author Eren Karakas 22002722
 * @version 1.0
 * 21/07/2021
 */


import java.util.Scanner;

public class Q3 {

    /**
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        String[] nums;
        int input;

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Input: " );

        input = scanner.nextInt();
        nums = new String[input];
        findBinaries( nums, 0, input );
    }

    /**
     * Recursively creates binary numbers that doesn't have back to back 1s with given digits
     *
     * @param nums Array to add numbers
     * @param position Current index
     * @param length Maximum index
     */
    public static void findBinaries( String[] nums, int position, int length ) {
        if ( position == length ) {
            printArray( nums, length );
        }
        else {
            nums[position] = 0 + " ";
            findBinaries( nums, position + 1, length );

            if ( position == 0 || !nums[position - 1].equals( 1 + " " ) ) {
                nums[position] = 1 + " ";
                findBinaries( nums, position + 1, length );
            }
        }
    }

    /**
     * Displays given array's contents
     *
     * @param nums Array to print
     * @param length Number of digits for a binary number
     */
    public static void printArray( String[] nums, int length ) {
        for ( int i = 0; i < nums.length; i++ ) {
            if ( i % length == 0 ) {
                System.out.println();
            }
            System.out.print( nums[i] );
        }
    }
}
