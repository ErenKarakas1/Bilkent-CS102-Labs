
/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman() {
    	System.out.println( "Start of GUIHangman\n");

		HangmanModel		hangman;
		IHangmanSetup		mySetup;
		ConsoleHangmanView	consoleView;

		mySetup = new MySetup();
		hangman = new HangmanModel( mySetup );

		consoleView = new ConsoleHangmanView();
		hangman.addView( consoleView );

		TextFieldControlPanel topPanel = new TextFieldControlPanel( hangman );
		NewGameButtonControl southButton = new NewGameButtonControl( hangman );
		LabelsHangmanView westView = new LabelsHangmanView( hangman );
		GallowsHangmanView centerView = new GallowsHangmanView( hangman );
		HangmanLetterButtonControl eastView = new HangmanLetterButtonControl( hangman, 13, 2 );

		eastView.addActionListener( new HangmanLetterButtonController( hangman ) );

		hangman.addView( westView );
		hangman.addView( centerView );
		hangman.addView( eastView );
		hangman.addView( southButton );

		new SimpleJFrame( "GUIHangman", centerView, topPanel, southButton, eastView, westView );

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman );;
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
