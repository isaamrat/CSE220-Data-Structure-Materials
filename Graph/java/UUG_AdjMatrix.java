public class UUG_AdjMatrix {
    public static void addEdgeUUG(int[][] adjMatrix, int src, int dest){
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
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
    public static int countDegree(int[][] adjMatrix, int vertex){
        int count = 0;
        for (int i = 0; i < adjMatrix[vertex].length; i++) {
            count += adjMatrix[vertex][i];
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] adjMatrix = new int[6][6];
        addEdgeUUG(adjMatrix, 0, 5);
        addEdgeUUG(adjMatrix, 0, 4);
        addEdgeUUG(adjMatrix, 0, 2);
        addEdgeUUG(adjMatrix, 5, 4);
        addEdgeUUG(adjMatrix, 5, 1);
        addEdgeUUG(adjMatrix, 1, 4);
        addEdgeUUG(adjMatrix, 2, 4);
        addEdgeUUG(adjMatrix, 2, 3);

        printAdjMatrix(adjMatrix);
        System.out.println("The degree of vertex 4 : "+ countDegree(adjMatrix, 4));
    }
}