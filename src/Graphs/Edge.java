package Graphs;

/**
 * The Edge class that stores an edge for a certain Graph.
 */
public class Edge {

    private final int cost;
    private final Vertex source;
    private final Vertex destination;

    /**
     * Unweighted representation of an edge.
     *
     * @param source      Vertex the edge comes from.
     * @param destination Vertex the edge goes to.
     */
    public Edge(Vertex source, Vertex destination) { //unweighted edges
        this.source = source;
        this.destination = destination;
        this.cost = 0; //default 0
    }


    /**
     * Weighted representation of an edge.
     *
     * @param source      Vertex the edge comes from.
     * @param destination Vertex the edge goes to.
     * @param cost        Cost of the edge.
     */
    public Edge(Vertex source, Vertex destination, int cost) { // weighted edges
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }


    /**
     * Getter for cost.
     *
     * @return cost.
     */
    public int getCost() {
        return cost;
    }


    /**
     * Getter for source.
     *
     * @return source.
     */
    public Vertex getSource() {
        return source;
    }


    /**
     * getter for Destination.
     *
     * @return destination.
     */
    public Vertex getDestination() {
        return destination;
    }


    /**
     * Readable String format of an edge for an adjacency list.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "V: " + destination.getId() + " $ " + cost;
    }


}

