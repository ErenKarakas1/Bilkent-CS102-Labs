/*
 * SOSCanvas class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 09/07/2021
 */


import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;


public class SOSCanvas extends JPanel {

    private SOS game;

    /**
     * Constructs a SOSCanvas to display the game.
     *
     * @param game A SOS game
     */
    public SOSCanvas( SOS game ) {
        this.game = game;
    }

    /**
     * Paints the game board.
     *
     * @param g Graphics
     */
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);

        int x = 150;
        int y = 100;
        int width = 100;
        int height = 100;

        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++) {
                // Draw the rectangles
                g.drawRect(x, y, width, height);
                // Draw the inside
                g.drawString(String.valueOf( game.getCellContents(i, k)), x + width / 2, y + height / 2 );
                x += width;
            }
            x = 150;
            y += height;
        }
    }
}
