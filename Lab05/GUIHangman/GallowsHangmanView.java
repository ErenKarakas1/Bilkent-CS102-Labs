/*
 * GallowsHangmanView class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 26/07/2021
 */


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class GallowsHangmanView extends JPanel implements IHangmanView {

    private Hangman hangman;
    private int incorrectTries;
    private Shape[] manParts;

    /**
     * Constructs a GallowsHangmanView instance
     * Creates the shapes for hangman's model
     *
     * @param game Hangman instance
     */
    public GallowsHangmanView( Hangman game ) {
        hangman = game;
        incorrectTries = hangman.getNumOfIncorrectTries();
        manParts = new Shape[6];

        // Head
        Ellipse2D.Double manHead = new Ellipse2D.Double( 470, 250, 60, 60 );
        manParts[0] = manHead;

        Line2D.Double manTorso = new Line2D.Double(manHead.getX() + manHead.getWidth() / 2,
                                                    manHead.getY() + manHead.getHeight(),
                                                    manHead.getX() + manHead.getWidth() / 2,
                                                    manHead.getY() + manHead.getHeight() + 90 );

        // Torso
        manParts[1] = manTorso;

        // Arms
        manParts[2] = new Line2D.Double( manHead.getX() + manHead.getWidth() / 2,
                                        ( manTorso.getY1() + manTorso.getY2() ) / 2,
                                        manHead.getX() + manHead.getWidth() / 2 + 40,
                                        ( manTorso.getY1() + manTorso.getY2() ) / 2 );

        manParts[3] = new Line2D.Double( manHead.getX() + manHead.getWidth() / 2,
                                        ( manTorso.getY1() + manTorso.getY2() ) / 2,
                                        manHead.getX() + manHead.getWidth() / 2 - 40,
                                        ( manTorso.getY1() + manTorso.getY2() ) / 2 );

        // Legs
        manParts[4] = new Line2D.Double( manHead.getX() + manHead.getWidth() / 2,
                                            manTorso.getY2(),
                                        manHead.getX() + manHead.getWidth() / 2 - 40,
                                        manTorso.getY2() + 40 );

        manParts[5] = new Line2D.Double( manHead.getX() + manHead.getWidth() / 2,
                                            manTorso.getY2(),
                                        manHead.getX() + manHead.getWidth() / 2 + 40,
                                        manTorso.getY2() + 40 );
    }


    public void updateView(Hangman hangmanModel) {
        incorrectTries = hangman.getNumOfIncorrectTries();
        repaint();
    }

    /**
     * Paints the necessary parts of Hangman
     *
     * @param g Graphics
     */
    public void paintComponent( Graphics g ) {
        super.paintComponents( g );
        Graphics2D g2D = ( Graphics2D ) g;

        // Clear
        g.setColor( new Color( 238, 238, 238 ) );
        for ( int i = 0; i < 6; i++ ) {
            g2D.draw( manParts[i] );
        }

        g.setColor( Color.BLACK );

        g.drawLine(200, 600, 350, 600); //Platform

        g.drawLine(275, 600, 275, 200); //Pole

        g.drawLine(275, 200, 500, 200);

        g.drawLine(500, 200, 500, 250);

        for ( int i = 0; i < incorrectTries; i++ ) {
            g2D.draw( manParts[i] );
        }
    }
}
