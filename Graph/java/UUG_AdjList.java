class UU_Edge {
    int vertex;
    UU_Edge next;

    UU_Edge(int dest) {
        vertex = dest;
        next = null;
    }
}

public class UUG_AdjList {
    public static void addEdgeUUG(UU_Edge[] adjList, int src, int dest) {
        UU_Edge temp = adjList[src];
        UU_Edge newEdge = new UU_Edge(dest);
        newEdge.next = temp;
        adjList[src] = newEdge;

        temp = adjList[dest];
        newEdge = new UU_Edge(src);
        newEdge.next = temp;
        adjList[dest] = newEdge;
    }

    public static void printAdjList(UU_Edge[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + " : ");
            UU_Edge temp = adjList[i];
            while (temp != null) {
                System.out.print(temp.vertex);
                if (temp.next != null) {
                    System.out.print(" , ");
                }
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static int countDegree(UU_Edge[] adjList, int target) {
        int count = 0;
        UU_Edge temp = adjList[target];
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        UU_Edge[] adjList = new UU_Edge[6];
        addEdgeUUG(adjList, 0, 5);
        addEdgeUUG(adjList, 0, 4);
        addEdgeUUG(adjList, 0, 2);
        addEdgeUUG(adjList, 5, 4);
        addEdgeUUG(adjList, 5, 1);
        addEdgeUUG(adjList, 1, 4);
        addEdgeUUG(adjList, 2, 4);
        addEdgeUUG(adjList, 2, 3);

        printAdjList(adjList);
        System.out.println("The degree of vertex 4 : " + countDegree(adjList, 4));
    }
}
