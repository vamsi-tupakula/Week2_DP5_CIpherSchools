public class UniquePath {
    private int totalPaths = 0;

    public int getPaths(int m, int n) {
        moveHelper(m, n, 0, 0);
        return totalPaths;
    }

    private void moveHelper(int m, int n, int i, int j) {
        if (i >= m || j >= n) {
            return;
        }

        if (i == m - 1 && j == n - 1) {
            totalPaths++;
            return;
        }

        moveHelper(m, n, i + 1, j);
        moveHelper(m, n, i, j + 1);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        
    }
}
