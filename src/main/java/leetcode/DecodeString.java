package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        Deque<Integer> counts = new LinkedList<>();
        Deque<StringBuilder> sbs = new LinkedList<>();
        counts.push(1);
        sbs.push(new StringBuilder());
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                counts.push(ch - '0');
            }
            else if (ch == '[') {
                sbs.push(new StringBuilder());
            }
            else if (ch == ']') {
                int count = counts.pop();
                StringBuilder sb = sbs.pop();
                for (int i = 0; i < count; ++i) {
                    sbs.peek().append(sb);
                }
            }
            else {
                sbs.peek().append(ch);
            }
        }
        //pop the root, count is alway 1
        return sbs.peek().toString();
    }
}
