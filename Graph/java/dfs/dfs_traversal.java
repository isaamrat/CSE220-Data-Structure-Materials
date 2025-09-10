package dfs;

public class dfs_traversal {
    
    // Builds an adjacency list for a directed graph from an edge list
    public static DU_Edge[] adjListBuilder(int vertex, int[][] edges){
        DU_Edge[] adjList = new DU_Edge[vertex];           // array of linked-list heads, one per vertex
        for (int i = 0; i < edges.length; i++) {           // iterate over all edges
            DUG_AdjList.addEdgeDUG(adjList, edges[i][0], edges[i][1]); // add directed edge src -> dest
        }
        return adjList;                                    // return constructed adjacency list
    }

    // Depth-First Search (DFS) traversal starting from a given source (iterative using a stack)
    public static void dfs(DU_Edge[] graph, int source){
        int[] visited = new int[graph.length];             // visitation marker: 0 = unvisited, 1 = visited
        Stack s1 = new Stack();                            // custom stack of Integer vertex indices
        s1.push(source);                                   // start by pushing the source vertex
        visited[source] = 1;                               // mark source as visited (we're using "mark on push")

        // DFS loop: continue while there are vertices to explore
        while (s1.isEmpty() != true) {                     // can also be written as: while (!s1.isEmpty())
            Integer u = s1.pop();                          // pop the current vertex to process
            System.out.println(u);                         // "visit" action (preorder-like): print the vertex

            DU_Edge v = graph[u];                          // head of adjacency list for u
            while (v != null) {                            // iterate through all neighbors of u
                if (visited[v.vertex] != 1) {              // if neighbor has not been visited yet
                    s1.push(v.vertex);                     // push neighbor onto the stack to explore later
                    visited[v.vertex] = 1;                 // mark neighbor as visited (prevents re-pushing/cycles)
                }
                v = v.next;                                // move to next neighbor in the adjacency list
            }
        }
    }

    public static void main(String[] args) {
        int totalVertice = 7;  // number of vertices (0..6)
        // define all edges of the directed graph
        int[][] edges = {
            {0, 1}, {0, 3}, {1, 2}, {1, 3}, {1, 5},
            {2, 4}, {2, 5}, {3, 4}, {4, 6}, {6, 1}
        };

        DU_Edge[] adjList = adjListBuilder(totalVertice, edges); // build adjacency list from edges
        dfs(adjList, 0);                                         // run DFS starting at vertex 0
    }
}
