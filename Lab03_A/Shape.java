/*
 * Abstract Shape class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


public abstract class Shape implements Locatable, Selectable {
    int x;
    int y;
    boolean selected;

    /**
     * @return Area of shape
     */
    abstract double getArea();

    /**
     * @return Perimeter of shape
     */
    abstract double getPerimeter();

    /**
     * @return X coordinate of shape
     */
    public int getX() {
        return x;
    }

    /**
     * @return Y coordinate of shape
     */
    public int getY() {
        return y;
    }

    /**
     * Location for shape to be
     * @param x X coordinate
     * @param y Y coordinate
     */
    public void setLocation( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return True if shape is selected, false otherwise
     */
    public boolean getSelected() {
        return selected;
    }


    /**
     * @param selected True if user selected shape, false if user unselected shape
     */
    public void setSelected( boolean selected ) {
        this.selected = selected;
    }

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return Shape if location contains one, null otherwise
     */
    public Shape contains( int x, int y ) {
        if ( this.x == x && this.y == y ) {
            return this;
        }

        return null;
    }
}
