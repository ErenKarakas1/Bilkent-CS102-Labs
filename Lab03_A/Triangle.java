/*
 * Triangle class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


public class Triangle extends Shape {

    private final int sideA;
    private final int sideB;
    private final int sideC;

    /**
     * Constructor for triangle class
     * @param a First side length
     * @param b Second side length
     * @param c Third side length
     */
    public Triangle( int a, int b, int c ) {
        sideA = a;
        sideB = b;
        sideC = c;
    }

    /**
     * Calculate area of triangle with the Heron formula
     * @return Area
     */
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;

        return Math.sqrt(     halfPerimeter *
                            ( halfPerimeter - sideA ) *
                            ( halfPerimeter - sideB ) *
                            ( halfPerimeter - sideC ) );
    }

    /**
     * Calculate the perimeter of triangle
     * @return Perimeter
     */
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return Shape if it contains the point
     */
    public Shape contains( int x, int y ) {
        int maxHeight = this.y + sideA;
        int maxWidth = this.x + sideB;

        double firstArea = calculateArea( this.x, this.y, this.x, maxHeight, x, y );
        double secondArea = calculateArea( this.x, this.y, maxWidth, this.y, x, y );
        double thirdArea = calculateArea( this.x, maxHeight, maxWidth, this.y, x, y );

        if ( firstArea + secondArea + thirdArea == getArea() * 2 ) {
            return this;
        }

        return null;
    }

    /**
     * Calculates the area of a triangle using 3 points
     * @param x1 X coordinate of first point
     * @param y1 Y coordinate of first point
     * @param x2 X coordinate of second point
     * @param y2 Y coordinate of second point
     * @param x3 X coordinate of third point
     * @param y3 Y coordinate of third point
     * @return Area of a triangle
     */
    private double calculateArea( int x1, int y1, int x2, int y2, int x3, int y3 ) {
        return Math.abs( x1 * ( y2 - y3 ) + x2 * ( y3 - y1 ) + x3 * ( y1 - y2 ) / 2.0 );
    }

    /**
     * @return String representation of a triangle
     */
    public String toString() {
        return "A triangle with sides " + sideA + ", " + sideB + ", " + sideC  + ". Selected: " + this.getSelected();
    }
}
