package leetcode;

public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        if (A.indexOf(B) != -1) {
            return 1;
        }
        else if ((A+A).indexOf(B) != -1) {
            return 2;
        }
        String[] strs = B.split(A);
        if (strs.length <= 1) {
            return -1;
        }
        for (int i = 1; i <= strs.length-2; ++i) {
            if (!strs[i].isEmpty()) {
                return -1;
            }
        }
        if (!A.endsWith(strs[0]) || !A.startsWith(strs[strs.length-1])) {
            return -1;
        }
        return strs[0].isEmpty() ? strs.length : strs.length+1;
    }
}
