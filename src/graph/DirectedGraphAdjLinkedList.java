package graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 */
public class DirectedGraphAdjLinkedList {

    private int V;
    private LinkedList<Integer> adjLists[];

    public DirectedGraphAdjLinkedList(int V) {
        this.V = V;
        this.adjLists = new LinkedList[V];

        for (int i = 0; i<V; i++) {
            this.adjLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        this.adjLists[v].add(w);

        //Undirected Graph - Add vertex v to w
        //this.adjLists[w].add(v);
    }

    public void breadthFirstSearch(int s) {

        boolean[] visited = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int t  = queue.poll();
            System.out.print(t + " ");

            adjLists[t].stream().filter(n -> !visited[n]).forEach(n -> {
                visited[n] = true;
                queue.offer(n);
            });
        }
    }

    public void DFS(int s, boolean[] visited) {
        visited[s] = true;

        System.out.print(s + " ");

        adjLists[s].stream().filter(n -> !visited[n]).forEach(n -> DFS(n, visited));
    }

    public void DFS() {
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }

    public void DFSIterative(int s) {
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        visited[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            s = stack.pop();
            System.out.print(s + " ");

            adjLists[s].stream().filter(n -> !visited[n]).forEach(n -> {
                visited[n] = true;
                stack.push(n);
            });
        }
    }

    private boolean cycleUtil(int v, boolean[] visited, boolean[] recStack) {
        visited[v] = true;
        recStack[v] = true;

        for (Integer i : adjLists[v]) {
            if(!visited[i] && cycleUtil(i, visited, recStack)) {
                return true;
            } else if (recStack[i]) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                if(cycleUtil(i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String ...args) {
        DirectedGraphAdjLinkedList graph = new DirectedGraphAdjLinkedList(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.print("BFS: ");
        graph.breadthFirstSearch(2);

        System.out.println("\n");
        System.out.print("DFS: ");
        graph.DFS();

        System.out.println("\n");
        System.out.print("DFS Iterative: ");
        graph.DFSIterative(2);

        System.out.println("\n\nDirected Graph has cycle ? " + graph.hasCycle());
    }
}
