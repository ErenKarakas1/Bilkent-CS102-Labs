/*
 * Rectangle class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


public class Rectangle extends Shape {

    private final int width;
    private final int height;

    /**
     * Constructs a rectangle class
     * @param width Width length
     * @param height Height length
     */
    public Rectangle( int width, int height ) {
        this.width = width;
        this.height = height;
    }

    /**
     * Calculate area of rectangle
     * @return Area
     */
    public double getArea() {
        return width * height;
    }

    /**
     * Calculate the perimeter of rectangle
     * @return Perimeter
     */
    public double getPerimeter() {
        return 2 * ( width + height );
    }

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return Shape if it contains the point
     */
    public Shape contains( int x, int y ) {
        int maxHeight = this.y + height;
        int maxWidth = this.x + width;

        if ( x < maxWidth && y < maxHeight ) {
            return this;
        }

        return null;
    }

    /**
     * @return String representation of a rectangle
     */
    public String toString() {
        return "A rectangle with width " + width + " and height " + height + ". Selected: " + this.getSelected();
    }
}
