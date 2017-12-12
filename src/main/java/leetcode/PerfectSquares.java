package leetcode;

public class PerfectSquares {

    public int numSquares(int n) {
        int m = (int)(Math.sqrt(n));
        Integer[][] memo = new Integer[n+1][m+1];
        return numSquares(n, m, memo);
    }

    private int numSquares(int n, int m, Integer[][] memo) {
        if (m * m > n) {
            return numSquares(n, (int)(Math.sqrt(n)), memo);
        }
        if (m == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        if (memo[n][m] != null) {
            return memo[n][m];
        }
        int min = Math.min(numSquares(n - m * m, m, memo) + 1, numSquares(n, m-1, memo));
        memo[n][m] = min;
        return min;
    }
}