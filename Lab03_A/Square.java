/*
 * Square class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


public class Square extends Rectangle {

    private int side;

    /**
     * Constructs a square class
     * @param side Side length
     */
    public Square( int side ) {
        super( side, side );
        this.side = side;
    }

    /**
     * Calculate area of square
     * @return Area
     */
    public double getArea() {
        return super.getArea();
    }

    /**
     * Calculate the perimeter of square
     * @return Perimeter
     */
    public double getPerimeter() {
        return super.getPerimeter();
    }

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return Shape if it contains the point
     */
    public Shape contains( int x, int y ) {
        return super.contains( x, y );
    }

    /**
     * @return String representation of a square
     */
    public String toString() {
        return "A square with sides " + side  + ". Selected: " + this.getSelected();
    }
}
