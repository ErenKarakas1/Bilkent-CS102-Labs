/*
 * MySetup class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 16/07/2021
 */


public class MySetup implements IHangmanSetup {

    private static String[] words = { "fox", "lion", "elephant",
            "cheetah", "crocodile",
            "hyena", "tiger", "horse" };

    public int getMaxAllowedIncorrectTries() {
        return 6;
    }

    public char	getBlankChar() {
        return '*';
    }

    public String getCharsToPreserve() {
        return " ";
    }

    public String getAllLetters() {
        return "abcdefghijklmnopqrstuvwxyz";
    }

    public String chooseSecretWord() {
        int random = ( int ) (Math.random() * words.length );
        return words[random];
    }
}
