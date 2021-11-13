/*
 * IHangmanSetup class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 16/07/2021
 */


public interface IHangmanSetup {

    /**
     * @return Maximum number of incorrect tries tolerable
     */
    int getMaxAllowedIncorrectTries();

    /**
     * @return Char to be used in place of unknown letters
     */
    char getBlankChar();

    /**
     * @return Set of chars preserved in secret word, usually space
     */
    String getCharsToPreserve();

    /**
     * @return Alphabet
     */
    String getAllLetters();

    /**
     * Randomly chooses a secret word from pre-defined list
     *
     * @return Secret word
     */
    String chooseSecretWord();
}
