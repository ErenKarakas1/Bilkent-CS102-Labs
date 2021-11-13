/*
 * GameButton class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 09/07/2021
 */


import javax.swing.*;

public class GameButton extends JButton {

    // Properties
    private boolean hasPrize;
    private boolean hasBomb;

    /**
     * Constructs a GameButton and sets hasPrize, hasBomb to false
     */
    public GameButton() {
        hasPrize = false;
        hasBomb = false;
    }

    /**
     * Returns if button hides prize or not
     * @return hasPrize
     */
    public boolean getHasPrize() {
        return hasPrize;
    }

    /**
     * Returns if button hides bomb or not
     * @return hasBomb
     */
    public boolean getHasBomb() {
        return hasBomb;
    }

    /**
     * Hides a prize in button if parameter is true
     * @param bool Boolean by user
     */
    public void setHasPrize( boolean bool ) {
        hasPrize = bool;
    }

    /**
     * Hides a bomb in button if parameter is true
     * @param bool Boolean by user
     */
    public void setHasBomb( boolean bool ) {
        hasBomb = bool;
    }
}
