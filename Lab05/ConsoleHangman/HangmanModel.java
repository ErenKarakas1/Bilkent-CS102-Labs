/*
 * Hangman class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 16/07/2021
 */


import java.util.ArrayList;

public class HangmanModel extends Hangman {

    private ArrayList<IHangmanView> views;

    /**
     * Constructs a class to model Hangman.
     * Initiates the model with the given setup.
     *
     * @param givenSetup IHangmanSetup instance
     */
    public HangmanModel( IHangmanSetup givenSetup ) {
        super( givenSetup );
        views = new ArrayList<>();
    }

    /**
     * Adds additional view to game
     *
     * @param view IHangmanView instance
     */
    public void addView( IHangmanView view ) {
        views.add( view );
    }

    /**
     * Updates game views
     */
    public void update() {
        if ( views != null ) {
            for ( IHangmanView view : views ) {
                view.updateView(this );
            }
        }
    }

    /**
     * Updates the views after the normal tryThis method
     */
    public int tryThis( char toTry ) {
        int result;

        result = super.tryThis( toTry );
        update();

        return result;
    }

    /**
     * Updates the views after the normal initNewGame method
     */
    public void initNewGame() {
        super.initNewGame();
        update();
    }
}
