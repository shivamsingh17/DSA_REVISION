
import java.util.*;

public class Solution {
    public static List<Integer> getVisibleProfilesCount(int nodes, List<Integer> u, List<Integer> v, List<Integer> queries) {
        int[] parent = new int[nodes + 1];
        int[] size = new int[nodes + 1];

        // Initialize DSU
        for (int i = 1; i <= nodes; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Find with path compression
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // Union by size
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }

        // Build graph
        for (int i = 0; i < u.size(); i++) {
            union(u.get(i), v.get(i));
        }

        // Answer queries
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            result.add(size[find(q)]);
        }

        return result;
    }
}
