package leetcode;

public class MinWindowSubstring {
    //"a", "a"
    //"ababcd", "abc"
    //"", "a"
    //"a", ""
    //"", ""
    //"ababcd", "abca"
    public String minWindow(String s, String t) {
        int[] counters = new int[256]; //assume char 0-255
        int counter = 0;
        if (t.isEmpty()) {
            return "";
        }
        for (int i = 0; i < t.length(); ++i) {
            ++counters[t.charAt(i)];
            ++counter;
        }
        int last = 0;
        int minLength = Integer.MAX_VALUE;
        int minBegin = 0;
        for (int end = 0; end < s.length(); ++end) {
            if (counters[s.charAt(end)] > 0) {
                --counter; //only decrement the first time meet a char in t
            }
            --counters[s.charAt(end)];
            if (counter == 0) {//contains all chars in t, find the largest begin
                for (int begin = last; begin <= end; ++begin) {
                    ++counters[s.charAt(begin)];
                    if (counters[s.charAt(begin)] > 0) {
                        ++counter; //exclude a char in t
                        last = begin+1;
                        int length = end - begin + 1;
                        if (length < minLength) {
                            minLength = length;
                            minBegin = begin;
                        }
                        break;
                    }
                }
            }

        }
        if (minLength == Integer.MAX_VALUE)
        {
            return "";
        }
        return s.substring(minBegin, minBegin+minLength);
    }
}
