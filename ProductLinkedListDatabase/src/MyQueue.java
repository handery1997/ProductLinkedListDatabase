/**

 * Generic version of the Queue class.

 *

 * @param <T> the type of the value

 */

class MyQueue<T> {


    /**

     * Head node contains front node in the queue

     */

    Node<T> head;



    /**

     * Tail node contains last node in the queue

     */

    Node<T> tail;

    // Method to add an element to the queue.
    public void enqueue(T item)
    {

        // Create a new LL node
        Node<T> temp = new Node(item);

        // If queue is empty, then new node is front and rear both
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.tail.next = temp;
        this.tail = temp;
    }

    // Method to remove an element from queue.
    public void dequeue()
    {
        // If queue is empty, return NULL.
        if (this.head == null)
            return;

        // Store previous front and move front one node ahead
        Node<T> temp = this.head;
        this.head = this.head.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.head == null)
            this.tail = null;
    }
    //Method to clear queue
    public void clear(){
        this.head=this.tail=null;
    }
}



