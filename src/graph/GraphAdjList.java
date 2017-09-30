package graph;

/**
 * Graph Implementation using Adjacency List
 */
public class GraphAdjList {

    public static class AdjList {
        GraphAdjListNode head;
    }

    int V;
    AdjList[] adjLists;

    public GraphAdjList(int V) {
        this.V = V;
        this.adjLists = new AdjList[V];

        for (int i = 0; i<V; i++) {
            this.adjLists[i] = new GraphAdjList.AdjList();
            this.adjLists[i].head = null;
        }
    }

    public GraphAdjListNode newAdjNode(int dest) {
        GraphAdjListNode newNode = new GraphAdjListNode();
        newNode.dest = dest;
        newNode.next = null;
        return newNode;
    }

    public void addEdge(GraphAdjList graph, int src, int dest) {
        GraphAdjListNode newNode = newAdjNode(dest);
        newNode.next = graph.adjLists[src].head;
        graph.adjLists[src].head = newNode;

        newNode = newAdjNode(src);
        newNode.next = graph.adjLists[dest].head;
        graph.adjLists[dest].head = newNode;
    }

    public void printGraph(GraphAdjList graph) {
        for (int i = 0; i<graph.V; i++) {
            GraphAdjListNode node = graph.adjLists[i].head;
            System.out.print("Adjacency list of vertex " + i + "\n head");
            while (node != null) {
                System.out.print(" -> " + node.dest);
                node = node.next;
            }
            System.out.println();
        }
    }

    public static void main(String ...args) {
        int V = 5;
        GraphAdjList graph = new GraphAdjList(V);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 4);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 1, 3);
        graph.addEdge(graph, 1, 4);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 4);

        graph.printGraph(graph);
    }

}
