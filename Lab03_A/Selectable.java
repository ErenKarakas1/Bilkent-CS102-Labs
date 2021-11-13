/*
 * Interface to make Shapes selectable
 * @author Eren Karakas 22002722
 * @version 1.0
 * 02/07/2021
 */


public interface Selectable {

    boolean getSelected();
    void setSelected( boolean bool );
    Shape contains( int x, int y );
}
