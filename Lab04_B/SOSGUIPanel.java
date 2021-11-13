/*
 * SOSGUIPanel class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 09/07/2021
 */


import javax.swing.*;
import cs101.sosgame.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SOSGUIPanel extends JPanel implements MouseListener {

    // Properties for GUI
    private JComboBox<String> box;
    private SOSCanvas canvas;
    private JLabel player1Text;
    private JLabel player2Text;

    // Properties for game
    private SOS game;
    private int turn;
    private String player1;
    private String player2;
    private int player1Score;
    private int player2Score;
    private char choice;

    /**
     * Constructs a SOSGUIPanel.
     *
     * @param game A SOS game
     * @param canvas A SOSCanvas
     * @param player1 First player's name
     * @param player2 Second player's name
     */
    public SOSGUIPanel( SOS game, SOSCanvas canvas, String player1, String player2 ) {
        // Initializes game properties
        this.game = game;
        this.turn = game.getTurn();
        this.player1 = player1;
        this.player2 = player2;
        this.canvas = canvas;
        this.choice = 's';

        // Add SOSCanvas and its listener
        this.setLayout( new BorderLayout() );
        this.add( canvas, BorderLayout.CENTER );
        canvas.addMouseListener( this );
        canvas.setPreferredSize( new Dimension( 800, 700 ) );

        // PlayerScores part
        JPanel playerScores = new JPanel();
        playerScores.setLayout( new FlowLayout() );

        player1Text = new JLabel( player1 + " " + player1Score );
        player1Text.setOpaque( true );

        if ( game.getTurn() == 1 ) {
            player1Text.setBackground( Color.GREEN );
        }
        else {
            player1Text.setBackground( Color.WHITE );
        }

        playerScores.add( player1Text );

        player2Text = new JLabel( player2Score + " " + player2 );
        player2Text.setOpaque( true );

        if ( turn == 2 ) {
            player2Text.setBackground( Color.GREEN );
        }
        else {
            player2Text.setBackground( Color.WHITE );
        }

        playerScores.add( player2Text );
        this.add( playerScores, BorderLayout.NORTH );
        playerScores.setPreferredSize( new Dimension( 800, 50 ) );

        // ComboBox to switch chosen letter
        box = new JComboBox<>();
        box.addItem( "S" );
        box.addItem( "O" );

        // Listener to update the chosen letter
        box.addItemListener( e -> {
            if ( e.getItem() == "S" ) {
                choice = 's';
            }
            else {
                choice = 'o';
            }
        });

        this.add( box, BorderLayout.SOUTH );
        box.setMaximumSize( new Dimension( 50, 50 ) );
    }


    @Override
    public void mouseClicked( MouseEvent e ) {
    }


    /**
     * Listens for mouse presses from players.
     *
     * @param event A MouseEvent
     */
    @Override
    public void mousePressed( MouseEvent event ) {
        // Gets X and Y coordinates to locate rectangle
        int x = event.getX();
        int y = event.getY();

        x -= 150;
        y -= 100;

        int row = y / 100 + 1;
        int col = x / 100 + 1;

        // Plays the move and refreshes scoreboard
        game.play( choice, row, col );

        player1Score = game.getPlayerScore1();
        player1Text.setText(player1 + " " + player1Score);
        player2Score = game.getPlayerScore2();
        player2Text.setText(player2Score + " " + player2);

        // Changes score background to match turn
        turn = game.getTurn();

        if ( turn == 1 ) {
            player1Text.setBackground( Color.GREEN );
            player2Text.setBackground( Color.WHITE );
        }
        else {
            player2Text.setBackground( Color.GREEN );
            player1Text.setBackground( Color.WHITE );
        }

        // Repaints canvas to show move
        canvas.repaint();

        // Displays GameOver dialog
        if ( game.isGameOver() ) {
            if ( player1Score > player2Score ) {
                JOptionPane.showMessageDialog( canvas, player1 + " is the winner!" );
            }
            else if ( player1Score < player2Score ) {
                JOptionPane.showMessageDialog( canvas, player2 + " is the winner!" );
            }
            else {
                JOptionPane.showMessageDialog( canvas, "Game tied!");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
