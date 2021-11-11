package LinkedListStructures;

import Exception.StackException;
import LinkedListStructures.Node;

/**
 * A LinkedListStructures.Stack class that stores elements of type E in form of a stack which uses a Linked List
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
public class Stack<E> {

    private Class<E> type;
    private Node<E> top;
    private int size;

    /**
     * Initializes a LinkedListStructures.Stack of type E.
     * @param type A generic type E.
     */
    public Stack(Class<E> type){
        this.type = type;
    }


    /**
     * Reveals the data of the top element of the stack.
     * @return top element dats.
     * @throws StackException when stack is empty.
     */
    public E peek() throws StackException {
        if (isEmpty()) throw new StackException("You cannot peek at an empty stack.");
        return top.data;
    }


    /**
     * Removes and returns the top element.
     * @return top element.
     * @throws StackException when stack is empty.
     */
    public Node<E> pop() throws StackException {
        if (isEmpty()) throw new StackException("You cannot pop from an empty stack.");
        Node<E> popped = top;
        top = top.next;
        size --;
        return popped;
    }


    /**
     * Adds an element to the top of the stack.
     * @param data data to be turned into a LinkedListStructures.Node<E>.
     */
    public void add(E data){
        Node<E> tempNode = new Node<>(data);
        tempNode.next = top;
        top = tempNode;
        size ++;
    }


    /**
     * Checks if the stack is empty.
     * @return true iff the stack is empty.
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * Returns the size of the stack.
     * @return int.
     */
    public int size(){
        return size;
    }


    /**
     * Displays the stack in a nice format.
     */
    public void display(){
        Node<E> currentNode = top;
        while (currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("null");
    }

}
