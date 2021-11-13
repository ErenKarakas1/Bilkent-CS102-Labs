/*
 * MySimpleURLReader class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 25/06/2021
 */


import cs1.*;

public class MySimpleURLReader extends SimpleURLReader {
    private final String URL;
    private String filename;
    private String pageContents;

    /**
     * Constructs MySimpleURLReader and initializes pageContents
     * Then finds the file name
     * @param URL URL from user
     */
    public MySimpleURLReader( String URL ) {
        super( URL );
        this.URL = URL;
        pageContents = super.getPageContents();

        String[] urlParts = URL.split( "/" );
        filename = urlParts[urlParts.length - 1];
    }

    public String getURL() {
        return URL;
    }

    public String getName() {
        return filename;
    }

    /**
     * Checks every line to see if a line contains both <link and .css
     * Increments the counter if contains
     * @return Int to represent number of CSS links
     */
    public int getNumberOfCSSLinks() {
        String[] lines = pageContents.split( "\n" );
        int counter = 0;

        for ( String line : lines ) {
            if ( line.contains( "<link" ) && line.contains( ".css" )) {
                counter++;
            }
        }

        return counter;
    }
}
