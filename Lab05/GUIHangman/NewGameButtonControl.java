/*
 * NewGameButtonControl class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 26/07/2021
 */


import javax.swing.*;

public class NewGameButtonControl extends JButton implements IHangmanView {

    private Hangman hangman;

    /**
     * Constructs a NewGameButtonControl instance
     * Adds ActionListener to initiate a new game
     *
     * @param game Hangman game instance
     */
    public NewGameButtonControl( Hangman game ) {
        super( "New Game" );
        hangman = game;
        setText( "New Game" );

        addActionListener( e -> {
            hangman.initNewGame();
            this.setEnabled( false );
        } );
    }

    public void updateView( Hangman game ) {
        if ( game.isGameOver() ) {
            this.setEnabled( true );
        }
    }
}
