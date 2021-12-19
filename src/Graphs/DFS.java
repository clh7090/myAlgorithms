package Graphs;

import LinkedLists.LinkedList;
import Exception.LinkedListException;

/**
 * Depth First Search Algorithm for graphs.
 */
public class DFS {


    /**
     * A helper method to run traverse on vertex v.
     * @param graph graph
     * @param startingVertex vertex
     * @throws LinkedListException e
     */
    public static void DFS(Graph graph,Vertex startingVertex ) throws LinkedListException {
        Vertex[] vertices = graph.getVertices();
        for (Vertex v : vertices){
            v.setVisited(false);
        }
        traverse(startingVertex);
    }


    /**
     * DFS Main Recursive method for traversing a graph
     * @param v vertex
     * @throws LinkedListException e
     */
    private static void traverse(Vertex v) throws LinkedListException {
        v.setVisited(true);
        LinkedList<Edge> neighborList = v.getAdjacencyList();
        while (neighborList.size() != 0){
            Vertex neighbor = neighborList.peek().getDestination();
            if (!(neighbor.isVisited())){ //neighbor not visited
                traverse(neighbor);
            }
            neighborList.pop();
        }
    }


}

