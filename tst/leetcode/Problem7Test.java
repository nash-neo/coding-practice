package leetcode;

import org.junit.Test;

public class Problem7Test {
    private Problem7 problem7 = new Problem7();

    @Test
    public void test() {
        int x = problem7.reverse(-2147483648);
        System.out.println(x);
    }
}
