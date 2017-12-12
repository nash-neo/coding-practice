package leetcode;

public class RegexMatch {

    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        memo[s.length()][p.length()] = true;
        for (int i = 0; i < s.length(); ++i) {
            memo[i][p.length()] = false;
        }
        for (int j = p.length() -2; j >=0; --j) {
            if (p.charAt(j+1) != '*') {
                memo[s.length()][j] = false;
                continue;
            }
            memo[s.length()][j] = (memo[s.length()][j+2] == true) ? true : false;
        }
        for (int i = s.length() -1; i >= 0; --i) {
            for (int j = p.length() - 1; j >=0; --j) {
                if (j+1 < p.length() && p.charAt(j+1) == '*') {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        memo[i][j] = memo[i + 1][j] || memo[i][j + 2];
                    }
                    else {
                        memo[i][j] = memo[i][j + 2];
                    }
                }
                else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    memo[i][j] = memo[i + 1][j + 1];
                }
                else {
                    memo[i][j] = false;
                }
            }
        }
        return memo[0][0];
    }
}
