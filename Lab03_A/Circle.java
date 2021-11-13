/*
 * Circle class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


public class Circle extends Shape {

    private final int radius;

    /**
     * Constructs a circle class
     *
     * @param radius Radius length
     */
    public Circle(int radius) {
        this.radius = radius;
    }

    /**
     * Calculate area of circle with pi * r^2
     *
     * @return Area
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculate the perimeter of circle with pi * 2r
     *
     * @return Perimeter
     */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return Shape if it contains the point
     */
    public Shape contains( int x, int y ) {
        if ( Math.pow( x - this.x, 2 ) + Math.pow( y - this.y, 2 ) < Math.pow( radius, 2 ) ) {
            return this;
        }

        return null;
    }

    /**
     * @return String representation of a circle
     */
    public String toString() {
        return "A circle with radius " + radius + ". Selected: " + this.getSelected();
    }
}
