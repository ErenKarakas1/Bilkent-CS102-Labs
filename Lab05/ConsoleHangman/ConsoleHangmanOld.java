/*
 * Old main class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 16/07/2021
 */


import java.util.Scanner;

public class ConsoleHangmanOld
{
    public static void main( String[] args)
	{
    	Scanner scan = new Scanner( System.in);
    	char chosenLetter;
    	int occurrences;

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		Hangman hangman;
		ConsoleHangmanView firstView;
		ConsoleHangmanOld secondView;

		// PROGRAM CODE
		hangman = new Hangman( new BasicSetup() );

		System.out.println( hangman.getKnownSoFar() );

		do {
			System.out.print( "Chosen letter: " );
			chosenLetter = scan.next().charAt( 0 );

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

			System.out.println( hangman.getKnownSoFar() );
		}
		while ( !hangman.isGameOver() );

		if ( hangman.hasLost() ) {
			System.out.println( "You lost, sorry." );
		}
		else {
			System.out.println( "Congratulations, you won!" );
		}

		System.out.println( "\nEnd of ConsoleHangman\n" );
	}

} // end of class ConsoleHangman
