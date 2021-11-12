package Graphs;

import LinkedLists.LinkedList;
import Exception.LinkedListException;

public class DFS {


    public static void DFSRun(Graph graph,Vertex startingVertex ) throws LinkedListException {
        Vertex[] vertices = graph.getVertices();
        for (Vertex v : vertices){
            v.setVisited(false);
        }
        DFS(startingVertex);
    }

    private static void DFS(Vertex v) throws LinkedListException {
        v.setVisited(true);
        LinkedList<Edge> neighborList = v.getAdjacencyList();
        while (neighborList != null){
            Vertex neighbor = neighborList.peek().getDestination();
            if (!(neighbor.isVisited())){ //neighbor not visited
                DFS(neighbor);
            }
            neighborList.pop();
        }
    }
}
