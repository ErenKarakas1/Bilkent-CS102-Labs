/*
 * GallowsHangmanView class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 26/07/2021
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanLetterButtonController implements ActionListener {

    private Hangman game;

    /**
     * Constructs a HangmanLetterButtonController instance
     *
     * @param hangman Hangman game instance
     */
    public HangmanLetterButtonController( Hangman hangman ) {
        game = hangman;
    }

    /**
     * Takes the letter of clicked button and tries it for Hangman game
     *
     * @param e ActionEvent
     */
    public void actionPerformed( ActionEvent e ) {
        JButton button = ( JButton ) e.getSource();
        char letter = button.getText().charAt( 0 );
        game.tryThis( letter );
    }
}
