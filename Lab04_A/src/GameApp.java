/*
 * Main class to play the game
 * @author Eren Karakas 22002722
 * @version 1.0
 * 09/07/2021
 */


public class GameApp {

    /**
     * Main class.
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        try {
            PotLuckFrame frame = new PotLuckFrame();
        }
        catch ( Exception e ) {
            System.out.println( "Can not load photos." );
        }
    }
}
