import java.util.*;
import java.util.Queue;

public class BreadthFirstSearch {
    // Graph adjacency list
    private List<List<Integer>> adjList;

    //BFS class constructor to the adjacency list
    public BreadthFirstSearch(int numVertices){
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++){
            adjList.add(new ArrayList<>());
        }
    }

    //Add edge to the graph
    public void addEdge(int from, int to){
        adjList.get(from).add(to);
        adjList.get(to).add(from); // This makes the graph undirected
    }

    //Iterative BFS for a given starting point
    public void bfsIterative(int start){
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.println("Iterative: ");
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            //Traverse all adjacent vertices
            for (int adj : adjList.get(vertex)){
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    //Recursive BFS for a given starting point
    public void bfsRecursive(int start){
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        System.out.println("Recursive: ");
        bfsRecursiveUtil(queue, visited);
    }

    //Auxiliar method to perform BFS recursively
    private void bfsRecursiveUtil(Queue<Integer> queue, boolean[] visited){
        //Base case: stop if the queue is empty
        if (queue.isEmpty()) {
            return;
        }
        int vertex = queue.poll();

        //Not visited yet case
        if (!visited[vertex]) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            //Enqueue all unvisited adjacent vertices
            for (int adj : adjList.get(vertex)){
                if (!visited[adj]) {
                    queue.add(adj);
                }
            }
        }
        //Recursive call
        bfsRecursiveUtil(queue, visited);
    }

    //Main method to demonstrate BFS
    public static void main(String[] args) {
        BreadthFirstSearch graph = new BreadthFirstSearch(6);

        //Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        //Perform both BFS approaches
        graph.bfsIterative(0);
        System.out.println("");
        graph.bfsRecursive(0);
    }

}
