package Graphs;

import LinkedLists.LinkedList;
import Exception.*;
import LinkedLists.Queue;

/**
 * Breadth First Search for Graph algorithms
 */
public class BFS {

    /**
     * BFS on a graph
     * @param graph graph
     * @param startingVertex vertex
     * @throws LinkedListException e
     * @throws QueueException e
     */
    public static void traverse(Graph graph, Vertex startingVertex) throws LinkedListException, QueueException {
        Vertex[] vertices = graph.getVertices();
        for (Vertex v : vertices) {
            v.setVisited(false);
            v.setDistance(Integer.MAX_VALUE);
        }

        Queue<Vertex> queue = new Queue<>(Vertex.class);
        queue.add(startingVertex);
        startingVertex.setVisited(true);
        startingVertex.setDistance(0);

        while (!(queue.isEmpty())) {
            Vertex v = queue.pop().data;
            LinkedList<Edge> neighborList = v.getAdjacencyList();
            while (neighborList.size() != 0) {
                Vertex neighbor = neighborList.peek().getDestination();
                if (!(neighbor.isVisited())) { //neighbor not visited
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                    neighbor.setDistance(v.getDistance() + 1);
                }
                neighborList.pop();
            }
        }
    }


}


