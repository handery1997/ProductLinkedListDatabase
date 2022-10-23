/**

 * Generic version of the Stack class.

 *

 * @param <T> the type of the value

 */

class MyStack<T> {



    /**

     * Head node contains front node in the stack

     */

    Node<T> head;
    //Push element to stack function
    public void push(T x) {
        Node newNode= new Node(x);
        if(this.head==null){
            this.head=newNode;
            return;
        }
        newNode.next=this.head;
        this.head=newNode;
    }
    //Clear Stack function
    public void clear(){
        this.head=null;
    }
}
