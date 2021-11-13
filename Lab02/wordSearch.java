/*
 * wordSearch class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 25/06/2021
 */


import java.util.ArrayList;

public class wordSearch extends HTMLFilteredReader {
    private String pageContents;
    private String[] allWords;

    /**
     * Constructs wordSearcher and initializes pageContents
     * Then removes whitespace characters
     * @param URL URL from user
     */
    public wordSearch( String URL ) {
        super( URL );
        pageContents = super.getPageContents();
        allWords = pageContents.split( "[\t\n\s]" );
    }

    /**
     * Iterates over the words to find target words' locations
     * Updates counter only when iterated word is not empty
     * @param targetWords Words to look for as array
     * @return An ArrayList containing locations
     */
    public ArrayList<Integer> searchWords(String[] targetWords ) {
        int counter = 0;
        ArrayList<Integer> locations = new ArrayList<>();

        for ( int i = 0; i < targetWords.length; i++ ) {
            for (String word : allWords) {
                if ( word.equals( targetWords[i] ) ) {
                    locations.add( counter );
                }
                if (!word.equals("")) {
                    counter++;
                }
            }
        }

        return locations;
    }
}
