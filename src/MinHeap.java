import Exception.MinHeapException;

/**
 * A Min Heap class that stores elements of type E in form of a min heap.
 * <p>
 * Common time Complexities:
 * <p>
 * peek():                              O(1) time
 * pop():                               O(log(n)) time
 * insert():                            O(log(n)) time
 * heapifyup():                         O(log(n)) time
 * <p>
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
     *
     * @param type     Given class type, used for generics.
     * @param capacity Max Capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public MinHeap(Class<E> type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.size = 0;
        heap = (E[]) java.lang.reflect.Array.newInstance(type, this.capacity); //for generics only
    }


    /**
     * Returns true iff the heap is empty, false otherwise.
     *
     * @return bool.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the element of type E at the root of the Heap.
     *
     * @return E.
     * @throws MinHeapException when the heap is empty
     */
    public E peek() throws MinHeapException {
        if (size == 0) throw new MinHeapException("Using peek on an empty heap is not allowed.");
        return heap[0];
    }


    /**
     * Removes the element of type E at the root of the Heap, and then fixes the Min heap to satisfy these properties:
     * <p>
     * 1. The value of all parent nodes are always less than or equal to that of its children.
     * <p>
     * 2. The min heap is a complete binary tree, which filled at all levels, except potentially the last level.
     *
     * @return the minimum element popped from the heap.
     * @throws MinHeapException when the heap is empty
     */
    public E pop() throws MinHeapException {
        if (size == 0) throw new MinHeapException("Using pop on an empty heap is not allowed.");
        E popped = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown(0);
        return popped;
    }


    /**
     * Inserts an element of type E at the end of the tree.
     *
     * @param node a given node.
     * @throws MinHeapException when the heap is full
     */
    public void insert(E node) throws MinHeapException {
        if (size >= capacity) throw new MinHeapException("Inserting into heap at full capacity is not allowed.");

        heap[size] = node;
        size++;
        heapifyUp(size - 1);
    }


    /**
     * Prints the contents of the heap in a readable format.
     */
    public void print() {
        boolean minIsNull = heap[0] == null;
        String min = minIsNull ? "<empty>" : String.valueOf(heap[0]);
        System.out.println("\nMIN = " + min + "\n");
        for (int i = 0; i < size / 2; i++) {
            boolean leftIsNull = heap[getLeftChildPosition(i)] == null;
            boolean rightIsNull = heap[getRightChildPosition(i)] == null;
            String left = leftIsNull ? "<empty>" : String.valueOf(heap[getLeftChildPosition(i)]);
            String right = rightIsNull ? "<empty>" : String.valueOf(heap[getRightChildPosition(i)]);
            StringBuilder builder = new StringBuilder();
            builder.append("PARENT : ");
            builder.append(heap[i]);
            builder.append(" LEFT CHILD : ");
            builder.append(left);
            builder.append(" RIGHT CHILD : ");
            builder.append(right);
            System.out.println(builder);
        }
        System.out.println();
    }


    /**
     * Swaps two nodes in the heap.
     *
     * @param node1Position a given nodes index in the heap array.
     * @param node2Position a given nodes index in the heap array.
     */
    private void swap(int node1Position, int node2Position) {
        E temp = heap[node1Position];
        heap[node1Position] = heap[node2Position];
        heap[node2Position] = temp;
    }


    /**
     * Returns the parent node of a particular child.
     *
     * @param childPosition a given children node index in the heap array.
     * @return a nodes position, or INTEGER.MAX_VALUE if the value does not exist.
     */
    private int getParentPosition(int childPosition) {
        return (childPosition - 1) / 2;
    }


    /**
     * Returns the right child of a given root.
     *
     * @param rootPosition the position of a root node in the heap array.
     * @return a nodes position
     */
    private int getRightChildPosition(int rootPosition) {
        return 2 * rootPosition + 2;
    }


    /**
     * Returns the left child of a given root.
     *
     * @param rootPosition the position of a root node in the heap array.
     * @return a nodes position
     */
    private int getLeftChildPosition(int rootPosition) {
        return 2 * rootPosition + 1;
    }


    /**
     * Checks if a node is a leaf.
     *
     * @param nodePosition a given nodes index in the heap array.
     * @return true iff the node is a leaf.
     */
    private boolean isLeaf(int nodePosition) {
        return nodePosition > (size / 2) && nodePosition <= size;
    }


    /**
     * Fixes the heap after the minimum element has been removed.
     *
     * @param nodePosition a given nodes index in the heap array.
     */
    private void heapifyDown(int nodePosition) {

        // If the node is a non-leaf node and greater
        // than any of its children

        if (!isLeaf(nodePosition)) { // base case, node is a leaf -> stop recursion

            if (heap[getLeftChildPosition(nodePosition)] == null || heap[getRightChildPosition(nodePosition)] == null) {/*Do nothing*/}
            else if (heap[nodePosition].compareTo(heap[getLeftChildPosition(nodePosition)]) > 0 // parent > left child
                    || heap[nodePosition].compareTo(heap[getRightChildPosition(nodePosition)]) > 0) { // parent > right child

                // Swap with the left child and heapify
                if (heap[getLeftChildPosition(nodePosition)].compareTo(heap[getRightChildPosition(nodePosition)]) < 0) { // left child < parent
                    swap(nodePosition, getLeftChildPosition(nodePosition));
                    heapifyDown(getLeftChildPosition(nodePosition));
                }

                // Swap with the right child and heapify
                else {
                    swap(nodePosition, getRightChildPosition(nodePosition)); // right child < parent
                    heapifyDown(getRightChildPosition(nodePosition));
                }
            }
        }
    }


    /**
     * Fixes the heap after tan element has been inserted.
     *
     * @param nodePosition a given nodes index in the heap array.
     */
    private void heapifyUp(int nodePosition) {
        int currentPosition = nodePosition;
        while (currentPosition > 0 && heap[currentPosition].compareTo(heap[getParentPosition(currentPosition)]) < 0) { // current node < parent node
            swap(currentPosition, getParentPosition(currentPosition));
            currentPosition = getParentPosition(currentPosition);
        }
    }


}

