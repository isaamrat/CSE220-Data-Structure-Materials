public class graphAdjMatrix {
    public static void add_edge(int[][] graph, int src, int des, int wei){
        graph[src][des] = wei;
    }
    public static void main(String[] args) {
        int[][] graphMatrix = new int[5][5];
        add_edge(graphMatrix, 0, 1, 3);
        add_edge(graphMatrix, 0, 3, 8);
        add_edge(graphMatrix, 0, 4, 6);
        add_edge(graphMatrix, 1, 2, 5);
        add_edge(graphMatrix, 2, 3, 9);
        add_edge(graphMatrix, 3, 4, 7);
        
    }
}
