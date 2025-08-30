public class DWG_AdjMatrix {
    public static void addEdgeDWG(int[][] adjMatrix, int src, int dest, int weight) {
        adjMatrix[src][dest] = weight;
    }

    public static void printAdjMatrix(int[][] adjMatrix) {
        int n = adjMatrix.length;

        // Print column headers
        System.out.print("    ");
        for (int j = 0; j < n; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        // Print separator
        System.out.print("   ");
        for (int j = 0; j < n; j++) {
            System.out.print("--");
        }
        System.out.println();

        // Print rows with row labels
        for (int i = 0; i < n; i++) {
            System.out.print(i + " | "); // Row label
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int inDegreeEdgeWeight(int[][] adjMatrix, int vertex) {
        int count = 0;
        for (int i = 0; i < adjMatrix[vertex].length; i++) {
            count += adjMatrix[i][vertex];
        }
        return count;
    }

    public static int outDegreeEdgeWeight(int[][] adjMatrix, int vertex) {
        int count = 0;
        for (int i = 0; i < adjMatrix[vertex].length; i++) {
            count += adjMatrix[vertex][i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] adjMatrix = new int[6][6];
        addEdgeDWG(adjMatrix, 0, 1, 2);
        addEdgeDWG(adjMatrix, 0, 4, 4);
        addEdgeDWG(adjMatrix, 1, 5, 7);
        addEdgeDWG(adjMatrix, 2, 3, 3);
        addEdgeDWG(adjMatrix, 2, 4, 5);
        addEdgeDWG(adjMatrix, 4, 5, 1);
        addEdgeDWG(adjMatrix, 1, 2, 6);
        addEdgeDWG(adjMatrix, 4, 1, 2);

        printAdjMatrix(adjMatrix);
        System.out.println("The in-degree-edges-weight of vertex 4 : " + inDegreeEdgeWeight(adjMatrix, 4));
        System.out.println("The out-degree-edges-weight of vertex 4 : " + outDegreeEdgeWeight(adjMatrix, 4));
    }
}
