import java.util.*;

class Solution {

    static class Pair {
        String node;
        double cost;

        public Pair(String node, double cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public double bfs(Map<String, List<Pair>> adj, List<String> query) {
        Set<String> visited = new HashSet<>();
        String start = query.get(0);
        String end = query.get(1);

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 1.0));
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                String node = current.node;
                double cost = current.cost;

                if (!adj.containsKey(node)) continue;
                if (node.equals(end)) return cost;

                for (Pair neighbor : adj.get(node)) {
                    if (!visited.contains(neighbor.node)) {
                        queue.offer(new Pair(neighbor.node, cost * neighbor.cost));
                        visited.add(neighbor.node);
                    }
                }
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Adjacency list representation
        Map<String, List<Pair>> adj = new HashMap<>();

        adj.put("A", Arrays.asList(new Pair("B", 2.0), new Pair("C", 3.0)));
        adj.put("B", Arrays.asList(new Pair("D", 4.0)));
        adj.put("C", Arrays.asList(new Pair("D", 5.0)));
        adj.put("D", Collections.emptyList());

        List<String> query = Arrays.asList("A", "D");

        double result = solution.bfs(adj, query);

        System.out.println("Result: " + result);
    }
}
