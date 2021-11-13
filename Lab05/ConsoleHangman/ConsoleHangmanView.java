/*
 * ConsoleHangmanView class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 16/07/2021
 */


public class ConsoleHangmanView implements IHangmanView {

    private Hangman hangman;

    public void updateView( Hangman hangmanModel ) {
        hangman = hangmanModel;

        System.out.println( "\nNumber of incorrect tries: " + hangman.getNumOfIncorrectTries() );
        System.out.println( "Known so far: " + hangman.getKnownSoFar() );

        if ( hangman.isGameOver() ) {
            if ( hangman.hasLost() ) {
                System.out.println("\nSorry, you lost!");
            }
            else {
                System.out.println("\nCongratulations, you won.");
            }
        }
    }
}
