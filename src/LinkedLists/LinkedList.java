package LinkedLists;

import Exception.LinkedListException;

/**
 * A LinkedListStructures.LinkedList class that stores elements of type E in form of a LinkedListStructures.LinkedList.
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
public class LinkedList<E> {

    private Class<E> type;
    private Node<E> front;
    private int size;

    /**
     * Initializes a LinkedListStructures.LinkedList of type E.
     *
     * @param type A generic type E.
     */
    public LinkedList(Class<E> type) {
        this.type = type;
    }


    /**
     * Reveals the data of the top element of the LinkedListStructures.LinkedList.
     *
     * @return top element dats.
     * @throws LinkedListException when LinkedListStructures.LinkedList is empty.
     */
    public E peek() throws LinkedListException {
        if (isEmpty()) throw new LinkedListException("You cannot peek at an empty LinkedListStructures.LinkedList.");
        return front.data;
    }


    /**
     * Removes and returns the top element.
     *
     * @return top element.
     * @throws LinkedListException when LinkedListStructures.LinkedList is empty.
     */
    public Node<E> pop() throws LinkedListException {
        if (isEmpty()) throw new LinkedListException("You cannot pop from an empty LinkedListStructures.LinkedList.");
        Node<E> popped = front;
        front = front.next;
        size--;
        return popped;
    }


    /**
     * Adds an element to the top of the LinkedListStructures.LinkedList.
     *
     * @param data data to be turned into a LinkedListStructures.Node<E>.
     */
    public void add(E data) {
        Node<E> tempNode = new Node<>(data);
        tempNode.next = front;
        front = tempNode;
        size++;
    }


    /**
     * Checks if the LinkedListStructures.LinkedList is empty.
     *
     * @return true iff the LinkedListStructures.LinkedList is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the size of the LinkedListStructures.LinkedList.
     *
     * @return int.
     */
    public int size() {
        return size;
    }


    /**
     * Stores the LinkedList in a nice format.
     *
     * @return String
     */
    @Override
    public String toString() {
        Node<E> currentNode = front;
        StringBuilder builder = new StringBuilder();
        while (currentNode != null) {
            builder.append(currentNode.data).append(" -> ");
            currentNode = currentNode.next;
        }
        builder.append("null");
        return builder.toString();
    }
}
