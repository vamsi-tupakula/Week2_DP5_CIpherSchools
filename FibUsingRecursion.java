import java.util.Arrays;

public class FibUsingRecursion {
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n -1 ) + fib(n - 2);
    }

    public static int fibUsingTopDown(int n, int[] dp) {
        if (n < 2) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int res = fibUsingTopDown(n - 1, dp) + fibUsingTopDown(n - 2, dp);
        dp[n] = res;

        return dp[n];
    }

    public static int fibUsingBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        int[] dp = new int[100];
        Arrays.fill(dp, -1);
        System.out.println(fibUsingTopDown(7, dp));
        System.out.println(fibUsingBottomUp(8));
    }
}
