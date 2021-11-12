package Graphs;

/**
 * A Graph class that stores vertices and their edges.
 */
public class Graph {

    private final Vertex[] vertices;
    private final int numVertices;
    private int numEdges;


    /**
     * Constructs a new graoh and initializes each vertex in the array of vertexes in the graph.
     *
     * @param numVertices int
     */
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.numEdges = 0;

        this.vertices = new Vertex[numVertices];

        for (int v = 0; v < this.numVertices; v++) { // MAKE EACH VERTEX CONTAIN A LINKED LIST
            vertices[v] = new Vertex(String.valueOf(v));
        }
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
        vertices[vertex1Index].addEdge(vertex2Index);
        vertices[vertex2Index].addEdge(vertex1Index);
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
            builder.append(v).append(" : ");
            builder.append(vertices[v].getAdjacencyList()).append("\n");
        }
        return builder.toString();
    }


}

