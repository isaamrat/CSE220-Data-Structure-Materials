import java.util.*;

// Edge class represents a node in the adjacency list
class Edge {
    int vertice;   // stores the adjacent vertex
    Edge next;     // pointer to the next edge (linked list)

    public Edge(int ver) {
        this.vertice = ver;   // set the vertex value
        this.next = null;     // initialize the next pointer as null
    }
}

public class graph_undirectedUnweighted {

    // Adds an undirected edge between vertices v1 and v2
    static void addEdge(Edge[] graph, int v1, int v2) {
        // Create a new node for v2 and add it to the adjacency list of v1
        Edge newNode = new Edge(v2);
        newNode.next = graph[v1];  // insert at the beginning
        graph[v1] = newNode;       // update head pointer

        // Since the graph is undirected, add v1 to v2's adjacency list as well
        newNode = new Edge(v1);
        newNode.next = graph[v2];
        graph[v2] = newNode;
    }

    // Displays the adjacency list representation of the graph
    static void showGraph(Edge[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " : ");  // print current vertex
            Edge temp = graph[i];         // start of adjacency list for vertex i
            while (temp != null) {
                System.out.print("(" + temp.vertice + ") -> ");  // print adjacent vertex
                temp = temp.next;  // move to the next edge
            }
            System.out.println("null");  // end of adjacency list
        }
    }

    // Performs Breadth-First Search from the starting vertex
    static void bfs(Edge[] graph, int start) {
        boolean[] visited = new boolean[graph.length];  // track visited vertices
        Queue<Integer> queue = new LinkedList<>();      // queue for BFS traversal

        visited[start] = true;  // mark start as visited
        queue.add(start);       // enqueue start vertex

        while (!queue.isEmpty()) {
            int node = queue.remove();  // dequeue a vertex
            System.out.print(node + " ");  // process the vertex

            // Traverse all adjacent vertices of the dequeued vertex
            Edge temp = graph[node];
            while (temp != null) {
                if (!visited[temp.vertice]) {           // if vertex not visited
                    visited[temp.vertice] = true;       // mark as visited
                    queue.add(temp.vertice);            // enqueue it
                }
                temp = temp.next;  // move to next adjacent node
            }
        }
        System.out.println();  // end line after traversal
    }

    // Performs Depth-First Search from the starting vertex
    static void dfs(Edge[] graph, int start, boolean[] visited) {
        visited[start] = true;            // mark current vertex as visited
        System.out.print(start + " ");    // process the vertex

        Edge temp = graph[start];         // traverse adjacency list
        while (temp != null) {
            if (!visited[temp.vertice]) {         // if adjacent vertex not visited
                dfs(graph, temp.vertice, visited);  // recursively visit it
            }
            temp = temp.next;  // move to next adjacent node
        }
    }

    public static void main(String[] args) {
        Edge[] g1 = new Edge[8];  // create a graph with 8 vertices (0 to 7)

        // Add undirected edges
        addEdge(g1, 0, 1);
        addEdge(g1, 0, 2);
        addEdge(g1, 0, 7);
        addEdge(g1, 1, 4);
        addEdge(g1, 2, 4);
        addEdge(g1, 2, 3);
        addEdge(g1, 3, 5);
        addEdge(g1, 3, 6);
        addEdge(g1, 6, 7);

        // Display the graph structure
        showGraph(g1);

        // Perform and display BFS starting from vertex 0
        System.out.print("BFS: ");
        bfs(g1, 0);

        // Perform and display DFS starting from vertex 0
        System.out.print("DFS: ");
        boolean[] visited = new boolean[g1.length];  // visited array for DFS
        dfs(g1, 0, visited);
    }
}
