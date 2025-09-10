package bfs;

public class bfs_traversal {

    // Adds a directed edge from src to dest in the adjacency matrix
    public static void addEdgeDUG(int[][] adjMatrix, int src, int dest) {
        adjMatrix[src][dest] = 1;
    }

    // Builds an adjacency matrix from the list of edges
    public static int[][] adjMatrixBuilder(int vertices, int[][] edges){
        int[][] adjMatrix = new int[vertices][vertices]; // initialize VxV matrix with 0s
        for (int i = 0; i < edges.length; i++) {        // loop through edges
            addEdgeDUG(adjMatrix, edges[i][0], edges[i][1]); // mark adjacency for each edge
        }
        return adjMatrix; // return completed adjacency matrix
    }


    // Breadth-First Search (BFS) traversal starting from a given source
    public static void bfs(int[][] graph, int source){
        int[] visited = new int[graph.length]; // keeps track of visited vertices
        queue q = new queue();                // custom queue for BFS
        q.enqueue(source);                    // start with source node
        visited[source] = 1;                  // mark source as visited

        // BFS loop: continue until queue is empty
        while (q.isEmpty() != true) {
            int u = q.dequeue();              // remove the front node
            System.out.println(u);            // process/print the node

            // check all possible neighbors of u
            for (int i = 0; i < graph[u].length; i++) {
                if (graph[u][i] != 0) {       // if edge u -> i exists
                    if (visited[i] != 1) {    // if i has not been visited
                        q.enqueue(i);         // enqueue neighbor for later visit
                        visited[i] = 1;       // mark neighbor as visited
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int totalVertice = 7;  // number of vertices
        // define all edges of the directed graph
        int[][] edges = {{ 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 }, { 1, 5 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 4, 6 }, {6,1}};
        
        // build adjacency matrix from edge list
        int[][] adjMatrix = adjMatrixBuilder(totalVertice, edges);
        
        // perform BFS traversal starting from vertex 0
        bfs(adjMatrix, 0);
    }
}


