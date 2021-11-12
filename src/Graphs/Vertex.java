package Graphs;

import LinkedLists.LinkedList;

/**
 * The Vertex class that stores a vertex for a certain Graph.
 */
public class Vertex {

    private final String id;
    private final LinkedList<Edge> adjacencyList;
    private int numEdges;

    /**
     * A representation of a Vertex in a graph.
     *
     * @param id id.
     */
    public Vertex(String id) {
        this.id = id;
        this.numEdges = 0;

        adjacencyList = new LinkedList<>(Edge.class);
    }


    /**
     * Adds an edge to this certain vertex.
     *
     * @param destination the vertex 'this' is connected to
     */
    public void addEdge(Vertex destination) {
        adjacencyList.add(new Edge(this, destination));
        numEdges++;
    }


    /**
     * Adds an edge to this certain vertex with a cost.
     *
     * @param destination the vertex 'this' is connected to
     */
    public void addEdge(Vertex destination, int cost) {
        adjacencyList.add(new Edge(this, destination, cost));
        numEdges++;
    }


    /**
     * Getter for num edges
     *
     * @return int
     */
    public int getNumEdges() {
        return numEdges;
    }


    /**
     * Getter for id
     *
     * @return String
     */
    public String getId() {
        return id;
    }


    /**
     * getter for adjacency list
     *
     * @return Linked List of edges between this vertex and another vertex
     */
    public LinkedList<Edge> getAdjacencyList() {
        return adjacencyList;
    }


    /**
     * readable String representation of a Vertex
     *
     * @return String
     */
    @Override
    public String toString() {
        return id;
    }


}

