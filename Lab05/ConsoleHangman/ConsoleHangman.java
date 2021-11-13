/*
 * Main class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 16/07/2021
 */


import java.util.Scanner;

public class ConsoleHangman
{
	/**
	 * Keeps the game going until it finishes.
	 *
	 * @param args Command line arguments
	 */
    public static void main( String[] args)
	{
		// Variables
    	Scanner scan = new Scanner( System.in);
    	char chosenLetter;
    	int occurrences;

    	System.out.println( "Start of ConsoleHangman\n");

		HangmanModel hangman;
		ConsoleHangmanView firstView;
		ConsoleHangmanView secondView;

		// Program
		hangman = new HangmanModel( new MySetup() );
		firstView = new ConsoleHangmanView();
		secondView = new ConsoleHangmanView();

		// Add views
		hangman.addView( firstView );
		hangman.addView( secondView );

		System.out.println( "Mystery word: " + hangman.getKnownSoFar() );

		do {
			System.out.print( "Chosen letter: " );
			chosenLetter = scan.next().toLowerCase().charAt( 0 );

			occurrences = hangman.tryThis( chosenLetter );

			if ( occurrences > 0 ) {
				System.out.println( chosenLetter + " occurs in the word " + occurrences + " times." );

			}
			else if ( occurrences == 0 ) {
				System.out.println( chosenLetter + " is not in the word." );

			}
			else {
				System.out.println( "You already tried this letter." );
			}
			System.out.println();
		}
		while ( !hangman.isGameOver() );

		System.out.println( "End of ConsoleHangman\n" );
	}

}
