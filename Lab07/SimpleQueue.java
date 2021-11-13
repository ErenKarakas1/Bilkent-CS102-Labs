/*
 * SimpleQueue class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 30/07/2021
 */


public class SimpleQueue {

    private SimpleLinkedList linkedList;

    /**
     * Constructs a SimpleQueue instance
     **/
    public SimpleQueue() {
        linkedList = new SimpleLinkedList();
    }

    /**
     * Add new Node to queue
     *
     * @param data Data in Node
     */
    public void enqueue( String data ) {
        linkedList.addToTail( data );
    }

    /**
     * Remove node from queue
     *
     * @return Node from queue
     */
    public String dequeue() {
        return linkedList.removeFromHead();
    }

    /**
     * @return True if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * @return String representation of a queue
     */
    public String toString() {
        return linkedList.toString();
    }
}
