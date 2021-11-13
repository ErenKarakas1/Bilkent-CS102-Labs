/*
 * Container to hold shapes and select/locate them
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


import java.util.ArrayList;

public class ShapeContainer {

    private ArrayList<Shape> shapes;

    /**
     * Constructs a ShapeContainer
     * Initializes empty ArrayList of shapes
     */
    public ShapeContainer() {
        shapes = new ArrayList<>();
    }

    /**
     * Adds a shape to container
     * @param s Shape to add
     */
    public void add( Shape s ) {
        shapes.add( s );
    }

    /**
     * @return Total area of all shapes
     */
    public double getArea() {
        double entireArea = 0;

        for ( Shape s : shapes ) {
            entireArea += s.getArea();
        }

        return entireArea;
    }

    /**
     * @return Total perimeter of all shapes
     */
    public double getPerimeter() {
        double entirePerimeter = 0;

        for ( Shape s : shapes ) {
            entirePerimeter += s.getPerimeter();
        }

        return entirePerimeter;
    }

    /**
     * Checks if location contains a shape, returns the shape if it does
     * @param x X coordinate
     * @param y Y coordinate
     * @return Shape if one is found
     */
    public Shape firstFoundShape( int x, int y ) {
        for ( Shape s : shapes ) {
            if ( s.contains( x, y ) != null ) {
                return s;
            }
        }

        return null;
    }

    /**
     * Selects/Unselects a shape
     * @param s Shape to select/unselect
     * @param bool True if user wanted to select, false otherwise
     */
    public void toggleSelected( Shape s, boolean bool ) {
        s.setSelected( bool );
    }

    /**
     * Removes all selected shapes
     */
    public void removeAll() {
        ArrayList<Shape> newShapes = new ArrayList<>();

        for ( Shape s : shapes ) {
            if ( !s.getSelected() ) {
                newShapes.add( s );
            }
        }

        shapes = newShapes;
    }

    /**
     * @return String representation of a container's inside
     */
    public String toString() {
        StringBuilder finalString = new StringBuilder( "The container includes: " );

        for ( Shape s : shapes ) {
            finalString.append( "\n" ).append( s.toString() );
        }

        return finalString.toString();
    }
}
