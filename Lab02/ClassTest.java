import cs1.*;

public class ClassTest {

    public static void main( String[] args ) {
        SimpleURLReader urlReader = new SimpleURLReader( "https://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt" );

        System.out.println( urlReader.getPageContents() );
        System.out.println( urlReader.getLineCount() );
    }
}
