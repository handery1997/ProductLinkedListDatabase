public class Node<T> {



    /**

     * The info of this node

     */

    T info;



    /**

     * The next node

     */

    Node next;


    /**

     * Constructor with info and next node

     *

     * @param info The info of this node


     */

    public Node(T info) {
        this.info=info;
    }

}