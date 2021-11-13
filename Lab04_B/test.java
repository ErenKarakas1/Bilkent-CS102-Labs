/*
 * Main class for testing
 * @author Eren Karakas 22002722
 * @version 1.0
 * 09/07/2021
 */


import cs101.sosgame.SOS;
import javax.swing.*;

public class test {

    /**
     * Main class.
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        // Create game, canvas, GUI, frame
        SOS game = new SOS( 5 );
        SOSCanvas canvas = new SOSCanvas( game );
        SOSGUIPanel panel = new SOSGUIPanel( game, canvas, "Ahmet", "Mehmet" );

        JFrame frame = new JFrame();
        frame.add( panel );

        // Default settings for frame
        frame.setSize( 800, 800 );
        frame.setLocationRelativeTo( null );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
        frame.pack();
    }
}
