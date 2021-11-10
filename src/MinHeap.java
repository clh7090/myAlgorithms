/**
 * A Min Heap class that stores elements of type E in form of a min heap.
 *
 * Common time Complexities:
 *
 * peek():                              O(1) time
 * pop():                               O(log(n)) time
 * insert():                            O(log(n)) time
 * heapifyup():                         O(log(n)) time
 *
 * building a heap with n elements:     O(n * log(n)) time
 *
 * @param <E> Generic Type E
 */
public class MinHeap<E extends Comparable<E>> {

    private E[] heap;
    private int size;
    private final int capacity;
    private final Class<E> type;


    /**
     * Initializes a heap of size 'capacity'.
     * @param type Given class type, used for generics.
     * @param capacity Max Capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public MinHeap(Class<E> type, int capacity){
        this.type = type;
        this.capacity = capacity;
        this.size = 0;
        heap = (E[]) java.lang.reflect.Array.newInstance(type, this.capacity); //for generics only
    }


    /**
     * Returns the element of type E at the root of the Heap.
     * @return E.
     */
    public E peek(){return null;}


    /**
     * Removes the element of type E at the root of the Heap, and then fixes the Min heap to satisfy these properties:
     *
     * 1. The value of all parent nodes are always less than or equal to that of its children.
     *
     * 2. The min heap is a complete binary tree, which filled at all levels, except potentially the last level.
     *
     * @param node a given node.
     */
    public void pop(E node){}


    /**
     * Inserts an element of type E at the end of the tree.
     * @param node a given node.
     */
    public void insert(E node){}


    /**
     * Prints the contents of the heap in a readable format.
     */
    public void print() {}


    /**
     * Swaps two nodes in the heap.
     * @param node1 a given node.
     * @param node2 a given node.
     */
    private void swap(E node1, E node2){}


    /**
     * Returns the right child of a given root.
     * @param root a node and parent of this root.
     * @return a node.
     */
    private E getRightChild(E root){return null;}


    /**
     * Returns the left child of a given root.
     * @param root a node and parent of this root.
     * @return a node.
     */
    private E getLeftChild(E root){return null;}


    /**
     * Checks if a node is a leaf.
     * @param node a given node.
     * @return true iff the node is a leaf.
     */
    private boolean isLeaf(E node){return false;}


    /**
     * Fixes the heap after the minimum element has been removed.
     * @param node A node at a given position.
     */
    private void heapifyUp(E node){}

}
