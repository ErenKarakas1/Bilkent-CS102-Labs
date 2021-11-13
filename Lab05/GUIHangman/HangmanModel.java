import java.util.*;

// HangmanModel - extends hangman adding support for single/multiple views & controllers
// David, 2012/4/8

public class HangmanModel extends Hangman
{
	private ArrayList<IHangmanView> views = new ArrayList<>();
	// IHangmanView	view;

	public HangmanModel( IHangmanSetup setup )
	{
		super( setup );
		// view = null;
	}

	/**
	 * Tries the letter for hangman game
	 *
	 * @param letter Letter to try
	 * @return Number of occurrences
	 */
	@Override
	public int tryThis( char letter)
	{
		int result = super.tryThis( letter );
		notifyViews();
		return result;
	}

	/**
	 * Initiates a new game
	 */
	@Override
	public void initNewGame()
	{
		super.initNewGame();
		notifyViews();
	}


	// **********************************************************
	// * Single View Support
	// **********************************************************
//	public void addView( IHangmanView view)
//	{
//		this.view = view;
//		notifyViews();
//	}
//
//	public void notifyViews()
//	{
//		if ( view != null)
//			view.updateView( this);
//	}

	// **********************************************************
	// * Multiple View Support
	// **********************************************************
	/**
	 * Adds the view to game
	 *
	 * @param view A view for game
	 */
	public void addView( IHangmanView view )
	{
		views.add( view );
		notifyViews();
	}

	/**
	 * Updates the views in game
	 */
	public void notifyViews()
	{
		if ( views != null)
			for ( IHangmanView view : views)
				view.updateView( this );
	}

	public void removeView( IHangmanView view)
	{
		views.remove( view );
	}

} // end class HangmanModel