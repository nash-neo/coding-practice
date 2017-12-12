package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Longest Substring Without Repeating Characters
public class Problem3 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); ++i) {
            Set<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); ++j) {
                if(set.contains(s.charAt(j))) {
                    break;
                }
                else {
                    set.add(s.charAt(j));
                }
            }
            if (set.size() > max) {
                max = set.size();
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {

        List<Integer> ending = new ArrayList<>(s.length());
        ending.add(1);
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); ++i) {
            int length1 = Integer.MAX_VALUE;
            if (map.containsKey(s.charAt(i))) {
                length1 = i - map.get(s.charAt(i));
            }
            int length2 = ending.get(i - 1) + 1;
            int length = Math.min(length1, length2);
            ending.add(length);
            map.put(s.charAt(i), i);
            max = Math.max(max, length);
        }
        return max;
    }

}
