package leetcode;

import org.junit.Test;

public class Problem3Test {

    private Problem3 p = new Problem3();

    @Test
    public void test2() {
        String input = "abcdae";
        int max = p.lengthOfLongestSubstring2(input);
        System.out.println(max);
    }
}
