import java.util.*;

class MinCostToDisconnectLeaves {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static int minCostToDisconnectLeaves(Map<Integer, List<Edge>> tree, int root) {
        int minCost = 0;

        for (int node : tree.keySet()) {
            List<Edge> edges = tree.get(node);
            if (edges.size() == 1 && node != root) { // Leaf node (only 1 edge and not root)
                minCost += edges.get(0).cost;
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> tree = new HashMap<>();

        // Building the tree (Adjacency List)
        tree.put(6, Arrays.asList(new Edge(4, 5), new Edge(2, 1)));
        tree.put(4, Arrays.asList(new Edge(6, 5), new Edge(1, 10)));
        tree.put(2, Arrays.asList(new Edge(6, 1)));
        tree.put(1, Arrays.asList(new Edge(4, 10)));

        System.out.println("Minimum cost to disconnect leaves: " + minCostToDisconnectLeaves(tree, 6));
    }
}
