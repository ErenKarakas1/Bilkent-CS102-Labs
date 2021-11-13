/*
 * Test and menu class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


import java.util.Scanner;

public class ShapeTester {

    /**
     * Main class
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        ShapeContainer container = null;
        int userChoice;
        String shapeChoice;

        do {
            // Display the menu
            System.out.println( "\n1- Create an empty container." );
            System.out.println( "2- Add a shape." );
            System.out.println( "3- Calculate the total area." );
            System.out.println( "4- Calculate the total perimeter." );
            System.out.println( "5- Display the contents." );
            System.out.println( "6- Find the first shape that contains wanted location." );
            System.out.println( "7- Remove all selected shapes." );
            System.out.println( "8- Quit." );

            System.out.print( "Your choice: " );
            userChoice = scanner.nextInt();

            // Create new container or quit the program
            if ( userChoice == 1 ) {
                container = new ShapeContainer();
            }
            else if ( userChoice == 8 ) {
                System.out.println( "Goodbye!" );
            }
            // Block secondary operations
            else if ( container != null ) {

                if (userChoice == 2) {
                    Shape chosenShape = null;

                    System.out.print( "Which shape do you want? (Rectangle, Circle, Square or Triangle): " );
                    shapeChoice = scanner.next();

                    if (shapeChoice.equals( "Rectangle" ) ) {
                        System.out.print( "Width and height: " );
                        int width = scanner.nextInt();
                        int height = scanner.nextInt();

                        chosenShape = new Rectangle( width, height );
                        container.add( chosenShape );
                    }

                    else if ( shapeChoice.equals( "Circle" ) ) {
                        System.out.print( "Radius: " );
                        int radius = scanner.nextInt();

                        chosenShape = new Circle( radius );
                        container.add( chosenShape );
                    }
                    else if ( shapeChoice.equals( "Square" ) ) {
                        System.out.print( "Side: " );
                        int side = scanner.nextInt();

                        chosenShape = new Square( side );
                        container.add( chosenShape );
                    }
                    else if ( shapeChoice.equals( "Triangle" ) ) {
                        System.out.print( "Sides: " );
                        int first = scanner.nextInt();
                        int second = scanner.nextInt();
                        int third = scanner.nextInt();

                        chosenShape = new Triangle( first, second, third );
                        container.add( chosenShape );
                    }
                    else {
                        System.out.println( "Not a valid shape." );
                    }

                    if ( chosenShape != null ) {
                        System.out.print( "Add location to shape ( x, y ): ");
                        int x = scanner.nextInt();
                        int y = scanner.nextInt();

                        chosenShape.setLocation( x, y );
                    }
                }
                else if ( userChoice == 3 ) {
                    System.out.println( "Total area: " + container.getArea() );
                }
                else if ( userChoice == 4 ) {
                    System.out.println( "Total perimeter: " + container.getPerimeter() );
                }
                else if ( userChoice == 5 ) {
                    System.out.println( container );
                }
                else if ( userChoice == 6 ) {
                    System.out.print( "Wanted locations: " );
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    Shape shape = container.firstFoundShape( x, y );

                    // Select/Unselect the shape if a shape was found
                    if ( shape != null ) {
                        System.out.print( "Wanted selected state? ( S to select/U to unselect ): ");
                        String choice = scanner.next();

                        container.toggleSelected( shape, choice.equals( "S" ) );
                    }
                    else {
                        System.out.println( "No shape was found." );
                    }
                }
                else if ( userChoice == 7 ) {
                    container.removeAll();
                }
                else {
                    System.out.println( "Not a valid choice." );
                }
            }
            else {
                System.out.println( "Please create an empty container first." );
            }
        }
        while ( userChoice != 8 );
    }

}
