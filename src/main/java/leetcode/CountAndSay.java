package leetcode;

public class CountAndSay {

    public String countAndSay(int n) {
        String s = "1";
        if (n == 1) {
            return s;
        }
        for (int i = 2; i <=n; ++i) {
            StringBuilder newStrBuilder = new StringBuilder();
            char curr = s.charAt(0);
            int count = 1;
            for (int j = 1; j < s.length(); ++j) {
                if (s.charAt(j) == curr) {
                    ++count;
                }
                else {
                    newStrBuilder.append((char)('0' + count));
                    newStrBuilder.append(curr);
                    count = 1;
                    curr = s.charAt(j);
                }
            }
            newStrBuilder.append((char)('0' + count));
            newStrBuilder.append(curr);
            s = newStrBuilder.toString();
        }
        return s;
    }
}
