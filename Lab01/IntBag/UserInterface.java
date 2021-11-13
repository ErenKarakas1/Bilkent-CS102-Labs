/*
 * User interface IntBag class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 17/06/2021
 */


package library.IntBag;
import java.util.Scanner;

public class UserInterface {

    /**
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        int userAnswer;
        IntBag bag = null;
        Scanner scanner = new Scanner( System.in );

        do {
            //Displays the menu for user
            System.out.println( "1. Create a new empty collection (any previous values are lost!)" );
            System.out.println( "2. Read a set of positive values into the collection (use zero to indicate " +
                                "all the values have been entered.)" );
            System.out.println( "3. Print the collection of values" );
            System.out.println( "4. Add a value to the collection of values at a specified location" );
            System.out.println( "5. Remove the value at a specified location from the collection of values" );
            System.out.println( "6. Remove all instances of a value within the collection" );
            System.out.println( "7. Quit the program." );
            System.out.print( "Your choice: " );

            userAnswer = scanner.nextInt();
            System.out.println();

            // Creates a new IntBag
            if ( userAnswer == 1 ) {
                bag = new IntBag();
            }
            else {
                // Checks if the user created an empty collection
                if ( bag == null ) {
                    System.out.println( "You should create a collection first!" );
                }
                // Adds the values until encountering 0
                else if ( userAnswer == 2 ) {
                    System.out.print( "Enter the values: " );
                    int num = 1;

                    while ( num != 0 ) {
                        num = scanner.nextInt();

                        if ( num != 0 ) {
                            bag.add(num);
                        }
                    }
                }
                // Displays the bag
                else if ( userAnswer == 3 ) {
                    System.out.println( bag );
                }
                // Adds the specified value to the specified index
                else if ( userAnswer == 4 ) {
                    int index;
                    int value;

                    System.out.print( "The index you want the value to go and the value (example: 3 5): " );
                    index = scanner.nextInt();
                    value = scanner.nextInt();

                    bag.add( index, value );
                }
                // Deletes the value at the specified index
                else if ( userAnswer == 5 ) {
                    int index;

                    System.out.print( "Index you want to delete from: " );
                    index = scanner.nextInt();

                    bag.remove( index );
                }
                // Removes all occurrences of a value
                else if ( userAnswer == 6 ) {
                    int value;

                    System.out.print( "Value you want to delete: " );
                    value = scanner.nextInt();

                    bag.removeAll( value );
                }
                // Quits the program
                else if ( userAnswer == 7 ) {
                    System.out.println( "Goodbye!" );
                }
                else {
                    System.out.println( "Invalid choice!" );
                }
            }
            System.out.println();
        }
        while ( userAnswer != 7 );
    }
}
