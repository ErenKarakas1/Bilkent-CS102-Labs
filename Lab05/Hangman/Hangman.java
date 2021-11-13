/*
 * Hangman class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 16/07/2021
 */


public class Hangman {

    // Hangman setup
    private IHangmanSetup setup;
    private int maxAllowedIncorrectTries;
    private char blankChar;
    private String charsToPreserve;
    private String allLetters;

    // New game settings
    private int numOfIncorrectTries;
    private String usedLetters;
    private String secretWord;
    private String knownSoFar;

    /**
     * Constructs a Hangman game
     *
     * @param givenSetup IHangmanSetup instance
     */
    public Hangman( IHangmanSetup givenSetup ) {
        setup = givenSetup;

        maxAllowedIncorrectTries = setup.getMaxAllowedIncorrectTries();
        blankChar = setup.getBlankChar();
        charsToPreserve = setup.getCharsToPreserve();
        allLetters = setup.getAllLetters();

        initNewGame();
    }

    /**
     * @return All letters game can use
     */
    public String getAllLetters() {
        return allLetters;
    }

    /**
     * @return Used letters for game instance
     */
    public String getUsedLetters() {
        return usedLetters;
    }

    /**
     * @return Number of incorrect tries by the user
     */
    public int getNumOfIncorrectTries() {
        return numOfIncorrectTries;
    }

    /**
     * @return Maximum number of incorrect tries tolerable
     */
    public int getMaxAllowedIncorrectTries() {
        return maxAllowedIncorrectTries;
    }

    /**
     * @return Letters user correctly guessed so far
     */
    public String getKnownSoFar() {
        return knownSoFar;
    }

    /**
     * Checks the letter's availability in the secret word.
     * Updates known word and number of incorrect tries if necessary.
     *
     * @param toTry Letter to try
     * @return Number of occurrences
     */
    public int tryThis( char toTry ) {
        int occurrences;
        StringBuilder tempWord = new StringBuilder( knownSoFar );

        if ( usedLetters.contains( String.valueOf( toTry ) ) ) {
            return -1;
        }
        else {
            occurrences = 0;
            for ( int i = 0; i < secretWord.length(); i++ ) {
                if ( toTry == secretWord.charAt( i ) ) {
                    occurrences++;
                    tempWord.replace( i, i + 1, String.valueOf( toTry ) );
                }
            }
        }

        if ( occurrences == 0 ) {
            numOfIncorrectTries++;
        }

        usedLetters += toTry;
        knownSoFar = tempWord.toString();
        return occurrences;
    }

    /**
     * @return True if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return knownSoFar.equals( secretWord ) || hasLost();
    }

    /**
     * @return True if the player lost, false otherwise
     */
    public boolean hasLost() {
        return numOfIncorrectTries == maxAllowedIncorrectTries;
    }

    /**
     * Initiates a new game.
     */
    public void initNewGame() {
        numOfIncorrectTries = 0;
        usedLetters = "";
        secretWord = setup.chooseSecretWord();
        knownSoFar = ( blankChar + "" ).repeat( secretWord.length() );
    }
}
