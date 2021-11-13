public class Test {

    public static void main( String[] args ) {
        // SimpleLinkedList
        System.out.println( "List begins:" );
        SimpleLinkedList list = new SimpleLinkedList();
        list.addToTail( "A" );
        list.addToTail( "B" );
        list.addToTail( "C" );
        list.addToTail( "D" );
        System.out.println( list + "\n" );

        System.out.println( list.removeFromHead() );
        System.out.println( list + "\n" );

        System.out.println( list.get( 1 ) + "\n" );

        // SimpleQueue
        System.out.println( "Queue begins:" );
        SimpleQueue queue = new SimpleQueue();
        queue.enqueue( "A" );
        queue.enqueue( "B" );
        queue.enqueue( "C" );
        queue.enqueue( "D" );
        System.out.println( queue + "\n" );

        System.out.println( queue.dequeue() );
        System.out.println( queue + "\n" );

        // SimpleStackWithQueue
        System.out.println( "Stack begins:" );
        SimpleStackWithQueue stack = new SimpleStackWithQueue();
        stack.push( "A" );
        stack.push( "B" );
        stack.push( "C" );
        stack.push( "D" );
        System.out.println( stack + "\n" );

        System.out.println( stack.pop() );
        System.out.println( stack + "\n" );
    }
}
