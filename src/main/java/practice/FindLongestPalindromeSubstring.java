package practice;

public class FindLongestPalindromeSubstring {

    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    String longestPalindromicSubstring(String S) {
        // WRITE YOUR CODE HERE

        // edge cases
        if (S == null || S.length() == 0 || S.length() == 1) {
            return S;
        }

        // two pointersto keep track of the substring
        int start = 0, end = 1, n = S.length();
        char[] sarray = S.toCharArray();
        int maxLen = Integer.MIN_VALUE, maxStart = start;
        while (end < n) {
            int prevEnd = end;
            // consider duplicate charsin a row
            while (end < n && sarray[end - 1] == sarray[end]) {
                end++;
            }

            while (start > 0 && end < n && sarray[start - 1] == sarray[end]) {
                start--;
                end++;
            }

            if (end - start > maxLen) {
                maxLen = end - start;
                maxStart = start;
            }

            // update the new start position
            start = prevEnd;
            end = start + 1;
        }

        return S.substring(maxStart, maxStart + maxLen);
    }
    // METHOD SIGNATURE ENDS
}

