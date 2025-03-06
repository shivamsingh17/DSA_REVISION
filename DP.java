import java.util.Arrays;

class DP {
int [10001][10001]dp;//init with -1
// lis 
    int rec(int i, int j){ // lcs
        //pruning 
        // base case 
        if(i>=n || j>=m) return 0;
        
        if(dp[i][j]!= -1){
            return dp[i][j];
        }
        int ans = 0;
        ans = max(ans, rec(i+1, j));
                ans = max(ans, rec(i, j+1));
                if(a[i]==b[j])
                ans = max(ans, 1 + rec(i +1, j + 1));
return dp[i][j] = ans;
    }
    
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        return maxSide * maxSide;
    }
}
    
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
        rec(0,0);
    }
}
