/**
 * IHangmanView - view interface for MVC demo using Hangman
 *
 * @author David
 * @version 1.00 2013/4/7
 */
public interface IHangmanView
{
	/**
	 * Updates Hangman game's views
	 *
	 * @param hangmanModel Model to represent Hangman class
	 */
	void updateView( Hangman hangmanModel );
}