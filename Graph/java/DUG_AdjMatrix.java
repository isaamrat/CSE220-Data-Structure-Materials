public class DUG_AdjMatrix {
    public static void addEdgeDUG(int[][] adjMatrix, int src, int dest) {
        adjMatrix[src][dest] = 1;
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

    public static int countInDegree(int[][] adjMatrix, int vertex) {
        int count = 0;
        for (int i = 0; i < adjMatrix[vertex].length; i++) {
            count += adjMatrix[i][vertex];
        }
        return count;
    }

    public static int countOutDegree(int[][] adjMatrix, int vertex) {
        int count = 0;
        for (int i = 0; i < adjMatrix[vertex].length; i++) {
            count += adjMatrix[vertex][i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] adjMatrix = new int[6][6];
        addEdgeDUG(adjMatrix, 0, 1);
        addEdgeDUG(adjMatrix, 0, 4);
        addEdgeDUG(adjMatrix, 1, 5);
        addEdgeDUG(adjMatrix, 2, 3);
        addEdgeDUG(adjMatrix, 2, 4);
        addEdgeDUG(adjMatrix, 4, 5);
        addEdgeDUG(adjMatrix, 1, 2);
        addEdgeDUG(adjMatrix, 4, 1);

        printAdjMatrix(adjMatrix);
        System.out.println("The in-degree of vertex 2 : " + countInDegree(adjMatrix, 2));
        System.out.println("The out-degree of vertex 2 : " + countOutDegree(adjMatrix, 2));
    }
}
