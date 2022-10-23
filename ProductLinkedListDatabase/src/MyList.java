/**

 * Generic version of the LinkedList class.

 *

 * @param <T> the type of the value

 */

public class MyList<T> {



    /**

     * Head node, default is null

     */

    Node<T> head;



    /**

     * Tail node, default is null

     */

    Node<T> tail;

    public MyList(){

}


    /**

     * Constructor with head and tail

     *

     * @param head Head node of this list

     */

    public MyList(Node head) {
            this.head=head;
            this.tail=head;
    }



    /**

     * Checking if this list is empty

     *

     * @return true if list is empty

     */

    public boolean isEmpty() {
        return (head==null);
    }


    /**

     * Returning the length of this list

     *

     * @return The length of this list

     */

    public int length() {
        Node temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }



    /**

     * Insert an item to the head of this list

     *

     * @param item The item to be inserted

     */

    public void insertToHead(T item) {
        Node newNode= new Node(item);
        newNode.next=this.head;
        this.head=newNode;

    }

    /**
     * Add a new node to the tail of the list
     * @param item The item to be inserted
     */
    public void insertAtTail(T item) {
        //Create a new node
        Node newNode = new Node(item);

        //Checks if the list is empty
        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }
    }



    /**

     * Insert an item at position to this list

     *

     * @param position The position of new item

     * @param item     The item to be inserted

     */

    public void insertAfterPosition(int position, T item) {
        if (position < 1)
            System.out.print("Invalid position");

        // if position is 1 then new node is
        // set infornt of head node
        // head node is changing.
        if (position == 1) {
            Node newNode = new Node(item);
            newNode.next = head;
            head = newNode;
        } else {
            while (position-- != 0) {
                if (position == 1) {
                    // adding Node at required position
                    Node newNode = new Node(item);

                    // Making the new Node to point to
                    // the old Node at the same position
                    newNode.next = head.next;

                    // Replacing current with new Node
                    // to the old Node to point to the new Node
                    head.next = newNode;
                    break;
                }
                head = head.next;
            }
            if (position != 1)
                System.out.print("Position out of range");
        }
    }



    /**

     * Deleting the tail of this list

     */

    public void deleteTail() {
        // Find the second last node
        Node second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;

        // Change next of second last
        second_last.next = null;
        tail=second_last;
    }



    /**

     * Searching and deleting an item from this list by comparing the ID of items

     *

     * @param position The position of item to be deleted

     */

    public void deleteElement(int position) {
        // If linked list is empty
        if (head == null)
            return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1;
             i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        if(temp.next.next== null){
            deleteTail();
        }else{
            Node next = temp.next.next;
            temp.next= next;// Unlink the deleted node from list
        }
    }



    /**

     * Swaping two nodes [firstNode] and [secondNode]

     *

     * @param firstNode

     * @param secondNode

     */

    public void swap(Node<T> firstNode, Node<T> secondNode) {
        // Nothing to do if x and y are same
        if (firstNode == secondNode)
            return;

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.info != firstNode) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.info != secondNode) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else // make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }



    /**

     * Deleting all items in the list

     */

    public void clear() {
        head=tail=null;
    }



}