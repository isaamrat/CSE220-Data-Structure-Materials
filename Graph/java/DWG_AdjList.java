class DW_Edge {
    int vertex;
    int weight;
    DW_Edge next;

    DW_Edge(int dest, int w) {
        vertex = dest;
        weight = w;
        next = null;
    }
}

public class DWG_AdjList {

    // Add directed weighted edge src -> dest (weight w)
    public static void addEdgeDWG(DW_Edge[] adjList, int src, int dest, int weight) {
        DW_Edge head = adjList[src];
        DW_Edge newEdge = new DW_Edge(dest, weight);
        newEdge.next = head;
        adjList[src] = newEdge;
    }

    public static void printAdjList(DW_Edge[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + " : ");
            DW_Edge temp = adjList[i];
            while (temp != null) {
                System.out.print("(" + temp.vertex + "," + temp.weight + ")");
                if (temp.next != null) System.out.print(" , ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Weighted out-degree = sum of outgoing edge weights
    public static int outDegreeEdgeWeight(DW_Edge[] adjList, int vertex) {
        int count = 0;
        DW_Edge temp = adjList[vertex];
        while (temp != null) {
            count += temp.weight;
            temp = temp.next;
        }
        return count;
    }

    // Weighted in-degree = sum of incoming edge weights
    public static int inDegreeEdgeWeight(DW_Edge[] adjList, int vertex) {
        int count = 0;
        for (int i = 0; i < adjList.length; i++) {
            DW_Edge temp = adjList[i];
            while (temp != null) {
                if (temp.vertex == vertex) count += temp.weight;
                temp = temp.next;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        DW_Edge[] adjList = new DW_Edge[n];

        addEdgeDWG(adjList, 0, 1, 2);
        addEdgeDWG(adjList, 0, 4, 4);
        addEdgeDWG(adjList, 1, 5, 7);
        addEdgeDWG(adjList, 2, 3, 3);
        addEdgeDWG(adjList, 2, 4, 5);
        addEdgeDWG(adjList, 4, 5, 1);
        addEdgeDWG(adjList, 1, 2, 6);
        addEdgeDWG(adjList, 4, 1, 2);

        printAdjList(adjList);

        int v = 4;
        System.out.println("The in-degree-edges-weight of vertex " + v + " : " + inDegreeEdgeWeight(adjList, v));
        System.out.println("The out-degree-edges-weight of vertex " + v + " : " + outDegreeEdgeWeight(adjList, v));
    }
}
