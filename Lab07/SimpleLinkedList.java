/*
 * SimpleLinkedList class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 30/07/2021
 */


public class SimpleLinkedList {

    private int size;
    private Node head;
    private Node tail;

    /**
     * Constructs a SimpleLinkedList instance
    **/
    public SimpleLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Adds new Node to end
     *
     * @param data Data in Node
     */
    public void addToTail( String data ) {
        if ( isEmpty() ) {
            tail = new Node( data, null );
            head = tail;
        }
        else {
            Node added = new Node( data, null );
            tail.setNext( added );
            tail = tail.getNext();
        }
        size++;
    }

    /**
     * Removes a Node from start
     *
     * @return Data in Node
     */
    public String removeFromHead() {
        Node removed;

        if ( isEmpty() ) {
            return null;
        }
        else {
            removed = head;
            head = head.getNext();
            size--;
        }

        return removed.getData();
    }

    /**
     * @return True if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the Node at index
     *
     * @param index Index of Node
     * @return Node at index
     */
    public Node get( int index ) {
        Node nodeAtIndex = head;

        for ( int i = 0; i < index; i++ ) {
            nodeAtIndex = nodeAtIndex.getNext();
        }

        return nodeAtIndex;
    }

    /**
     * @return String representation of a LinkedList
     */
    public String toString() {
        StringBuilder list = new StringBuilder();
        Node node = head;
        list.append( head.getData() ).append( "-" );

        for ( int i = 0; i < size - 1; i++ ) {
            node = node.getNext();
            list.append( node.getData() );

            if ( i != size - 2 ) {
                list.append( "-" );
            }
        }

        return list.toString();
    }
}
