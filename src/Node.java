/**
 * An implementation of a Node which contains data, and a pointer to another node. Commonly used in
 * LinkedList, Stack, Queue, etc implementations.
 * @param <E> Generic Type E
 */
public class Node<E extends Comparable<E>> {

    public E data;
    public Node<E> next;

    /**
     * Initializes a node that stores type E data with a pointer to another node.
     * @param data
     */
    public Node(E data){
        this.data = data;
        this.next = null;
    }

    /**
     * A readable format of a Node object.
     * @return prettified String.
     */
    @Override
    public String toString() {
        return data + " -> " + next;
    }
}

