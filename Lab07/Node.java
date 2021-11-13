/*
 * Node class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 30/07/2021
 */


public class Node {

    private String data;
    private Node next;

    /**
     * Constructs a Node instance
     *
     * @param data Data in Node
     * @param next Next Node
     */
    public Node( String data, Node next ) {
        this.data = data;
        this.next = next;
    }

    /**
     * @return Data in Node
     */
    public String getData() {
        return data;
    }

    /**
     * @return Get next Node
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param data Data in Node
     */
    public void setData( String data ) {
        this.data = data;
    }

    /**
     * @param next Next Node
     */
    public void setNext( Node next ) {
        this.next = next;
    }

    /**
     * @return String representation for Node
     */
    public String toString() {
        return "Data: " + data;
    }
}
