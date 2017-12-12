package leetcode;

public class LongestValidParentheses {
    //edge case: "", "(", ")", "(((", ")))"
    //regular case: ")()()("
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        if (s.length() == 0) {
            return maxLength;
        }
        int[] longest = new int[s.length()];
        longest[0] = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                longest[i] = 0;
            }
            else { //s[i] == ')'
                if (s.charAt(i-1) == '(') {
                    longest[i] = 2 ;
                    if (i-2 >= 0) {
                        longest[i] += longest[i-2];
                    }
                    if (longest[i] > maxLength) {
                        maxLength = longest[i];
                    }
                }
                else { //s[i-1] == ')'
                    if (i - longest[i-1] -1 >=0 && s.charAt(i-longest[i-1] -1) == '(') {
                        longest[i] = 2 + longest[i-1];
                        if (i - longest[i-1] - 2 >= 0) {
                            longest[i] += longest[i-longest[i-1] -2];
                        }
                        maxLength = Math.max(maxLength, longest[i]);
                    }
                    else {
                        longest[i] = 0;
                    }
                }
            }
        }
        return maxLength;
    }
}
