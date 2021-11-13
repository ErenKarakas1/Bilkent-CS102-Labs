/*
 * TextFieldControlPanel class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 26/07/2021
 */


import javax.swing.*;
import java.awt.*;

public class TextFieldControlPanel extends JPanel {

    private Hangman hangman;
    private TextField input;

    /**
     * Constructs a TextFieldControlPanel instance
     * Adds ActionListener to input written letters
     *
     * @param game Hangman game instance
     */
    public TextFieldControlPanel( Hangman game ) {
        super();

        hangman = game;
        input = new TextField( 15 );
        this.add( input );

        input.addActionListener( e -> {
            String inputLetters = input.getText();

            for ( int i = 0; i < inputLetters.length(); i++ ) {
                hangman.tryThis( inputLetters.charAt( i ) );
            }

            input.setText( "" );
        } );
    }
}
