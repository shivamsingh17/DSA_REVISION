import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTreePairFinder {
    static Map<Integer, List<TreeNode>> levelNodes = new HashMap<>();
    static Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    static Map<TreeNode, Integer> depthMap = new HashMap<>();

    public static boolean findPair(TreeNode root, int target, int d) {
        if (root == null) return false;

        // Step 1: Populate levelNodes, parentMap, and depthMap
        bfs(root);

        // Step 2: Check all possible pairs
        List<TreeNode> nodes = new ArrayList<>(depthMap.keySet());

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                TreeNode node1 = nodes.get(i);
                TreeNode node2 = nodes.get(j);

                if (node1.val + node2.val == target && depthMap.get(node1) != depthMap.get(node2)) {
                    if (findDistance(node1, node2) == d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // BFS to populate levelNodes, parentMap, and depthMap
    private static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        parentMap.put(root, null);
        depthMap.put(root, 0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int depth = depthMap.get(node);

            levelNodes.putIfAbsent(depth, new ArrayList<>());
            levelNodes.get(depth).add(node);

            if (node.left != null) {
                queue.offer(node.left);
                parentMap.put(node.left, node);
                depthMap.put(node.left, depth + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                parentMap.put(node.right, node);
                depthMap.put(node.right, depth + 1);
            }
        }
    }

    // Find Lowest Common Ancestor (LCA)
    private static TreeNode findLCA(TreeNode u, TreeNode v) {
        Set<TreeNode> ancestors = new HashSet<>();
        while (u != null) {
            ancestors.add(u);
            u = parentMap.get(u);
        }
        while (v != null) {
            if (ancestors.contains(v)) return v;
            v = parentMap.get(v);
        }
        return null;
    }

    // Compute distance using LCA
    private static int findDistance(TreeNode u, TreeNode v) {
        TreeNode lca = findLCA(u, v);
        return depthMap.get(u) + depthMap.get(v) - 2 * depthMap.get(lca);
    }

    // Test case
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(3);

        int target = 9;
        int d = 2;
        System.out.println("Found Pair: " + findPair(root, target, d));
    }
}
