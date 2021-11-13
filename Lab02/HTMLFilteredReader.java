/*
 * HTMLFilteredReader class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 25/06/2021
 */


public class HTMLFilteredReader extends MySimpleURLReader {
    String pageContents;

    /**
     * Constructs HTMLFilteredReader and initializes pageContents
     * @param URL URL from user
     */
    public HTMLFilteredReader( String URL ) {
        super( URL );
        pageContents = super.getPageContents();
    }

    /**
     * @return Page contents without the HTML parts
     */
    public String getPageContents() {
        String finalOutput;

        finalOutput = pageContents.replaceAll( "<.*?>", "" );
        return finalOutput;
    }

    /**
     * @return Unfiltered page contents with HTML parts
     */
    public String getUnfilteredPageContents() {
        return pageContents;
    }
}
