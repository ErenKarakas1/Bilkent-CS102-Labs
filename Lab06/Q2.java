/*
 * Answer for Q2
 * @author Eren Karakas 22002722
 * @version 1.0
 * 21/07/2021
 */


import java.util.Scanner;

public class Q2 {

    /**
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        String input;

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Input: " );

        input = scanner.nextLine();
        System.out.println( findNonVowels( input, input.length() ) );
    }

    /**
     * Recursively counts the amount of non-vowels
     *
     * @param target String to check its letters
     * @param index Index to check
     * @return Number of non-vowels
     */
    public static int findNonVowels( String target, int index ) {
        int result = 0;
        String character = String.valueOf( target.charAt( index - 1 ) );

        // Returns true if character is a letter and a non-vowel
        if ( character.matches( "[a-zA-Z]" ) && !( character.matches( "[aeuoiAEUOI]" ) ) ) {
            result = 1;
        }
        // Base case
        if ( index == 1 ) {
            return result;
        }

        return result + findNonVowels( target, index - 1 );
    }
}