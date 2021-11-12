package Graphs;

import Exception.LinkedListException;
/**
 * A Graph class that stores vertices and their edges.
 */
public class Graph {

    private final Vertex[] vertices;
    private final int numVertices;
    private int numEdges;
    private int currentVertexCount; // used if vertices are added manually


    /**
     * Constructs a new graoh and initializes each vertex in the array of vertexes in the graph.
     *
     * @param numVertices int
     */
    public Graph(int numVertices, boolean addVerticesAutomatically) {
        this.numVertices = numVertices;
        this.numEdges = 0;

        this.vertices = new Vertex[numVertices];

        if (addVerticesAutomatically){
            for (int v = 0; v < this.numVertices; v++) { // MAKE EACH VERTEX CONTAIN A LINKED LIST
                vertices[v] = new Vertex(String.valueOf(v));
            }
        }
        currentVertexCount = 0;

    }


    /**
     * Adds a vertex manually to the vertex list
     * @param id id
     */
    public void addVertex(String id){
        vertices[currentVertexCount] = new Vertex(id);
        currentVertexCount ++;
    }


    /**
     * Getter for vertices
     *
     * @return Vertex
     */
    public Vertex[] getVertices() {
        return vertices;
    }


    /**
     * Getter for NumVertices
     *
     * @return int
     */
    public int getNumVertices() {
        return numVertices;
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
     * Adds an edge between 2 vertices
     *
     * @param vertex1Index vertex 1
     * @param vertex2Index vertex 2
     */
    public void addEdge(int vertex1Index, int vertex2Index) {
        Vertex vertex1 = vertices[vertex1Index];
        Vertex vertex2 = vertices[vertex2Index];
        vertex1.addEdge(vertex2);
        vertex2.addEdge(vertex1);
        numEdges++;
    }


    /**
     * Adds an edge between 2 vertices with a cost.
     *
     * @param vertex1Index vertex 1
     * @param vertex2Index vertex 2
     */
    public void addEdge(int vertex1Index, int vertex2Index, int cost) {
        Vertex vertex1 = vertices[vertex1Index];
        Vertex vertex2 = vertices[vertex2Index];
        vertex1.addEdge(vertex2, cost);
        vertex2.addEdge(vertex1, cost);
        numEdges++;
    }


    /**
     * A readable string of the graphs adjacency list.
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(numVertices).append(" vertices, ").append(numEdges).append(" edges ").append("\n");
        for (int v = 0; v < numVertices; v++) {
            builder.append(vertices[v].getId()).append(" : ");
            builder.append(vertices[v].getAdjacencyList()).append("\n");
        }
        return builder.toString();
    }




}

