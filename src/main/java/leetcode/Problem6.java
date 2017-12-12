package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem6 {
    public String convert(String s, int numRows) {
        List<LinkedList<Character>> lists = new ArrayList<>(numRows);
        IntStream.range(0, numRows).forEach(i -> lists.add(new LinkedList<>()));
        boolean shouldGoDown = false;
        for (int i = 0, row = 0; i < s.length(); ++i) {
            lists.get(row).addLast(s.charAt(i));
            if (numRows == 1) continue;
            if (row == 0 || row == numRows -1) {
                shouldGoDown = !shouldGoDown;
            }
            row = shouldGoDown ? row + 1 : row -1;
        }
        StringBuilder stringBuilder = new StringBuilder(s.length());
        lists.forEach(list -> list.forEach(ch -> stringBuilder.append(ch)));
        return stringBuilder.toString();
    }
}
