package leetcode;

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()+1][p.length()+1];
        return isMatch(s, 0, p, 0, memo);
    }

    private boolean isMatch(String s, int i, String p, int j, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == s.length()) {
            for (int k = j; k < p.length(); ++k) {
                if (p.charAt(k) != '*') {
                    memo[i][j] = false;
                    return false;
                }
            }
            memo[i][j] = true;
            return true;
        }
        if (j == p.length() && i < s.length()) {
            memo[i][j] = false;
            return false;
        }
        if (p.charAt(j) == '*') {
            for (int k = i; k <= s.length(); ++k) {
                if (isMatch(s, k, p, j+1, memo)) {
                    memo[i][j] = true;
                    return true;
                }
            }
            memo[i][j] = false;
            return false;
        }
        else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            memo[i][j] = isMatch(s, i+1, p, j+1, memo);
            return memo[i][j];
        }
        else { //s[i] != p[j]
            memo[i][j] = false;
            return false;
        }
    }
}
