package dfs;

class DU_Edge {
    int vertex;
    DU_Edge next;

    DU_Edge(int dest) {
        vertex = dest;
        next = null;
    }
}

class DUG_AdjList {

    // Add a directed edge: src -> dest
    public static void addEdgeDUG(DU_Edge[] adjList, int src, int dest) {
        DU_Edge head = adjList[src];
        DU_Edge newEdge = new DU_Edge(dest);
        newEdge.next = head;
        adjList[src] = newEdge;
    }

    public static void printAdjList(DU_Edge[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + " : ");
            DU_Edge temp = adjList[i];
            while (temp != null) {
                System.out.print(temp.vertex);
                if (temp.next != null) System.out.print(" , ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Out-degree: number of neighbors in list i
    public static int countOutDegree(DU_Edge[] adjList, int target) {
        int count = 0;
        DU_Edge temp = adjList[target];
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // In-degree: count how many lists contain 'vertex'
    public static int countInDegree(DU_Edge[] adjList, int target) {
        int count = 0;
        for (int i = 0; i < adjList.length; i++) {
            DU_Edge temp = adjList[i];
            while (temp != null) {
                if (temp.vertex == target) count++;
                temp = temp.next;
            }
        }
        return count;
    }

}
