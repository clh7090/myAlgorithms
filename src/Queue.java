import Exception.QueueException;

/**
 * A Queue class that stores elements of type E in form of a Queue which uses a Linked List
 * <p>
 * Common time Complexities:
 * <p>
 * peek():                              O(1) time
 * pop():                               O(1) time
 * add():                               O(1) time
 * isEmpty():                           O(1) time
 * size():                              O(1) time
 * <p>
 *
 * @param <E> Generic Type E.
 */
public class Queue<E extends Comparable<E>> {

    private Class<E> type;
    private Node<E> front;
    private Node<E> end;
    private int size;

    /**
     * Initializes a Queue of type E.
     * @param type A generic type E.
     */
    public Queue(Class<E> type){
        this.type = type;
    }


    /**
     * Reveals the data of the front element of the queue.
     * @return front element of the queue.
     * @throws QueueException  when queue is empty.
     */
    public E peek() throws QueueException {
        if (isEmpty()) throw new QueueException("You cannot peek at an empty Queue.");
        return front.data;
    }


    /**
     * Removes and returns the front element.
     * @return front element.
     * @throws QueueException when queue is empty.
     */
    public Node<E> pop() throws QueueException {
        if (isEmpty()) throw new QueueException("You cannot pop from an empty queue.");
        Node<E> popped = front;
        front = front.next;
        size --;
        return popped;
    }


    /**
     * Adds an element to the end of the queue.
     * @param data data to be turned into a Node<E>.
     */
    public void add(E data){
        if (size == 0){
            front = new Node<E>(data);
            end = front;
        }else {
            end.next = new Node<E>(data);
            end = end.next;
        }
        size ++;
    }


    /**
     * Checks if the queue is empty.
     * @return true iff the queue is empty.
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * Returns the size of the queue.
     * @return int.
     */
    public int size(){
        return size;
    }


    /**
     * Displays the queue in a nice format.
     */
    public void display(){
        Node<E> currentNode = front;
        while (currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("null");
    }

}
