/*
 * HangmanLetterButtonControl class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 26/07/2021
 */


import java.awt.*;

public class HangmanLetterButtonControl extends LetterButtonControls implements IHangmanView {

    /**
     * Constructs a HangmanLetterButtonControl instance
     * Displays the alphabet as a panel
     *
     * @param hangman Hangman game instance
     * @param rows Rows in panel
     * @param columns Columns in panel
     */
    public HangmanLetterButtonControl( Hangman hangman, int rows, int columns ) {
        super( hangman.getAllLetters(), rows, columns );
        this.setPreferredSize( new Dimension( 600, 400 ) );
        this.setFont( new Font( "Times New Roman", Font.BOLD, 15 ) );
    }

    public void updateView( Hangman hangman ) {
        if ( !hangman.getUsedLetters().equals( "" ) ) {
            this.setDisabled( hangman.getUsedLetters() );
        }

        if ( hangman.isGameOver() ) {
            setEnabledAll( true );
        }
    }
}
