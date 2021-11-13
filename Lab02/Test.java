/*
 * Testing purposes
 * @author Eren Karakas 22002722
 * @version 1.0
 * 25/06/2021
 */


import java.util.Scanner;

public class Test {

    public static void main ( String[] args ) {
        //PART B. Testing MySimpleURLReader
        MySimpleURLReader urlReader = new MySimpleURLReader( "https://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html" );

        System.out.println( urlReader.getURL() );

        //PART C. Testing MySimpleURLReader
        MySimpleURLReader urlReader1 = new MySimpleURLReader( "https://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt" );
        System.out.println( urlReader.getNumberOfCSSLinks() );
        System.out.println( urlReader1.getNumberOfCSSLinks() );

        //PART D. Testing HTMLFilteredReader
        HTMLFilteredReader htmlReader = new HTMLFilteredReader( "https://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html" );

        System.out.println( htmlReader.getPageContents() );

        //PART E. Testing wordSearch
        wordSearch wordReader = new wordSearch( "https://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html" );
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Words you want to search (eg. X,Y): " );
        String words = scanner.nextLine();

        System.out.println( wordReader.searchWords( words.split( "," ) ) );
    }
}
