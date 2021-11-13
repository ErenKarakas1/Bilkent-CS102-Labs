/*
 * Testing FibonacciCalculator
 * @author Eren Karakas 22002722
 * @version 1.0
 * 17/06/2021
 */


package library.fibonacci;

public class TestApp {

    /**
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        FibonacciCalculator calculator = new FibonacciCalculator();

        System.out.println( calculator.calculate( 40 ) );
        System.out.println( calculator.calculate( 30 ) );
        System.out.println( calculator );
    }
}
