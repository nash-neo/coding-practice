package leetcode;

public class LongestLineOfConsecutiveOneInMatrix {

    private int[][] steps = {{0,-1},{-1,-1},{-1,0},{-1,1}};

    //scan each element in M,
    //  if it is 1
    //    for each directions,
    //      if previous element exists and is 1, ++dirCount and compare with maxCount,
    //      else reset dirCount = 1;
    //  else it is 0
    //    nothing
    public int longestLine(int[][] M) {
        int m = M.length;
        if (m == 0) {
            return 0;
        }
        int n = M[0].length;
        int max = 0;
        int[][] currCounts = new int[n][4]; //default to 0
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j< n; ++j) {
                if (M[i][j] == 1) {
                    for (int k = 0; k < steps.length; ++k) {
                        int prevI = i + steps[k][0];
                        int prevJ = j + steps[k][1];
                        if (prevI >= 0 && prevI < m && prevJ >= 0 && prevJ < n && M[prevI][prevJ] == 1) {
                            currCounts[j][k] = currCounts[prevJ][k] + 1;
                        }
                        else {
                            currCounts[j][k] = 1;
                        }
                        max = Math.max(currCounts[j][k], max);
                    }
                }
            }
        }
        return max;
    }
}