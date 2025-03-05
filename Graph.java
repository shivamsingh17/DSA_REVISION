import java.util.*;

class Solution {
    // for basic version can take curr path as boolean 0/1 
    boolean dfs_dir(int node, List<List<Integer>> adj, boolean[] visited, boolean[] cur_path){
                visited[node] = true;
                cur_path[node] = true;
        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                boolean ans = dfs(nbr, adj, visited, node, cur_path);
                if (ans) return true;  // Found a cycle
            } 
            else if (cur_path[nbr]) {// nbr already in cur path
                return true; 
            }
        }
        cur_path[node] = false; // resettimg for backstracking 
        return false;
        
    }
    
    // Function to detect cycle in an undirected graph.
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, int parent) {
        visited[node] = true;

        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                boolean ans = dfs(nbr, adj, visited, node);
                if (ans) return true;  // Found a cycle
            } 
            else if (nbr != parent) {
                return true; // Back edge found?, cycle detected
            }
        }
        return false;
    }

    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] cp = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, -1)) {// pass cp for dir
                    return true;
                }
            }
        }
        return false;
    }

    // Main function for testing
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to represent an undirected graph
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1); // Adding a back edge to form a cycle
        adj.get(1).add(4);

        Solution sol = new Solution();
        System.out.println("Cycle Detected: " + sol.isCycle(V, adj));
    }
}
