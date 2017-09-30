package graph;

import java.util.LinkedList;

/**
 *
 */
public class UnDirectedGraphAdjLinkedList {

    int V;
    LinkedList<Integer> adjLists[];

    public UnDirectedGraphAdjLinkedList(int V) {
        this.V = V;
        this.adjLists = new LinkedList[V];

        for (int i = 0; i<V; i++) {
            this.adjLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        this.adjLists[v].add(w);

        //Undirected Graph - Add vertex v to w
        this.adjLists[w].add(v);
    }

    public boolean cycleUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;

        for (Integer i : adjLists[v]) {
            if(!visited[i]) {
                if(cycleUtil(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[V];

        for (int i=0; i<V; i++) {
            if(!visited[i]) {
                if(cycleUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String ...args) {
        UnDirectedGraphAdjLinkedList graph = new UnDirectedGraphAdjLinkedList(5);

        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println("Undirected Graph has cycle ? " + graph.hasCycle());

    }
}
