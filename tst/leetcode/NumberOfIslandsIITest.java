package leetcode;

import org.junit.Test;

public class NumberOfIslandsIITest {

    private NumberOfIslandsII numberOfIslandsII = new NumberOfIslandsII();

    @Test
    public void test() {
        System.out.println(numberOfIslandsII.numIslands2(3, 3, new int[][] {{0,0}, {0,1}, {1,2}, {2,1}}));
    }
}
