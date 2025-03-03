import java.util.*;

class PrimMST {
    private static final int V = 6; // Number of vertices

    // Function to select the vertex with the minimum key value
    private static int selectMinVertex(int[] value, boolean[] setMST) {
        int minimum = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < V; i++) {
            if (!setMST[i] && value[i] < minimum) {
                vertex = i;
                minimum = value[i];
            }
        }
        return vertex;
    }

    // Function to find MST using Prim's algorithm
    public static void findMST(int[][] graph) {
        int[] parent = new int[V]; // Stores MST
        int[] value = new int[V]; // Used for edge relaxation
        boolean[] setMST = new boolean[V]; // TRUE -> Vertex is included in MST

        Arrays.fill(value, Integer.MAX_VALUE);
        Arrays.fill(setMST, false);

        // Assuming start point as Node-0
        parent[0] = -1; // Start node has no parent
        value[0] = 0; // Start node has value 0 to get picked first

        // Form MST with (V-1) edges
        for (int i = 0; i < V - 1; i++) {
            // Select best Vertex by applying the greedy method
            int U = selectMinVertex(value, setMST);
            setMST[U] = true; // Include new Vertex in MST

            // Relax adjacent vertices (not yet included in MST)
            for (int j = 0; j < V; j++) {
                /* 3 constraints to relax:
                   1. Edge is present from U to j.
                   2. Vertex j is not included in MST.
                   3. Edge weight is smaller than the current edge weight. */
                if (graph[U][j] != 0 && !setMST[j] && graph[U][j] < value[j]) {
                    value[j] = graph[U][j];
                    parent[j] = U;
                }
            }
        }

        // Print MST
        for (int i = 1; i < V; i++) {
            System.out.println("U->V: " + parent[i] + "->" + i + "  wt = " + graph[parent[i]][i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 6, 0, 0, 0},
            {4, 0, 6, 3, 4, 0},
            {6, 6, 0, 1, 8, 0},
            {0, 3, 1, 0, 2, 3},
            {0, 4, 8, 2, 0, 7},
            {0, 0, 0, 3, 7, 0}
        };

        findMST(graph);
    }
}
