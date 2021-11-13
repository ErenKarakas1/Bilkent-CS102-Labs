/*
 * SimpleStackWithQueue class
 * @author Eren Karakas 22002722
 * @version 1.0
 * 30/07/2021
 */


public class SimpleStackWithQueue {

    private SimpleQueue q1;
    private SimpleQueue q2;
    private int size;

    /**
     * Constructs a SimpleStackWithQueue instance
     **/
    public SimpleStackWithQueue() {
        q1 = new SimpleQueue();
        q2 = new SimpleQueue();
        size = 0;
    }

    /**
     * Adds new Node to stack
     *
     * @param data Data in Node
     */
    public void push( String data ) {
        q2.enqueue( data );

        for ( int i = 0; i < size; i++ ) {
            String nodeData = q1.dequeue();
            q2.enqueue( nodeData );
        }

        size++;
        SimpleQueue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /**
     * Remove Node from stack
     *
     * @return Data in Node
     */
    public String pop() {
        String data = q1.dequeue();

        if ( data != null ) {
            size--;
        }

        return data;
    }

    /**
     * @return String representation of stack
     */
    public String toString() {
        return q1.toString();
    }
}
