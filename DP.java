import java.util.Arrays;

class DP {
    // Maximal Square (DP) 
    
    static int countPaths(int M, int N) {  // bottom left to bottom right
        int[][] dp = new int[M][N];

        // Base case: The bottom-left corner has one way to start
        dp[M - 1][0] = 1;

        // Iterate over the grid in a bottom-up manner
        for (int j = 0; j < N; j++) { // Columns
            for (int i = M - 1; i >= 0; i--) { // Rows (bottom to top)
                if (j == 0 && i == M - 1) continue; // Skip starting cell

                // Right move
                if (j > 0) dp[i][j] += dp[i][j - 1];

                // Up move
                if (i > 0) dp[i][j] += dp[i - 1][j];

                // Down move
                if (i < M - 1) dp[i][j] += dp[i + 1][j];
            }
        }

        return dp[M - 1][N - 1]; // Bottom-right corner result
    }

    public static void main(String[] args) {
        int M = 3, N = 4; // Example grid size
        System.out.println("Number of distinct paths: " + countPaths(M, N));
    }
}
