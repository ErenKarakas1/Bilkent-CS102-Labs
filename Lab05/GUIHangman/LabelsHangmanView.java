/*
 * LabelsHangmanView class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 26/07/2021
 */


import javax.swing.*;
import java.awt.*;

public class LabelsHangmanView extends JPanel implements IHangmanView {

    private Hangman hangman;
    private JLabel incorrectTries;
    private JLabel knownLetters;
    private JLabel usedLetters;
    private JLabel result;

    /**
     * Initializes necessary labels for gameplay
     *
     * @param game Hangman game instance
     */
    public LabelsHangmanView( Hangman game ) {
        super();
        this.setPreferredSize( new Dimension( 600, 400 ) );

        hangman = game;
        incorrectTries = new JLabel();
        knownLetters = new JLabel();
        usedLetters = new JLabel();
        result = new JLabel();

        Font font = new Font( "Times New Roman", Font.BOLD, 24 );
        incorrectTries.setFont( font );
        knownLetters.setFont( font );
        usedLetters.setFont( font );
        result.setFont( font );

        GridLayout layout = new GridLayout( 4, 1 );
        this.setLayout( layout );

        this.add( knownLetters );
        this.add( incorrectTries );
        this.add( usedLetters );
        this.add( result );

        this.setBackground( Color.GREEN );
    }

    public void updateView( Hangman hangmanModel ) {
        incorrectTries.setText("Incorrect tries: " + hangmanModel.getNumOfIncorrectTries());
        knownLetters.setText("Known letters so far: " + hangmanModel.getKnownSoFar());
        usedLetters.setText("Used letters: " + hangmanModel.getUsedLetters());
        result.setText( "" );

        if ( hangman.isGameOver() ) {
            if ( hangman.hasLost() ) {
                result.setText( "You lost!" );
            }
            else {
                result.setText( "You won!" );
            }
        }
    }
}
