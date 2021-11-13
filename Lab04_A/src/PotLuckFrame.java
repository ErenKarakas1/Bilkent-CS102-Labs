/*
 * PotLuckFrame class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 09/07/2021
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PotLuckFrame extends JFrame implements MouseListener {

    // Properties for GUI
    private JFrame frame;
    private JPanel upperPanel;
    private JPanel mainPanel;
    private GameButton[] buttons;
    private JLabel statusBar;
    private JLabel prize;
    private JLabel bomb;

    //Properties for game
    private int row;
    private int column;
    private int attempts;
    private boolean bombFound;
    private boolean prizeFound;

    /**
     * Constructs a PotLuckFrame for a PotLuck game
     */
    public PotLuckFrame() throws IOException {
        // Initialize game properties
        row = 4;
        column = 4;
        attempts = 0;
        bombFound = false;
        prizeFound = false;

        // Initialize GUI properties
        frame = new JFrame();
        buttons = new GameButton[row * column];
        upperPanel = new JPanel();
        mainPanel = new JPanel();
        statusBar = new JLabel( "You have guessed " + attempts + " times." );

        BufferedImage bombPic = ImageIO.read( new File( "/home/eren/IdeaProjects/CS102_lab04_A/bomb.jpg" ) );
        bomb = new JLabel( new ImageIcon( bombPic ) );

        BufferedImage prizePic = ImageIO.read( new File( "/home/eren/IdeaProjects/CS102_lab04_A/prize.jpg" ) );
        prize = new JLabel( new ImageIcon( prizePic ) );

        frame.setLayout( new BorderLayout() );

        // Creates the status bar and adds it to the top
        upperPanel.add( statusBar );
        frame.add( upperPanel, BorderLayout.NORTH );

        // Creates the game windows and adds it to the center
        mainPanel.setLayout( new GridLayout( row, column ) );
        completeLayout();
        frame.add( mainPanel, BorderLayout.CENTER );

        // Default options for the frame
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 800, 800 );
        frame.setVisible( true );
    }

    /**
     * Fills out the GridLayout to contain the PotLuck game
     */
    public void completeLayout() {
        int indexOfPrize;
        int indexOfBomb1;
        int indexOfBomb2;

        // Fill the GridLayout with buttons, add listener
        for ( int i = 0; i < row * column; i++ ) {
            GameButton button = new GameButton();
            button.addMouseListener( this );

            buttons[i] = button;
            mainPanel.add( button );
        }

        // Create 3 ints for special buttons until they are all distinct
        do {
            indexOfPrize = ( int ) ( Math.random() * row * column );
            indexOfBomb1 = ( int ) ( Math.random() * row * column );
            indexOfBomb2 = ( int ) ( Math.random() * row * column );
        }
        while ( indexOfPrize == indexOfBomb1 || indexOfPrize == indexOfBomb2 || indexOfBomb1 == indexOfBomb2);

        // Set special buttons to hide prize/bomb
        buttons[indexOfPrize].setHasPrize( true );
        buttons[indexOfBomb1].setHasBomb( true );
        buttons[indexOfBomb2].setHasBomb( true );

        System.out.println( indexOfBomb1 );
        System.out.println( indexOfBomb2 );
        System.out.println( indexOfPrize );
    }

    /**
     * Passes a turn in the game.
     *
     * Increments attempts and changes the status bar.
     * If prize/bomb is found, ends the game
     */
    private void turnPassed() {
        attempts++;
        statusBar.setText( "You have guessed " + attempts + " times." );

        if ( bombFound || prizeFound ) {
            endGame();
        }
    }

    /**
     * Ends the game.
     *
     * Sets status bar according to the game outcome.
     * Hides the game panel.
     */
    private void endGame() {
        if ( bombFound ) {
            statusBar.setText( "Sorry! You are blown up at attempt " + attempts  + "!" );
            frame.remove( mainPanel );
            frame.add( bomb, BorderLayout.CENTER );
        }
        else if ( prizeFound ) {
            statusBar.setText( "You got it in " + attempts + " attempts!" );
            frame.remove( mainPanel );
            frame.add( prize, BorderLayout.CENTER );
        }
    }

    /**
     * Gets the button clicked and checks if it contains bomb/prize.
     * Passes the turn.
     * @param event A MouseEvent
     */
    @Override
    public void mouseClicked( MouseEvent event ) {
        GameButton button = ( GameButton ) event.getComponent();

        button.setBackground( Color.RED );

        bombFound = button.getHasBomb();
        prizeFound = button.getHasPrize();
        turnPassed();
    }

    @Override
    public void mousePressed( MouseEvent event ) {

    }

    @Override
    public void mouseReleased( MouseEvent event ) {

    }

    @Override
    public void mouseEntered( MouseEvent event ) {

    }

    @Override
    public void mouseExited( MouseEvent event ) {

    }
}
